package com.github.robertberry.fsm.alphabets

/**
 * Binary alphabet
 */
class Binary {

}

object Binary {
  def fromString(string: String): Seq[Binary] = {
    string.map(_ match {
      case '0' => Zero
      case '1' => One
    })
  }
}

object Zero extends Binary

object One extends Binary
