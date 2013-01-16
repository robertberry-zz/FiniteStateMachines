package com.github.robertberry.fsm.nondeterministic

/**
 *
 */
case class Transition[Alphabet, State](start: State, input: Option[Alphabet], end: Set[State]) {

}
