package com.github.robertberry.fsm

/**
 * For a class that has an accepts method for a given input string, adds a rejects method (which is just the
 * complement).
 */
trait Rejects[Alphabet] {
  def accepts(input: Seq[Alphabet]): Boolean

  /**
   * Whether machine rejects input
   *
   * @param input The input string
   * @return Whether rejected
   */
  def rejects(input: Seq[Alphabet]): Boolean = !accepts(input)
}
