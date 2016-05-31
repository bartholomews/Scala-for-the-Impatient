#### Chapter 1 - The Basics

##### *Notes*

Key points:

+ In the REPL, you can use *tab completion* for method names.

+ Use a `val` unless you really need to change the contents.

+ Scala relies on the underlying [`java.lang.String`][12] class for strings.
However, it augments that class with operations in the [`StringOps`][1] class.

```
"Hello".intersect("World)   // yields "lo"

"Harry".patch(1, "ung", 2) // yields "Hungry"

```

+ Similarly, there are classes [`RichInt`][2], [`RichDouble`][3], [`RichChars`][4], and so on.

```
1.to(10) // the `Int` value `1` is converted to a `RichInt` and the `to` method applied to that value.
```

+ [`BigInt`][5] and [`BigDecimal`][6] for computations with an arbitrary (but finite) number of digits.
Backed by the [`java.math.BigInteger`][7] and [`java.math.BigDecimal`][8] classes, but can be used with mathematical operators
(which in Scala are actually methods)

+ The mathematical functions are defined in the [`scala.math`][9] package.

+ [`Random`][10] is a singleton random number generator object, defined in the [`scala.util`][11] package.

+ `"Hello"(4)`, which yields 'o', is a shortcut for `"Hello".apply(4)`
Using the `apply` method of a companion object is a common Scala idiom for constructing objects (avoiding `new`)


[1]: http://www.scala-lang.org/api/2.11.0-M4/#scala.collection.immutable.StringOps
[2]: http://www.scala-lang.org/api/2.11.0-M4/#scala.runtime.RichInt
[3]: http://www.scala-lang.org/api/2.11.0-M4/#scala.runtime.RichDouble
[4]: http://www.scala-lang.org/api/2.11.0-M4/#scala.runtime.RichChar
[5]: http://www.scala-lang.org/api/2.11.0-M4/#scala.math.BigInt
[6]: http://www.scala-lang.org/api/2.11.0-M4/#scala.math.BigDecimal
[7]: https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html
[8]: https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html
[9]: http://www.scala-lang.org/api/2.11.0-M4/#scala.math.package
[10]: http://www.scala-lang.org/api/2.11.0-M4/#scala.util.Random$
[11]: http://www.scala-lang.org/api/2.11.0-M4/#scala.util.package
[12]: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
