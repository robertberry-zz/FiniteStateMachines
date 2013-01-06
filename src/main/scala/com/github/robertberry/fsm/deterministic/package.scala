package com.github.robertberry.fsm

/**
 * Package object for deterministic finite state machines
 */
package object deterministic {
  type BinaryDFSM = DeterministicFSM[BinaryAlphabet, Symbol]
}
