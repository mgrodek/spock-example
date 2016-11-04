package com._7_custom_source_provider

import spock.lang.Specification
import spock.lang.Unroll

class ProviderSampleSpec extends Specification {

    @Unroll
    def "Gender #gender for #name is #description"() {
        expect:
        new User(name: name, gender: gender).female == Boolean.valueOf(expected)

        where:
        [_, name, gender, expected] << new MultilineProvider(source: "1;mrhaki;M;false\n2;Britt;F;true")

        description = expected ? 'female' : 'not female'
    }

}

class User {
    String name
    String gender

    boolean isFemale() { gender == 'F' }
}

class MultilineProvider implements Iterable {
    String source

    @Override
    Iterator iterator() {
        def lines = source.stripIndent().readLines()
        def tokenizedLines = lines.collect { it.tokenize(';') }

        tokenizedLines.iterator()
    }
}