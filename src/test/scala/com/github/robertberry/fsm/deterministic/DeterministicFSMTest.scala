package com.github.robertberry.fsm.deterministic

import org.scalatest.FlatSpec

/**
 * Deterministic Finite State MAchine specification
 */
class DeterministicFSMTest extends FlatSpec {
  "A Deterministic Finite State Machine" should "only allow start states that are part of its set of states" in {
    val q1 = State("q1")
    val q2 = State("q2")
    val q3 = State("q3")

    val states = Set[State](q1, q2, q3)
    val finishStates = Set[State](q3)

    val alphabet = "01".toSet

    def transition(state: State, character: BinaryAlphabet): State = (state, character) match {
      case (`q1`, Zero) => q2
      case (`q1`, One) => q3
      case (`q2`, Zero) => q3
      case (`q2`, One) => q2
      case (`q3`, Zero) => q1
      case (`q3`, One) => q2
    }

    val machine = new DeterministicFSM[BinaryAlphabet](states, transition, q1, finishStates)

    intercept[IllegalArgumentException] {
      val badMachine = new DeterministicFSM[BinaryAlphabet](states, transition, State("q4"), finishStates)
    }
  }
}
