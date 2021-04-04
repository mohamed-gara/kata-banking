package com.example.kata

import java.math.BigDecimal

data class Account(
  val balance: BigDecimal
) {
  fun deposit(amount: BigDecimal): Account {
    return copy(balance = this.balance.add(amount))
  }

  fun withdraw(amount: BigDecimal): Account {
    return copy(balance = this.balance.subtract(amount))
  }
}
