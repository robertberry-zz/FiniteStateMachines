package com.github.robertberry.fsm.nondeterministic

import org.scalatest.FlatSpec
import examples.HasEither
import com.github.robertberry.fsm.alphabets.{Binary, Zero, One}

/**
 *
 */
class HasEitherSpec extends FlatSpec {
  val hasEither = HasEither.machine

  "Has either 1001 or 10101 machine" should "accept strings containing 1001" in {
    assert(hasEither accepts Binary.fromString("1001"))
    assert(hasEither accepts Binary.fromString("00100100"))
    assert(hasEither accepts Binary.fromString("11001"))
  }

  it should "accept strings containing 10101" in {
    assert(hasEither accepts Binary.fromString("10101"))
    assert(hasEither accepts Binary.fromString("0101011"))
    assert(hasEither accepts Binary.fromString("1110101"))
  }

  it should "accept strings containing both 1001 and 10101" in {
    assert(hasEither accepts Binary.fromString("10010101"))
    assert(hasEither accepts Binary.fromString("010011110101"))
  }

  it should "reject strings containing neither 1001 nor 10101" in {
    assert(hasEither rejects Binary.fromString("1"))
    assert(hasEither rejects Binary.fromString(""))
    assert(hasEither rejects Binary.fromString("0010000000"))
    assert(hasEither rejects Binary.fromString("11111100000"))
  }
}
