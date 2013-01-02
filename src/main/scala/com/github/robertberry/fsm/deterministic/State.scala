package com.github.robertberry.fsm.deterministic

/**
 *
 *
 */
class State(val name: String) {

}


object State {
  def apply(name: String): State = {
    new State(name)
  }
}