package com.math;

import _1.InterestCalculator;
import _1.SimpleInterestCalculator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class SimpleInterestCalculatorTest {

    private InterestCalculator sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        sut = new SimpleInterestCalculator();
        sut.setRate(0.05);
    }

    @Test
    public void should_calculate_interest() {
        //When
        double interestResult = sut.calculate(10000, 2);

        //Then
        assertThat(interestResult, is(equalTo(1000.0)));
    }

    @Test
    public void should_throw_exception_when_amount_is_negative() {
        //Expect
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Amount or year must be positive");

        sut.calculate(-10000, 2);
    }

}