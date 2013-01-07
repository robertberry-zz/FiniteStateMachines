package com.github.robertberry.fsm.nondeterministic.examples

import com.github.robertberry.fsm.alphabets.{One, Zero, Binary}
import com.github.robertberry.fsm.nondeterministic.BinaryNFSM

/**
 * Non-deterministic finite state machine that matches strings that have either 1001 or 10101 as sub-strings.
 */
object HasEither {
  val states = Set('q1, 'q2, 'q3, 'q4, 'q5, 'q6, 'q7, 'q8, 'q9, 'q10, 'q11)

  val acceptStates = Set('q6)

  def transition(state: Symbol, input: Option[Binary]): Set[Symbol] = (state, input) match {
    case ('q1, None) => Set('q2, 'q7)
    case ('q1, Some(_)) => Set('q1)
    case ('q2, Some(One)) => Set('q3)
    case ('q3, Some(Zero)) => Set('q4)
    case ('q4, Some(Zero)) => Set('q5)
    case ('q5, Some(One)) => Set('q6)
    case ('q6, Some(_)) => Set('q6)
    case ('q7, Some(One)) => Set('q8)
    case ('q8, Some(Zero)) => Set('q9)
    case ('q9, Some(One)) => Set('q10)
    case ('q10, Some(Zero)) => Set('q11)
    case ('q11, Some(One)) => Set('q6)
    case _ => Set()
  }

  val machine = new BinaryNFSM(states, transition, 'q1, acceptStates)
}
