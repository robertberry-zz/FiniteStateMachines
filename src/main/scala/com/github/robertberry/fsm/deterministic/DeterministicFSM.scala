package com.github.robertberry.fsm.deterministic

import com.github.robertberry.fsm.{Rejects}
import collection.immutable.HashMap

/**
 * Deterministic finite state machine
 */
class DeterministicFSM[Alphabet, State](val states: Set[State], val transitions: Seq[Transition[Alphabet, State]],
                       val startState: State, val acceptStates: Set[State]) extends Rejects[Alphabet] {
  require(states contains startState, "Start state must be in set of states.")
  require(acceptStates subsetOf states, "Finish states must be subset of set of states.")
  require(transitions.map(_.start).toSet subsetOf states, "Transition starts must be in set of states.")
  require(transitions.map(_.end).toSet subsetOf states, "Transition ends must be in set of states.")

  val transitionMap = transitions.map(t => ((t.start, t.input), t.end)).toMap

  /**
   * Whether machine accepts input
   *
   * @param input The input string
   * @return Whether accepted
   */
  def accepts(input: Seq[Alphabet]): Boolean = {
    val end = input.foldLeft(startState)((state, character) => {
      transitionMap.get((state, character)).get
    })
    acceptStates contains end
  }
}
