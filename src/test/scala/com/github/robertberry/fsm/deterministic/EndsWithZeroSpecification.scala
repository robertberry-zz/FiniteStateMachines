package com.github.robertberry.fsm.deterministic

import examples.EndsWithZero
import org.scalatest.FlatSpec

class EndsWithZeroSpecification extends FlatSpec {
  val endsWithZero = EndsWithZero.machine

  "An EndsWithZero FSM" should "accept strings ending in zero" in {
    assert(endsWithZero accepts Seq(One, Zero, One, Zero))
    assert(endsWithZero accepts Seq(Zero))
    assert(endsWithZero accepts Seq(One, One, Zero))
    assert(endsWithZero accepts Seq(Zero, One, Zero))
  }

  it should "reject strings ending in one" in {
    assert(endsWithZero rejects Seq(Zero, One))
    assert(endsWithZero rejects Seq(One))
    assert(endsWithZero rejects Seq(Zero, One, Zero, One))
    assert(endsWithZero rejects Seq(Zero, Zero, One, One))
  }
}