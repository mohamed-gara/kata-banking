package com.example.kata

data class Statement(
  val entries: List<StatementEntry>
) {
  fun append(date: String, amount: Amount, balance: Amount): Statement {
    return copy(
      entries = entries + StatementEntry(date, amount, balance)
    )
  }
}

data class StatementEntry(
  val date: String,
  val Amount: Amount,
  val balance: Amount
) {

}

fun emptyStatement(): Statement = Statement(listOf());
