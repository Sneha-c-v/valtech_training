package htmlParserTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import htmlParser.CSSParser;

class CSSParserTest {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
    public void testParseValidCssFile() {
        String validCssContent = ".class1 { color: #FF0000; } .class2 { font-size: 12px; }";
        List<String> result = CSSParser.parseCss(validCssContent);
 
        assertEquals("Class Selector: class1", result.get(0));
        assertEquals("Hex Color Attribute: color = rgb(255,0,0)", result.get(1));
        assertEquals("Class Selector: class2", result.get(2));
        assertEquals("Int Attribute: font-size = 12", result.get(3));
    }
 
    @Test
    public void testParseEmptyCssContent() {
        String emptyCssContent = "";
        List<String> result = CSSParser.parseCss(emptyCssContent);
 
        assertEquals(0, result.size());
    }
 
    @Test
    public void testParseMalformedCssContent() {
        String malformedCssContent = ".class1 { color: #FF0000; .class2 { font-size: 12px; }";
        List<String> result = CSSParser.parseCss(malformedCssContent);
 
        assertEquals(0, result.size());
    }
 
    @Test
    public void testParseCssWithNoClassSelectors() {
        String cssContent = "body { background-color: #FFFFFF; } h1 { font-size: 24px; }";
        List<String> result = CSSParser.parseCss(cssContent);
 
        assertEquals(0, result.size());
    }
 
    @Test
    public void testParseCssWithComments() {
        String cssContent = ".class1 { /* Comment */ color: #FF0000; } .class2 { font-size: 12px; }";
        List<String> result = CSSParser.parseCss(cssContent);
 
        assertEquals("Class Selector: class1", result.get(0));
        assertEquals("Hex Color Attribute: color = rgb(255,0,0)", result.get(1));
        assertEquals("Class Selector: class2", result.get(2));
        assertEquals("Int Attribute: font-size = 12", result.get(3));
    }

}
