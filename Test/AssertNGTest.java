/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAutomation;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author srija
 */
public class AssertNGTest {
    
    public AssertNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of assertEquals method, of class Assert.
     */
    @Test
    public void testAssertEquals() {
        System.out.println("assertEquals");
        String expected_page_title = "";
        String title = "";
        Assert.assertEquals(expected_page_title, title);
        fail("The test case is a prototype.");
    }
    
}
