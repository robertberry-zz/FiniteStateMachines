package com.github.robertberry.fsm.deterministic

import examples.EndsWithZero
import org.scalatest.FlatSpec
import com.github.robertberry.fsm.alphabets.{Binary, One, Zero}

class EndsWithZeroSpecification extends FlatSpec {
  val endsWithZero = EndsWithZero.machine

  "An EndsWithZero FSM" should "accept strings ending in zero" in {
    assert(endsWithZero accepts Binary.fromString("1010"))
    assert(endsWithZero accepts Binary.fromString("0"))
    assert(endsWithZero accepts Binary.fromString("110"))
    assert(endsWithZero accepts Binary.fromString("010"))
  }

  it should "reject strings ending in one" in {
    assert(endsWithZero rejects Seq(Zero, One))
    assert(endsWithZero rejects Seq(One))
    assert(endsWithZero rejects Seq(Zero, One, Zero, One))
    assert(endsWithZero rejects Seq(Zero, Zero, One, One))
  }
}