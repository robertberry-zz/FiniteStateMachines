package com.github.robertberry.fsm

import alphabets.Binary

/**
 * Package object for non-deterministic finite state machines.
 */
package object nondeterministic {
  /**
   * Transition function for a non-deterministic finite state machine. Takes the current state and either some input
   * or the empty string. Returns the set of states the machine should go to.
   *
   * @tparam State The state type
   * @tparam Alphabet The input alphabet type
   */
  type Transition[State, Alphabet] = (State, Option[Alphabet]) => Set[State]

  /**
   * A non-deterministic finite state machine with a binary alphabet (only zero or one are accepted input parameters)
   * with states represented by symbols.
   */
  type BinaryNFSM = NondeterministicFSM[Binary, Symbol]
}
