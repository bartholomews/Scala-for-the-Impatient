import scala.annotation.tailrec

// ========================================================
/* 1.

The signum of a number is 1 if the number is positive,
–1 if it is negative, and 0 if it is zero.
Write a function that computes this value.
 */

def signum(n: Int) = {
  if (n == 0) 0
  else if(n > 0) 1
  else if(n < 0) -1
}
// ========================================================
/* 2.

What is the value of an empty block expression {}?
What is its type?

Type is Unit, and has value ()
 */

// ========================================================
/* 3.

Come up with one situation where the assignment x = y = 1 is valid in Scala.
(Hint: Pick a suitable type for x.)
 */

val x: Unit = { val y: Int = 1 }

// ========================================================
/* 4.

Write a Scala equivalent for the Java loop
for (int i = 10; i >= 0; i--) System.out.println(i);
 */

for(i <- 10 to 0 by -1) {
  println(i)
}

// ========================================================
/* 5.

Write a procedure countdown(n: Int)
that prints the numbers from n to 0.
 */

def countdown(n: Int): Unit = {
  for(i <- n to 0 by -1) println(i)
}

// ========================================================
/* 6.

Write a for loop for computing the product
of the Unicode codes of all letters in a string.
For example, the product of the characters in "Hello" is 825152896.
 */

def unicodeProductOverflow(s: String) = {
  var acc = 1
  for(c <- s) acc *= c
  acc
}

def unicodeProduct(s: String) = {
  var acc: BigInt = 1
  for(c <- s) acc *= c.toInt
  acc
}

unicodeProductOverflow("Hello") // 825152896
unicodeProduct("Hello") // 9415087488

// ========================================================
/* 7.

Solve the preceding exercise without writing a loop.
(Hint: Look at the StringOps Scaladoc.)
 */

def unicodeProduct2Overflow(s: String) = s.map(c => c.toInt).product
def unicodeProduct2(s: String) = s.map(BigInt(_)).product

unicodeProduct2Overflow("Hello")  // 825152896
unicodeProduct2("Hello")  // 9415087488

// ========================================================
/* 8.

Write a function product(s : String)
that computes the product, as described in the preceding exercises.
 */

def product(s: String) = s.map(BigInt(_)).product

// ========================================================
/* 9.

Make the function of the preceding exercise a recursive function.
 */

def productRec(s: String) = {
  @tailrec
  def loop(s: String, acc: BigInt): BigInt = {
    if(s.isEmpty) acc
    else loop(s.drop(1), acc * s(0).toInt)
  }
  loop(s, 1)
}

productRec("Hello") // 9415087488

// ========================================================
/* 10.

Write a function that computes x , where n is an integer.
Use the following recursive definition:

• x^n = y^2 if n is even and positive, where y = x^n/2.
• x^n = x * x^n-1 if n is odd and positive.
• x^0 = 1.
• x^n = 1 / x^-n if n is negative.

Don’t use a return statement.
 */

def even_+(n: Int) = (n > 0) && (n % 2) == 0
def odd_+(n: Int) = (n > 0) && (n % 2) != 0

def pow(x: Int, n: Int): Double = {
  if (n < 0) 1 / pow(x, -n)
  else if (n == 0) 1
  else if (odd_+(n)) x * pow(x, n - 1)
  else {
    val y = pow(x, n / 2)
    y * y
  }
}

def powOther(x: Int, n: Int): Double = {
  if(n < 0) 1 / powOther(x, -n)
  else if(n == 0) 1
  else x * powOther(x, n - 1)
}