package com.github.robertberry.fsm.deterministic

/**
 * Deterministic finite state machine
 */
class DeterministicFSM[Alphabet, State](val states: Set[State], val transition: (State, Alphabet) => State,
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
    val end = input.foldLeft(startState)(transition)
    finishStates.contains(end)
  }

  /**
   * Whether machine rejects input
   *
   * @param input The input string
   * @return Whether rejected
   */
  def rejects(input: Seq[Alphabet]): Boolean = !accepts(input)
}
