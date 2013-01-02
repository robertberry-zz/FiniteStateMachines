package com.github.robertberry.fsm.deterministic

import examples.EndsWithZero
import org.scalatest.FlatSpec

/**
 * Deterministic Finite State MAchine specification
 */
class DeterministicFSMSpecification extends FlatSpec {
  "A Deterministic Finite State Machine" should "only allow start states that are part of its set of states" in {
    val endsWithZero = EndsWithZero.machine

    intercept[IllegalArgumentException] {
      new DeterministicFSM[BinaryAlphabet](endsWithZero.states, endsWithZero.transition,
        State("q4"), endsWithZero.finishStates)
    }
  }

  it should "only allow finish states that are also members of its states" in {
    val endsWithZero = EndsWithZero.machine

    intercept[IllegalArgumentException] {
      new DeterministicFSM[BinaryAlphabet](endsWithZero.states, endsWithZero.transition, endsWithZero.startState,
        Set[State](endsWithZero.startState, State("q4")))
    }
  }
}
