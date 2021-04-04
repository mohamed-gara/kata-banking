package com.example.kata

data class Money(
  val amount: Int
) {
  fun negate(): Money {
    return copy(amount = this.amount * -1)
  }

  fun add(amount: Money): Money {
    return copy(amount = this.amount + amount.amount)
  }

  companion object {
    private @JvmStatic
    fun of(amount: Int): Money {
      return Money(amount)
    }
  }
}
