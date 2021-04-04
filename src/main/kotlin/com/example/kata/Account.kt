package com.example.kata

data class Account(
  val balance: Money
) {
  fun deposit(amount: Money): Account =
    this.withBalanceIncrementedBy(amount)

  fun withdraw(amount: Money): Account =
    this.withBalanceIncrementedBy(amount.negate())

  private fun withBalanceIncrementedBy(amount: Money) =
    copy(balance = this.balance.add(amount))
}
