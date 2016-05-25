#### Chapter 2 - Control Structures and Functions

##### *Notes*

Key points:

+ In Scala, every expression has a type. The type of a mixed-type expression is the common supertype of both branches.

```
if (x > 0) 1 // if (x > 0) 1 else ()
```

+ In Scala, every expression is supposed to have *some* value.
The class `Unit` has one value, `()`. 

+ Assignment have a value of type [`Unit`][1].

```
x = y = 1 // x = ()
```

+ `printf` is used for formatted text (see [*string interpolation*][http://docs.scala-lang.org/overviews/core/string-interpolation.html]

+ *initialize; test; update* loop can be achieved with:

```
for(i <- 1 to n if <conditional expression>) { ... }
```


[1]: http://www.scala-lang.org/api/2.11.0-M4/#scala.Unit
