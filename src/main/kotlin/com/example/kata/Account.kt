package com.example.kata

data class Account(
  val balance: Amount,
  val statement: Statement
) {
  fun deposit(amount: Amount): Account =
    this.withBalanceIncrementedBy(amount)

  fun withdraw(amount: Amount): Account =
    this.withBalanceIncrementedBy(amount.negate())

  private fun withBalanceIncrementedBy(amount: Amount) =
    copy(
      balance = this.balance.add(amount),
      statement = this.statement.append("", amount, this.balance.add(amount))
    )
}
