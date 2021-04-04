package com.example.kata

data class Amount(
  val amount: Int
) {
  fun negate(): Amount {
    return copy(amount = this.amount * -1)
  }

  fun add(amount: Amount): Amount {
    return copy(amount = this.amount + amount.amount)
  }

  companion object {
    private @JvmStatic
    fun of(amount: Int): Amount {
      return Amount(amount)
    }
  }
}
