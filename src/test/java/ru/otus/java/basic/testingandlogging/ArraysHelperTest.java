package ru.otus.java.basic.testingandlogging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

class ArraysHelperTest {

  ArraysHelper ah;

  @BeforeEach
  void before() {
    ah = new ArraysHelper();
  }

  public static Stream<Arguments> itemsAfterOne() {
    return Stream.of(
            Arguments.of(new int[]{2}, new int[]{1, 2}),
            Arguments.of(new int[]{4, 2}, new int[]{1, 2, 1, 4, 2}),
            Arguments.of(new int[]{3, 2}, new int[]{1, 4, 1, 3, 2})
    );
  }

  @ParameterizedTest
  @MethodSource
  void itemsAfterOne(int[] expect, int[] value) {
    Assertions.assertArrayEquals(expect, ah.itemsAfterOne(value));
  }

  public static Stream<Arguments> itemsAfterOneRuntimeException() {
    return Stream.of(
            Arguments.of(new int[]{2, 2}),
            Arguments.of(new int[]{})
    );
  }

  @ParameterizedTest
  @MethodSource
  @NullSource
  void itemsAfterOneRuntimeException(int[] value) {
    Assertions.assertThrows(RuntimeException.class, () -> ah.itemsAfterOne(value));
  }

  public static Stream<Arguments> containsOneAndTwoTrue() {
    return Stream.of(
            Arguments.of(new int[]{1, 2, 1}),
            Arguments.of(new int[]{1, 2, 1, 2})
    );
  }

  @ParameterizedTest
  @MethodSource
  void containsOneAndTwoTrue(int[] array) {
    Assertions.assertTrue(ah.containsOneAndTwo(array));
  }

  public static Stream<Arguments> containsOneAndTwoFalse() {
    return Stream.of(
            Arguments.of(new int[]{1, 1, 1}),
            Arguments.of(new int[]{2, 2}),
            Arguments.of(new int[]{1, 2, 3, 2}),
            Arguments.of(new int[]{})
    );
  }

  @ParameterizedTest
  @MethodSource
  void containsOneAndTwoFalse(int[] array) {
    Assertions.assertFalse(ah.containsOneAndTwo(array));
  }
}