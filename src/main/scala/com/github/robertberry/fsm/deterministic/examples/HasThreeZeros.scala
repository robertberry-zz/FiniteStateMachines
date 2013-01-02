package com.github.robertberry.fsm.deterministic.examples

import com.github.robertberry.fsm.deterministic._

/**
 * Deterministic finite state machine that accepts strings containing at least three zeros.
 */
object HasThreeZeros {
  val q1 = State("q1")
  val q2 = State("q2")
  val q3 = State("q3")
  val q4 = State("q4")

  val states = Set[State](q1, q2, q3, q4)
  val finishStates = Set[State](q4)

  def transition(state: State, input: BinaryAlphabet): State = (state, input) match {
    case (`q1`, Zero) => q2
    case (`q1`, One) => q1
    case (`q2`, Zero) => q3
    case (`q2`, One) => q2
    case (`q3`, Zero) => q4
    case (`q3`, One) => q3
    case (`q4`, _) => q4
  }

  val machine = new DeterministicFSM[BinaryAlphabet](states, transition, q1, finishStates)
}
