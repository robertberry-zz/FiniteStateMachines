package com.github.robertberry.fsm

/**
 * Transition between two states
 */
case class Transition[Alphabet, State](start: State, input: Alphabet, end: State) {

}
