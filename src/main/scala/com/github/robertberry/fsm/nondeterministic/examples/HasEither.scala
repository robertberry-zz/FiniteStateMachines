package com.github.robertberry.fsm.nondeterministic.examples

import com.github.robertberry.fsm.alphabets.{One, Zero}
import com.github.robertberry.fsm.nondeterministic.BinaryNFSM
import com.github.robertberry.fsm.nondeterministic.BinaryTransition

/**
 * Non-deterministic finite state machine that matches strings that have either 1001 or 10101 as sub-strings.
 */
object HasEither {
  val states = Set('q1, 'q2, 'q3, 'q4, 'q5, 'q6, 'q7, 'q8, 'q9, 'q10, 'q11)

  val acceptStates = Set('q6)

  val transitions = Seq(
    new BinaryTransition('q1, None, Set('q2, 'q7)),
    new BinaryTransition('q1, Some(Zero), Set('q1)),
    new BinaryTransition('q1, Some(One), Set('q1)),
    new BinaryTransition('q2, Some(One), Set('q3)),
    new BinaryTransition('q3, Some(Zero), Set('q4)),
    new BinaryTransition('q4, Some(Zero), Set('q5)),
    new BinaryTransition('q5, Some(One), Set('q6)),
    new BinaryTransition('q6, Some(Zero), Set('q6)),
    new BinaryTransition('q6, Some(One), Set('q6)),
    new BinaryTransition('q7, Some(One), Set('q8)),
    new BinaryTransition('q8, Some(Zero), Set('q9)),
    new BinaryTransition('q9, Some(One), Set('q10)),
    new BinaryTransition('q10, Some(Zero), Set('q11)),
    new BinaryTransition('q11, Some(One), Set('q6))
  )

  val machine = new BinaryNFSM(states, transitions, 'q1, acceptStates)
}
