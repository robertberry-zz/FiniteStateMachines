package com.github.robertberry.fsm.deterministic.examples

import com.github.robertberry.fsm.deterministic._
import com.github.robertberry.fsm.alphabets.{One, Zero, Binary}

/**
 * Deterministic finite state machine that accepts strings containing at least three zeros.
 */
object HasThreeZeros {
  val states = Set('q1, 'q2, 'q3, 'q4)
  val acceptStates = Set('q4)

  val transitions = Seq(
    new BinaryTransition('q1, Zero, 'q2),
    new BinaryTransition('q1, One, 'q1),
    new BinaryTransition('q2, Zero, 'q3),
    new BinaryTransition('q2, One, 'q2),
    new BinaryTransition('q3, Zero, 'q4),
    new BinaryTransition('q3, One, 'q3),
    new BinaryTransition('q4, Zero, 'q4),
    new BinaryTransition('q4, One, 'q4)
  )

  val machine = new BinaryDFSM(states, transitions, 'q1, acceptStates)
}
