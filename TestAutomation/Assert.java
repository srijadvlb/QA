/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAutomation;

/**
 *
 * @author srija
 */
class Assert {

    static void assertEquals(String expected_page_title, String title) {
        if(!expected_page_title.contains(title))       
        throw new UnsupportedOperationException("Page title doesnt match");
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
