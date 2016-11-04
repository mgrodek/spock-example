package com._7_annotations

import spock.lang.Specification
import spock.lang.Timeout

import static java.util.concurrent.TimeUnit.MILLISECONDS

class TimeoutSpec extends Specification {

    @Timeout(value = 500, unit = MILLISECONDS)
    //@FailsWith(SpockTimeoutError)
    def "method that completes in time (millis)"() {
        setup:
        Thread.sleep 250
    }
}