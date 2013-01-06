package com.github.robertberry.fsm.nondeterministic

import com.github.robertberry.fsm.Rejects

/**
 * Non-deterministic finite state machine
 */
class NondeterministicFSM[Alphabet, State](val states: Set[State], val transition: Transition[State, Alphabet],
                                            val startState: State, val acceptStates: Set[State])
    extends Rejects[Alphabet] {
  require(states contains startState, "Start state not in states set.")
  require(acceptStates subsetOf states, "Accept states not subset of states.")

  def accepts(input: Seq[Alphabet]): Boolean = {
    var states = Set(startState)

    val endStates = input.foldLeft(Set(startState))((states: Set[State], char: Alphabet) => {
      val withNoneTransitions = states ++ states.flatMap[State](transition(_, None))
      withNoneTransitions.flatMap[State](transition(_, Some(char))).toSet
    })

    (endStates intersect acceptStates).nonEmpty
  }
}
