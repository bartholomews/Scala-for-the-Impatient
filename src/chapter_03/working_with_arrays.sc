
println("========================= 1 ============================")
/* 1.

Write a code snippet that sets 'a' to an array of 'n'
random integers between 0 (inclusive) and 'n' (exclusive).
 */

def createArray(n: Int):Array[Int] = {
  val a = new Array[Int](n)
  for(e <- a.indices) a(e) = scala.util.Random.nextInt(n)
  a
}

println("========================= 2 ============================")
/* 2.

Write a loop that swaps adjacent elements of an array of
integers. For example, Array(1, 2, 3, 4, 5)
becomes Array(2, 1, 4, 3, 5).
 */

def swapAdj(a: Array[Int]) = {
  def swap(i: Int, j: Int) = {
    val t = a(i); a(i) = a(j); a(j) = t
  }
  for(i <- 0 until a.length -1 by 2) {
    swap(i, i + 1)
  }
}

val a = Array(1, 2, 3, 4)
swapAdj(a)
val swapped = a

println("========================= 3 ============================")
/* 3.

Repeat the preceding assignment, but produce a new array
with the swapped values. Use for/yield.
 */

def swapAdjNew(a: Array[Int]): Array[Int] = {
  (for(e <- a.indices) yield {
    if(e == a.length-1) a(e)
    else if (e % 2 == 0) a(e + 1)
    else a(e - 1)
  }).toArray
}

// http://stackoverflow.com/a/10160082
(for {b <- a.grouped(2); c <- b.reverse } yield c).toArray

val c = swapAdjNew(Array(1, 2, 3))
val d = swapAdjNew(Array(1, 2, 3, 4))


println("========================= 4 ============================")
/* 4.

Given an array of integers, produce a new array that contains
all positive values of the original array, in their original
order, followed by all values that are zero or negative,
in their original order.
 */

val b = Array(2, 4, -1, 9, 0, -10, 3, 2, -10, 3, 0, -2, -3)

b.filter(n => n > 0).++(b.filter(n => n <= 0))

println("========================= 5 ==============================")
/* 5.

How do you compute the average of an Array[Double]?
 */

def avg(a: Array[Double]): Double = a.sum / a.length

val aDouble = Array[Double](1.0, 2.0, 3.0)
avg(aDouble)

println("========================= 6 ============================")

/* 6.

How do you rearrange the elements of an Array[Int] so that
they appear in reverse sorted order?
How do you do the same with an ArrayBuffer[Int]?
 */

val aInt = Array[Int](1, 5, 2, 4, 5)
scala.util.Sorting.quickSort(aInt)
aInt.reverse

val aBuffInt = collection.mutable.ArrayBuffer[Int](1, 5, 2, 4, 5)
var flag = false
while(!flag) {
  flag = true
  for (i <- 0 until aBuffInt.length - 1 if aBuffInt(i) < aBuffInt(i + 1)) {
    flag = false
    val temp = aBuffInt(i); aBuffInt(i) = aBuffInt(i + 1); aBuffInt(i + 1) = temp
  }
}

aBuffInt

println("========================= 7 ============================")

/* 7.

Write a code snippet that produces all values from an array
with duplicates removed. (Hint: Look at Scaladoc).
 */

val seven = Array(1, 1, 2, 3, 3, 4, 4, 4, 4, 5, 6, 5, 6, 1, 2, 3, 7).distinct

println("========================= 8 ============================")
/* 8.

Rewrite the example at the end of Section 3.4
  [given an array buffer of integers,
   we want to remove all but the first negative number:

  var first = true
  var n = a.length
  var i = 0
  while (i < n) {
    if (a(i) >= 0) i += 1
    else {
      if (first) { first = false; i += 1 }
      // it's inefficient to remove elements in an array buffer
      else { a.remove(i); n -= 1 }
    }
  }

  var first = false
  // first collect the indexes to keep
  val indexes = for (i <- 0 until a.length if first || a(i) >= 0) yield {
      if (a(i) < 0) first = false; i
  }
  // then move the elements where they belong, and trim the end
  for (j <- 0 until indexes.length) a(j) = a(indexes(j))
  a.trimEnd(a.length - indexes.length)

Collect indexes of the negative elements, reverse the sequence,
drop the last index, and call a.remove(i) for each index.
Compare the efficiency of this approach with the two approaches
in Section 3.4.
 */

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
val eight = ArrayBuffer(1, 2, 3, -1, -2, -3, 4, -2)

val negIndexes = (for(i <- eight.indices if eight(i) < 0) yield i).reverse.dropRight(1)
for(i <- negIndexes) eight.remove(i)

eight

println("========================= 9 ============================")
/* 9.

Make a collection of all time zones returned by
java.util.TimeZone.getAvailableIDs that are in America.
Strip off the "America/" prefix and sort the result.
 */

val time: Array[String] =
  java.util.TimeZone.getAvailableIDs()
    .filter(s => s.take(8) == "America/")
    .map(s => s.drop(8))

println("========================= 10 ============================")
/* 10.

Import java.awt.datatransfer._ and make an object
of type SystemFlavorMap with the call:
val flavors = SystemFlavorMap.getDefaultFlavorMap().
                        asInstanceOf[SystemFlavorMap]
Then call the getNativesForFlavor method with parameter
DataFlavor.imageFlavor and get the return value as a
Scala buffer. (Why this obscure class?
It's hard to find uses of java.util.List in the standard
Java library).
 */

import java.awt.datatransfer._

// import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.JavaConversions.asScalaBuffer

val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
val array: mutable.Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)