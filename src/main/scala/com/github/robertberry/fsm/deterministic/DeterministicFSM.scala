package com.github.robertberry.fsm.deterministic

/**
 * Deterministic finite state machine
 */
class DeterministicFSM[Alphabet](val states: Set[State], val transition: (State, Alphabet) => State,
                       val startState: State, val finishStates: Set[State]) {
  require(states.contains(startState), "Start state must be in set of states.")
  require(finishStates.subsetOf(states), "Finish states must be subset of set of states.")

  /**
   * Whether machine accepts input
   *
   * @param input The input string
   * @return Whether accepted
   */
  def accepts(input: Seq[Alphabet]): Boolean = {
    var state = startState

    for (ch <- input) {
      state = transition(state, ch)
    }

    finishStates.contains(state)
  }

  /**
   * Whether machine rejects input
   *
   * @param input The input string
   * @return Whether rejected
   */
  def rejects(input: Seq[Alphabet]): Boolean = !accepts(input)
}
