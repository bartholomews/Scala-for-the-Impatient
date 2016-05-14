// ========================================================
/* 1.

In the Scala REPL, type 3.
followed by the Tab key.
What methods can be applied?

scala> 3.

getClass   isInstanceOf   asInstanceOf
toByte   toShort   toInt   toDouble
toLong   toFloat   toChar   toString
hashCode   equals
<init>
+   -   /   *   %
equals   ==   !=   >   <   >=   <=
unary_~   unary_+   unary_-
&   |   ^   >>   <<   >>>   ##

 */
// ========================================================
/* 2.

In the Scala REPL, compute the square root of 3,
and then square that value.
By how much does the result differ from 3?
(Hint: The res variables are your friend.)

scala> scala.math.sqrt(3)
res1: Double = 1.7320508075688772
scala> res1 * res1
res2: Double = 2.9999999999999996

 */
// ========================================================
/* 3.

Are the res variables val or var?

val

 */
// ========================================================
/* 4.

Scala lets you multiply a string with a number —
try out "crazy" * 3 in the REPL.
What does this operation do? Where can you find it in Scaladoc?

http://www.scala-lang.org/api/2.11.0-M4/index.html#scala.collection.immutable.StringOps

*/

"crazy" * 3 // "string".*(n) concatenate "string" n times

// ========================================================
/* 5.

What does 10 max 2 mean? In which class is the max method defined?

http://www.scala-lang.org/api/2.11.0-M4/index.html#scala.runtime.ScalaNumberProxy
ScalaNumberProxy is the base class for the Rich* wrappers,
max is defined in all the Rich wrappers of primitive types

*/

10 max 2  // returns the greater of the two (>)

// ========================================================
/* 6.

Using BigInt, compute 2^1024.

*/

BigInt(2) pow 1024

// ========================================================
/* 7.

What do you need to import so that you can get a random prime
as probablePrime(100, Random), without any qualifiers
before probablePrime and Random?
*/

BigInt.probablePrime(100, scala.util.Random)

// ========================================================
/* 8.

One way to create random file or directory names is to produce
a random BigInt and convert it to base 36, yielding a string
such as "qsnvbevtomcj38o06kul". Poke around Scaladoc
to find a way of doing this in Scala.
*/

BigInt.probablePrime(100, scala.util.Random).toString(36)

// ========================================================
/* 9.

How do you get the first character of a string in Scala?
The last character?
*/

"FirstChar".head
"FirstChar"(0)
"FirstChar".charAt(0)

"LastChar".last
"LastChar"("LastChar".length - 1)
"LastChar".charAt("LastChar".length - 1)

// ========================================================
/* 10.

What do the take, drop, takeRight, and dropRight
string functions do? What advantage or disadvantage
do they have over using substring?

s.take(n) = s.substring(0, n)
s.takeRight(n) = s.substring(s.length - n)
s.drop(n) = s.substring(n)
s.dropRight(n) = s.substring(0, s.length - n)

one advantage is they improve readability,
one advantage/disadvantage (depends on the case)
is they do not throw a java.lang.IndexOutOfBoundsException
(as substring does), but keep taking/dropping until
the last valid index is consumed, returning what they got,
e.g. "string".take(10) = "string"
     "string".substring(0, 10) throws IndexOutOfBoundsException
*/
