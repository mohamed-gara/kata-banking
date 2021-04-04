package com.example.kata

import spock.lang.Specification

class AccountShould extends Specification {

    Account sut;

    @SuppressWarnings('unused')
    // false positive from IntelliJ for some reason
    def setup() {
        sut = new Account()
    }


}
