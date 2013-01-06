package com.github.robertberry.fsm

import alphabets.Binary

/**
 * Package object for deterministic finite state machines
 */
package object deterministic {
  type BinaryDFSM = DeterministicFSM[Binary, Symbol]
}
