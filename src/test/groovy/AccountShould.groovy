package com.example.kata

import spock.lang.Specification

import static java.math.BigDecimal.ONE
import static java.math.BigDecimal.TEN
import static java.math.BigDecimal.ZERO

class AccountShould extends Specification {
  def 'given existing balance is #existingBalance, when deposit #amount then resulted balance is #expectedBalance'() {
    given:
      def sut = new Account(existingBalance)

    when:
      def result = sut.deposit(amount)

    then:
      result.balance == expectedBalance

    where:
      existingBalance | amount | expectedBalance
      ZERO            | ONE    | ONE
      ZERO            | TEN    | TEN
      ONE             | ONE    | ONE.add(ONE)
      TEN             | ONE    | TEN.add(ONE)
  }

  def 'given existing balance is #existingBalance, when withdraw #amount then resulted balance is #expectedBalance'() {
    given:
      def sut = new Account(existingBalance)

    when:
      def result = sut.withdraw(amount)

    then:
      result.balance == expectedBalance

    where:
      existingBalance | amount | expectedBalance
      ZERO            | ONE    | ONE.negate()
      ONE             | ONE    | ZERO
      TEN             | ONE    | TEN.subtract(ONE)
  }
}
