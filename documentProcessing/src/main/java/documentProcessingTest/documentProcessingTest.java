package documentProcessingTest;
import org.junit.jupiter.api.Test;

import documentProcessing.DocumentServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class documentProcessingTest {
 
    @Test
    public void testDoPost() throws ServletException, IOException {
        DocumentServlet servlet = new DocumentServlet();
        HttpServletRequest request = null; 
        HttpServletResponse response = null; 
 
        
        servlet.doPost(request, response);
 
    
    }
}
