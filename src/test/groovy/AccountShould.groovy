package com.example.kata

import spock.lang.Specification

import static java.math.BigDecimal.ONE
import static java.math.BigDecimal.TEN
import static java.math.BigDecimal.ZERO

class AccountShould extends Specification {
  def 'given existing balance is #existingBalance, when deposit #amount then result in #expectedBalance'() {
    given: 'existing balance is #existingBalance'
      def sut = new Account(existingBalance)

    when: 'deposit #amount'
      def result = sut.deposit(amount).getBalance()

    then: 'expected balance is #expectedBalance'
      result == expectedBalance

    where:
      existingBalance | amount | expectedBalance
      ZERO            | ONE    | ONE
      ZERO            | TEN    | TEN
      ONE             | ONE    | ONE.add(ONE)
      TEN             | ONE    | TEN.add(ONE)
  }
}
