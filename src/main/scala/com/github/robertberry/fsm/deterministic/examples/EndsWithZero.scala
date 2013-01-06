package com.github.robertberry.fsm.deterministic.examples

import com.github.robertberry.fsm.deterministic._

/**
 * Finite state machine that accepts strings that end with zero
 */
object EndsWithZero {
  val states = Set('q1, 'q2)
  val finishStates = Set('q2)

  def transition(state: Symbol, character: BinaryAlphabet): Symbol = (state, character) match {
    case ('q1, Zero) => 'q2
    case ('q1, One) => 'q1
    case ('q2, Zero) => 'q2
    case ('q2, One) => 'q1
  }

  val machine = new BinaryDFSM(states, transition, 'q1, finishStates)
}