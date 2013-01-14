package com.github.robertberry.fsm.deterministic.examples

import com.github.robertberry.fsm.deterministic._
import com.github.robertberry.fsm.alphabets.{One, Zero, Binary}

/**
 * Deterministic finite state machine that accepts strings containing exactly two ones
 */
object HasExactlyTwoOnes {
  val states = Set('q1, 'q2, 'q3, 'q4)
  val acceptStates = Set('q3)

  val transitions = Seq(
    new BinaryTransition('q1, One, 'q2),
    new BinaryTransition('q1, Zero, 'q1),
    new BinaryTransition('q2, One, 'q3),
    new BinaryTransition('q2, Zero, 'q2),
    new BinaryTransition('q3, One, 'q4),
    new BinaryTransition('q3, Zero, 'q3),
    new BinaryTransition('q4, One, 'q4),
    new BinaryTransition('q4, Zero, 'q4)
  )

  val machine = new BinaryDFSM(states, transitions, 'q1, acceptStates)
}
