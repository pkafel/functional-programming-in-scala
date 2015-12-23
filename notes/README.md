#Chapter 4

## Option vs Either

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
