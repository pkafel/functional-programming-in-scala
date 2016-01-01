#Chapter 1

## Referential transparency

An expression _e_ is referentially transparent if, for all programs _p_, all occurrences of _e_ in _p_ can be replaced by the result of evaluating _e_ without affecting the meaning of _p_.

## Function purity

A function _f_ is pure if the expression _f(x)_ is referentially transparent for all referentially transparent _x_.

## Substitution model

### Referential transparent example

```scala
val x = "Hello, World"
val r1 = x.reverse
val r2 = x.reverse
```

### Not Referential transparent example

```scala
val x = new StringBuilder("Hello")
val y = x.append(", World")
val r1 = y.toString
val r2 = y.toString
```

#Chapter 2

## _Object_ keyword

The object keyword creates a new singleton type, which is like a class that only has a sin- gle named instance. If you’re familiar with Java, declaring an object in Scala is a lot like cre- ating a new instance of an anonymous class. Scala has no equivalent to Java’s static keyword, and an object is often used in Scala where you might use a class with static members in Java.

## _Main_ method

```scala
def main(args: Array[String]): Unit = println("Hello world")
```

## _Unit_ type

_Unit_ serves a similar purpose to _void_ in programming languages like C and Java. In Scala, every method has to return some value as long as it doesn’t crash or hang. There’s only one value of this type and the literal syntax for it is `()`.

## Tail calls

A call is said to be in tail position if the caller does nothing other than return the value of the recursive call. If all recursive calls made by a function are in tail position, Scala automatically compiles the recursion to iterative loops that don’t consume call stack frames for each iteration. By default, Scala doesn’t tell us if tail call elimination was successful, but if we’re expecting this to occur for a recursive function we write, we can tell the Scala compiler about this assumption using the `@tailrec` annotation.

## Higher-order function

Function that accepts other functions as parameter.

### Example

```scala
def formatResult(name: String, n: Int, f: Int => Int) = { 
  val msg = "The %s of %d is %d."
  msg.format(name, n, f(n))
}
```

## Monomorphic and polymorphic functions

* _monomorphic_ - function that works only on one type of data
* _polymorphic_ - function that works on any type it is given

## Anonymous functions

When we define a function literal, what is actually being defined in Scala is an object with a method called apply. Scala has a special rule for this method name, so that objects that have an apply method can be called as if they were themselves methods. When we define a function literal like `(a, b) => a < b`, this is really syntactic sugar for object creation:

```scala
val lessThan = new Function2[Int, Int, Boolean] { 
  def apply(a: Int, b: Int) = a < b 
}
```

_lessThan_ has type `Function2[Int,Int,Boolean]`, which is usually written `(Int,Int) => Boolean`. Note that the _Function2_ interface (known in Scala as a trait) has an _apply_ method. And when we call the _lessThan_ function with `lessThan(10, 20)`, it’s really syntactic sugar for calling its apply method `lessThan.apply(10, 20)`.

_Function2_ is just an ordinary trait (an interface) provided by the standard Scala library to represent function objects that take two arguments. Also provided are _Function1_, _Function3_, and others, taking a number of arguments indicated by the name. Because functions are just ordinary Scala objects, we say that they’re first-class values.

## Currying

Translating the evaluation of a function that takes multiple arguments (or a tuple of arguments) into evaluating a sequence of functions, each with a single argument. Oposit operation is called uncurrying.

```scala
def curry[A,B,C](f: (A, B) => C): A => (B => C)
def uncurry[A,B,C](f: A => B => C): (A, B) => C
```

#Chapter 4

## _Option_ vs _Either_

* `Option` is sufficient when knowing whether a failure occurred is all we care about
* `Either` data type represents, in a very general way, values that can be one of two things. When we use it to indicate success or failure, by convention the Right constructor is reserved for the success case and Left is used for failure.

## Exceptions as a way of handling errors

* exceptions break referential transparency and introduce context dependence

```scala
val y: Int = throw new Exception("fail!")
```

* exceptions are not type-safe
* exceptions allow us to consolidate and centralize error-handling logic

## Returning bogus value as a way of handling errors

* allows errors to silently propagate — the caller can forget to check this condition and won’t be alerted by the compiler, which might result in subsequent code not working properly
* it results in a fair amount of boilerplate code at call sites, with explicit if statements to check whether the caller has received a “real” result (this boilerplate is magnified if you happen to be calling several functions, each of which uses error codes that must be checked and aggregated in some way)
* for some output types, we might not even have a sentinel value of that type even if we wanted to

## Partial functions

Function that is not defined for some inputs. A function is typically partial because it makes some assumptions about its inputs that aren’t implied by the input types.
Providing default value as an additional parameter or changing return type into _Option_ turns function into total one.

## Lifting

```scala
def lift[A,B](f: A => B): Option[A] => Option[B] = _ map f
```

_Scalaz_ provide functions for lifting two and more argument functions.

## For-comprehensions

```scala
def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
  a flatMap (aa =>
  b map (bb =>
  f(aa, bb)))
```

Exactly the same code with for-comprehension:

```scala
def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
  for {
    aa <- a
    bb <- b
  } yield f(aa, bb)
```

A for-comprehension consists of a sequence of bindings, like aa <- a, followed by a yield after the closing brace, where the yield may make use of any of the values on the left side of any previous <- binding. The compiler desugars the bindings to flatMap calls, with the final binding and yield being converted to a call to map.
