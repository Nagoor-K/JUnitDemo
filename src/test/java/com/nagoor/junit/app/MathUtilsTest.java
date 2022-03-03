package com.nagoor.junit.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

  @Test
  void test() {
    MathUtils mathUtils=new MathUtils();
    int expected=2;
    int actual=mathUtils.addNums(1, 1);
    assertEquals(expected, actual);
  }
  
  @Test
  void testDivide() {
    MathUtils mathUtils=new MathUtils();
    assertThrows(ArithmeticException.class, () -> mathUtils.divNums(1, 0),"Divded by zero");
  }
  
}
