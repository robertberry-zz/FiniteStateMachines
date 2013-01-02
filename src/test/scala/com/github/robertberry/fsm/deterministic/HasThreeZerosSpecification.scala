package com.github.robertberry.fsm.deterministic

import examples.HasThreeZeros
import org.scalatest.FlatSpec

/**
 * Created with IntelliJ IDEA.
 * User: robert
 * Date: 02/01/2013
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
class HasThreeZerosSpecification extends FlatSpec {
  val hasThreeZeros = HasThreeZeros.machine

  "Has three zeros finite state machine" should "reject strings with fewer than three zeros" in {
    assert(hasThreeZeros rejects Seq())
    assert(hasThreeZeros rejects Seq(Zero))
    assert(hasThreeZeros rejects Seq(Zero, Zero))
    assert(hasThreeZeros rejects Seq(One, Zero, One, Zero))
  }

  it should "accept strings with exactly three zeros" in {
    assert(hasThreeZeros accepts Seq(Zero, Zero, Zero))
    assert(hasThreeZeros accepts Seq(Zero, One, Zero, One, Zero))
    assert(hasThreeZeros accepts Seq(One, One, Zero, Zero, Zero, One))
  }

  it should "accept strings with more than three zeros" in {
    assert(hasThreeZeros accepts Seq(Zero, Zero, Zero, Zero))
    assert(hasThreeZeros accepts Seq(Zero, One, Zero, Zero, Zero, Zero))
  }
}
