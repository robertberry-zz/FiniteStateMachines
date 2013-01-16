package com.github.robertberry.fsm

import alphabets.Binary

/**
 * Package object for non-deterministic finite state machines.
 */
package object nondeterministic {
  /**
   * A non-deterministic finite state machine with a binary alphabet (only zero or one are accepted input parameters)
   * with states represented by symbols.
   */
  type BinaryNFSM = NondeterministicFSM[Binary, Symbol]


  type BinaryTransition = Transition[Binary, Symbol]
}
