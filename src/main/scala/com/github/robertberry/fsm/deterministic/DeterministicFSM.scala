package com.github.robertberry.fsm.deterministic

import com.github.robertberry.fsm.Rejects

/**
 * Deterministic finite state machine
 */
class DeterministicFSM[Alphabet, State](val states: Set[State], val transition: (State, Alphabet) => State,
                       val startState: State, val acceptStates: Set[State]) extends Rejects[Alphabet] {
  require(states contains startState, "Start state must be in set of states.")
  require(acceptStates subsetOf states, "Finish states must be subset of set of states.")

  /**
   * Whether machine accepts input
   *
   * @param input The input string
   * @return Whether accepted
   */
  def accepts(input: Seq[Alphabet]): Boolean = {
    val end = input.foldLeft(startState)(transition)
    acceptStates contains end
  }
}
