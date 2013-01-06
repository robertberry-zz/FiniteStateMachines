package com.github.robertberry.fsm.deterministic

import examples.HasExactlyTwoOnes
import org.scalatest.FlatSpec
import com.github.robertberry.fsm.alphabets.{One, Zero}

/**
 * Tests for has exactly two ones deterministic finite state machine
 */
class HasExactlyTwoOnesSpecification extends FlatSpec {
  val hasExactlyTwoOnes = HasExactlyTwoOnes.machine

  "HasExactlyTwoOnes finite state machine" should "reject strings with less than two ones" in {
    assert(hasExactlyTwoOnes rejects Seq())
    assert(hasExactlyTwoOnes rejects Seq(Zero, Zero))
    assert(hasExactlyTwoOnes rejects Seq(One))
    assert(hasExactlyTwoOnes rejects Seq(Zero, Zero, One))
    assert(hasExactlyTwoOnes rejects Seq(Zero, One, Zero))
  }

  it should "accept strings with exactly two ones" in {
    assert(hasExactlyTwoOnes accepts Seq(One, One))
    assert(hasExactlyTwoOnes accepts Seq(Zero, One, Zero, One))
    assert(hasExactlyTwoOnes accepts Seq(Zero, Zero, One, One, Zero, Zero))
  }

  it should "reject strings with more than two ones" in {
    assert(hasExactlyTwoOnes rejects Seq(One, One, One))
    assert(hasExactlyTwoOnes rejects Seq(Zero, Zero, One, One, Zero, One, One))
    assert(hasExactlyTwoOnes rejects Seq(One, One, Zero, Zero, One, Zero, Zero, Zero, One, One))
  }
}
