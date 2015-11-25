#Chapter 3

## Lifting

```scala
def lift[A,B](f: A => B): Option[A] => Option[B] = _ map f
```

_Scalaz_ provide functions for lifting two and more argument functions.
