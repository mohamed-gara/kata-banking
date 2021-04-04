package com.example.kata

import spock.lang.Specification

import static com.example.kata.StatementKt.emptyStatement

class AccountShould extends Specification {
  def 'given existing balance is #existingBalance, when deposit #amount then resulted balance is #expectedBalance'() {
    given:
      def sut = new Account(Amount.of(existingBalance), emptyStatement())

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
      def sut = new Account(Amount.of(existingBalance), emptyStatement())

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

  def 'an account should initially have an empty statement'() {
    given:
      def sut = new Account(Amount.of(0), emptyStatement())

    expect:
      sut.statement == emptyStatement()
  }

  def 'an account should contains a single statement entry after deposit operation'() {
    given:
      def sut = new Account(Amount.of(0), emptyStatement())

    when:
      def result = sut.deposit(Amount.of(500))

    then:
      result.statement == new Statement(
        List.of(
          new StatementEntry('', Amount.of(500), Amount.of(500))
        )
      )
  }

  def 'an account should contains two statement entries after deposit then withdraw operations'() {
    given:
      def sut = new Account(Amount.of(0), emptyStatement())

    when:
      def result = sut.deposit(Amount.of(500))
        .withdraw(Amount.of(100))

    then:
      result.statement == new Statement(
        List.of(
          new StatementEntry('', Amount.of(500), Amount.of(500)),
          new StatementEntry('', Amount.of(-100), Amount.of(400))
        )
      )
  }
}
