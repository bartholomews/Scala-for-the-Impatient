#### Chapter 3 - Working with Arrays

##### *Notes*

Key points:

+ Use an `Array` if the length is fixed, and an `ArrayBuffer` is the length can vary.

```
import scala.collection.mutable.ArrayBuffer

// `new` can be omitted
// also `()` if initialised empty
val a = new ArrayBuffer[Int]()
// a: scala.collection.mutabl.ArrayBuffer[Int] = ArrayBuffer()

a += 1 // add one element
a += (1, 2, 3) // add multiple elements
a ++= Array(1, 2, 3) // append any scala.collection.TraversableOnce[T] 
					 // (of the same type) values
a.trimEnd(3) // remove the last 3 elements: 
			 // dropRight(n) would return a new ArrayBuffer and leave the old unchanged,
			 // trimEnd(n) returns Unit() and will modify it.

b.insert(2, 6)	// insert value 6 at index 2
b.insert(2, 7, 8, 9) // insert values 7, 8, 9 at index 2

b.remove(2) // remove value at index 2
b.remove(2, 3) // remove the elements and index 2, 3 and 4
 			   // (that is, starting at index 2, remove 3 elements)

val c = b.toArray	// convert to `Array`


```

+ Don't use `new` when supplying initial values:
(for both `Array` and `ArrayBuffer`, with `new` is expected a one `Int` arg for the length)

```
val a = new Array(1)
// a: Array[Nothing] = Array(null)

val a2 = new Array[Int](1)
// a2: Array[Int] = Array(0)

val a3 = new ArrayBuffer[Int](10)
// a3: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()

val b = new Array(1.0, 2.0, 3.0)
// error: too many arguments for constructor Array: (_length: Int)Array[T]

val c = Array(1)
// c: Array[Int] = Array(1)

val d = Array(1.0, 2.0, 3.0)
// d: Array[Double] = Array(1.0, 2.0, 3.0)

val e = d.toBuffer
// e: scala.collection.mutable.Buffer[Double] = ArrayBuffer(1.0, 2.0, 3.0)

```

`.sum`, `.min`, `.max` work for both `Array` and `ArrayBuffer`;
also `.sorted` and, with comparison function arg, `.sortWith((T, T) => Boolean)` which sorts an array and *returns* it, without modifying the original:

```
val b = ArrayBuffer(1, 7, 2, 9)
val bSorted = b.sortWith(_ < _)
// b is unchanged; bSorted is ArrayBuffer(1, 2, 7, 9)
```

You can sort an `Array`, but not an `ArrayBuffer` with `scala.util.Sorting.quickSort(arr)`

For the `min`, `max`, and `quickSort` methods, the element type must have a comparison operation. This is the case for numbers, strings, and other types with the `Ordered` trait.

```
val a = Array(1,2,3).mkString
// a: String = "123"

val b = Array(1,2,3).mkString()
// error: overloaded method mkString with alternatives: 
=> String <and>
(sep: String)String <and>
(start: String, sep: String, end: String)String

val c = Array(1,2,3).mkString(" and ")
// c: String = "1 and 2 and 3"

val d = Array(1,2,3,4).mkString("[START]","[SEP]",[END])
// d: String = "[START]1[SEP]2[SEP]3[END]4"

val e = Array(1,2,3).toString
// e: String = "[I@3e53390a"

val f = ArrayBuffer(1,2,3).toString
// f: String = "ArrayBuffer(1, 2, 3)"

```

Inside the JVM, a Scala `Array` is implemented as a Java array. [...] An array of `Int`, `Double`, or another equivalent of the Java primitive types is a primitive type array.

+ Use `()` to access elements.

+ Use `for (elem <- arr)` to traverse the elements.

```
for(elem <- arr) // traverse all the elements
for(elem <- arr).reverse // start from the end
for(elem <- 0 until arr.length) == for(elem <- arr.indices)
== for(elem <- 0 to arr.length -1)
for(elem <- 0 until (arr.length, 2))	// with step 2, note parenthesis
for(elem <- (0 until a.length).reverse) // note parenthesis

0 until 10 == 0.until(10)
// Range(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
// the `until` method belongs to the `RichInt` class.

```

+ Use `for (elem <- arr if...)...yield...` to transform into a new array.

The `for (...) yield` loop creates a new collection of the same type as the original collection.

```
for(elem <- a if elem % 2 == 0) yield 2 * elem

a.filter(_ % 2 == 0).map(2 * _)

a filter { _ % 2 == 0 } map { 2 * _ }
```

```
val matrix = Array.ofDim[Double](2, 3) // two rows, three columns
// m: Array[Array[Double]] = Array(Array(0.0, 0.0, 0.0), Array(0.0, 0.0, 0.0))

matrix(row)(column) = n

```

+ Scala and Java arrays are interoperable; with `ArrayBuffer`, use `scala.collection.JavaConversions`.