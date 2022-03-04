package com.nagoor.junit.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
    MathUtils mathUtils;
    
    @BeforeAll
    static void testBeforeAll() {
    	System.out.print("This will run before all the methods");
    }
    
    @Test
    @Disabled //to disable this method
    @DisplayName("Method will fail automatically")
    void test() {
    	fail("Method will fail");
    }
    
    @BeforeEach
	void init() {
		mathUtils=new MathUtils();
	}
    
    @AfterEach
    void testClean() {
    	System.out.print("This will run after each method");
    }
    
    @Test
	@DisplayName("Asserton Methods")
    void testAssertionAll() {
    	assertAll(
    				() -> assertEquals(4, mathUtils.mulNums(-2, -2)),
    				() -> assertNotEquals(-4, mathUtils.addNums(-1, -2)),
    				() -> assertEquals(16, mathUtils.divNums(32, 2))
    			
    			);
    }
    
  @Nested
  @DisplayName("Testing Add Method")
  class testAdd {
	@Test
	@DisplayName("Addng two positive numbers")
    void testPosi(){
    	int expected=2;
        int actual=mathUtils.addNums(1, 1);
        assertEquals(expected, actual);
    }
	 @Test
	 @DisplayName("Addng two negative numbers")
    void testNegi(){
    	int expected=2;
        int actual=mathUtils.addNums(1, 1);
        assertEquals(expected, actual);
    }
  }
  
  @Test
  @DisplayName("Testing Divide Method")
  void testDivide() {
    assertThrows(ArithmeticException.class, () -> mathUtils.divNums(1, 0),"Divded by zero");
  }
  @Test
  @DisplayName("Testing Name Method")
  void testName() {
    String expected="PatanNagoorKhan";
    assertNotEquals(expected, mathUtils.name("Patan"), "The test case failed ");
  }
  
}
