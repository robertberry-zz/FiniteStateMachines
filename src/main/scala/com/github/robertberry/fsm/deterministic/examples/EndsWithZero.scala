package com.github.robertberry.fsm.deterministic.examples

import com.github.robertberry.fsm.deterministic._

/**
 * Finite state machine that accepts strings that end with zero
 */
object EndsWithZero {
  val q1 = State("q1")
  val q2 = State("q2")

  val states = Set[State](q1, q2)
  val finishStates = Set[State](q2)

  def transition(state: State, character: BinaryAlphabet): State = (state, character) match {
    case (`q1`, Zero) => q2
    case (`q1`, One) => q1
    case (`q2`, Zero) => q2
    case (`q2`, One) => q1
  }

  val machine = new DeterministicFSM[BinaryAlphabet](states, transition, q1, finishStates)
}