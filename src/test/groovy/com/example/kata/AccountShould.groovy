package com.example.kata

import spock.lang.Specification

class AccountShould extends Specification {
  def 'given existing balance is #existingBalance, when deposit #amount then resulted balance is #expectedBalance'() {
    given:
      def sut = new Account(Amount.of(existingBalance))

    when:
      def result = sut.deposit(Amount.of(amount))

    then:
      result.balance.amount == expectedBalance

    where:
      existingBalance | amount | expectedBalance
      0               | 1      | 1
      0               | 10     | 10
      1               | 1      | 2
      10              | 1      | 11
  }

  def 'given existing balance is #existingBalance, when withdraw #amount then resulted balance is #expectedBalance'() {
    given:
      def sut = new Account(Amount.of(existingBalance))

    when:
      def result = sut.withdraw(Amount.of(amount))

    then:
      result.balance.amount == expectedBalance

    where:
      existingBalance | amount | expectedBalance
      0               | 1      | -1
      1               | 1      | 0
      10              | 1      | 9
  }
}
