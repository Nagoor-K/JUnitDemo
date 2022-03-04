package com.nagoor.junit.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
    MathUtils mathUtils;
    TestInfo info;
    TestReporter reporter;
    
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
	void init(TestInfo info, TestReporter reporter) {
		mathUtils=new MathUtils();
		this.info=info;
		this.reporter=reporter;
	}
    
    @AfterEach
    void testClean() {
    	System.out.print("This will run after each method");
    }
    
    @Test
	@DisplayName("Asserton Methods")
    void testAssertionAll() {
    	reporter.publishEntry("Running "+info.getTestMethod()+" with tags"+info.getTags());
    	assertAll(
    				() -> assertEquals(4, mathUtils.mulNums(-2, -2)),
    				() -> assertNotEquals(-4, mathUtils.addNums(-1, -2)),
    				() -> assertEquals(16, mathUtils.divNums(32, 2))
    			
    			);
    }
    
  @Nested
  @DisplayName("Testing Add Method")
  @Tag("Math")
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
  @Tag("Math")
  void testDivide() {
    assertThrows(ArithmeticException.class, () -> mathUtils.divNums(1, 0),"Divded by zero");
  }
  @RepeatedTest(3)
  @DisplayName("Testing Name Method")
  @Tag("Name")
  void testName() {
    String expected="PatanNagoorKhan";
    assertNotEquals(expected, mathUtils.name("Patan"), "The test case failed ");
  }
  
}
