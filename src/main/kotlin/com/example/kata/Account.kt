package com.example.kata

import java.math.BigDecimal

data class Account(
  val balance: BigDecimal
) {
  fun deposit(amount: BigDecimal): Account = this.withBalanceIncrementedBy(amount)

  fun withdraw(amount: BigDecimal): Account = this.withBalanceIncrementedBy(amount.negate())

  private fun withBalanceIncrementedBy(amount: BigDecimal) = copy(balance = this.balance.add(amount))
}
