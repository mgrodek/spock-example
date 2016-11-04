package com._1_start_and_exceptions

import _1.SimpleInterestCalculator
import spock.lang.FailsWith
import spock.lang.Specification
import spock.lang.Subject

class SimpleInterestCalculatorSpec extends Specification {

    @Subject
    def calculator = new SimpleInterestCalculator(rate: 0.05)

    def "should calculate interest"() {
        when:
        def interestResult = calculator.calculate(10000, 2)

        then:
        interestResult == 1000.0
    }

    def "should calculate interest - expect way"() {
        expect:
        calculator.calculate(10000, 2) == 1000.0
    }

    def "should throw exception when amount is negative"() {
        when:
        calculator.calculate(10000, -1)

        then:
        def e = thrown IllegalArgumentException
        e.message == "Amount or year must be positive"
    }

    @FailsWith(IllegalArgumentException)
    def "should throw exception when amount is negative - @FailsWith"() {
        expect:
        calculator.calculate(10000, -1) == 1000.0
    }
}