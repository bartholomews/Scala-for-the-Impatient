#### Chapter 1 - The Basics

##### *Notes*

Key points:

+ In the REPL, you can use *tab completion* for method names.

+ Use a `val` unless you really need to change the contents.

+ Scala relies on the underlying `java.lang.String` class for strings.
However, it augments that class with operations in the [`StringOps`][1] class.

```
"Hello".intersect("World)   // yields "lo"

"Harry".patch(1, "ung", 2) // yields "Hungry"

```

+ Similarly, there are classes `RichInt`, `RichDouble`, `RichChars`, and so on.

```
1.to(10) // the `Int` value `1` is converted to a `RichInt` and the `to` method applied to that value.
```

+ `BigInt` and `BigDecimal` for computations with an arbitrary (but finite) number of digits.
Backed by the `java.math.BigInteger` and `java.math.BigDecimal` classes, but can be used with mathematical operators
(which in Scala are actually methods)

+ The mathematical functions are defined in the `scala.math` package.

+ `Random` is a singleton random number generator object, defined in the `scala.util` package.

+ `"Hello"(4)`, which yields 'o', is a shortcut for `"Hello".apply(4)`
Using the `apply` method of a companion object is a common Scala idiom for constructing objects (avoiding `new`)









[1]: http://www.scala-lang.org/api/2.11.0-M4/#scala.collection.immutable.StringOps