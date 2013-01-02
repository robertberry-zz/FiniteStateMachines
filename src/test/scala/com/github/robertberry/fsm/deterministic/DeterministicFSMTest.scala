package com.github.robertberry.fsm.deterministic

import examples.EndsWithZero
import org.scalatest.FlatSpec

/**
 * Deterministic Finite State MAchine specification
 */
class DeterministicFSMTest extends FlatSpec {
  "A Deterministic Finite State Machine" should "only allow start states that are part of its set of states" in {
    val endsWithZero = EndsWithZero.machine

    intercept[IllegalArgumentException] {
      val badMachine = new DeterministicFSM[BinaryAlphabet](endsWithZero.states, endsWithZero.transition,
        State("q4"), endsWithZero.finishStates)
    }
  }
}
