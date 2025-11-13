package com.alexander.programming.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @MethodSource("palindromes")
    @ParameterizedTest(name = "isPalindrome({0}) = {1}")
    void isRotated(String input, Boolean isPalindrome) {
        assertThat(Palindrome.isPalindrome(input)).isEqualTo(isPalindrome);
    }

    private static Stream<Arguments> palindromes() {
        return Stream.of(
                Arguments.of("hannah", true),
                Arguments.of("a", true),
                Arguments.of("", false),
                Arguments.of("  ", false),
                Arguments.of(null, false),
                Arguments.of("Hannah", true),
                Arguments.of("bob", true),
                Arguments.of("alex", false)
        );
    }
}