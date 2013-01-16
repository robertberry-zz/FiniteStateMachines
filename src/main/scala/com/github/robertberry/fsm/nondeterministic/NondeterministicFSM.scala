package com.github.robertberry.fsm.nondeterministic

import com.github.robertberry.fsm.Rejects

/**
 * Non-deterministic finite state machine
 */
class NondeterministicFSM[Alphabet, State](val states: Set[State], val transitions: Seq[Transition[Alphabet, State]],
                                            val startState: State, val acceptStates: Set[State])
    extends Rejects[Alphabet] {
  require(states contains startState, "Start state not in states set.")
  require(acceptStates subsetOf states, "Accept states not subset of states.")
  require(transitions.map(_.start).toSet subsetOf states, "Start states in transitions must be subset of states.")
  require(transitions.flatMap(_.end).toSet subsetOf states, "End states in transition must be subset of states.")

  val transitionMap = transitions.map(t => ((t.start, t.input.getOrElse(None)), t.end)).toMap

  def accepts(input: Seq[Alphabet]): Boolean = {
    var states = Set(startState)

    val endStates = input.foldLeft(Set(startState))((states: Set[State], char: Alphabet) => {
      val withNoneTransitions: Set[State] = states ++ states.flatMap(s => transitionMap.get(s, None).getOrElse(Set()))
      withNoneTransitions.flatMap(s => transitionMap.get(s, char).getOrElse(Set())).toSet
    })

    (endStates intersect acceptStates).nonEmpty
  }
}
