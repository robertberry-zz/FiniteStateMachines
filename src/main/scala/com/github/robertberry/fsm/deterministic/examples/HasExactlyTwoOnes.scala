package com.github.robertberry.fsm.deterministic.examples

import com.github.robertberry.fsm.deterministic._

/**
 * Deterministic finite state machine that accepts strings containing exactly two ones
 */
object HasExactlyTwoOnes {
  val states = Set('q1, 'q2, 'q3, 'q4)
  val finishStates = Set('q3)

  def transition(state: Symbol, input: BinaryAlphabet): Symbol = (state, input) match {
    case ('q1, One) => 'q2
    case ('q1, Zero) => 'q1
    case ('q2, One) => 'q3
    case ('q2, Zero) => 'q2
    case ('q3, One) => 'q4
    case ('q3, Zero) => 'q3
    case ('q4, _) => 'q4
  }

  val machine = new BinaryDFSM(states, transition, 'q1, finishStates)
}
