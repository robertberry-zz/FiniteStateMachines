package com.github.robertberry.fsm.deterministic.examples

import com.github.robertberry.fsm.deterministic._
import com.github.robertberry.fsm.alphabets.{One, Zero}
import com.github.robertberry.fsm.deterministic.BinaryTransition

/**
 * Finite state machine that accepts strings that end with zero
 */
object EndsWithZero {
  val states = Set('q1, 'q2)
  val acceptStates = Set('q2)

  val transitions = Seq(
    new BinaryTransition('q1, Zero, 'q2),
    new BinaryTransition('q1, One, 'q1),
    new BinaryTransition('q2, Zero, 'q2),
    new BinaryTransition('q2, One, 'q1)
  )

  val machine = new BinaryDFSM(states, transitions, 'q1, acceptStates)
}