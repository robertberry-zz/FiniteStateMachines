package com.github.robertberry.fsm.languages

import org.scalatest.FlatSpec
import com.github.robertberry.fsm.alphabets.{Zero, One, Binary}

/**
 *
 */
class BinarySpec extends FlatSpec {
  "Binary.fromString" should "convert strings to appropriate sequences of Binary objects" in {
    assert(Binary.fromString("") == Seq())
    assert(Binary.fromString("0") == Seq(Zero))
    assert(Binary.fromString("1") == Seq(One))
    assert(Binary.fromString("010") == Seq(Zero, One, Zero))
    assert(Binary.fromString("100") == Seq(One, Zero, Zero))
    assert(Binary.fromString("10101") == Seq(One, Zero, One, Zero, One))
  }
}
