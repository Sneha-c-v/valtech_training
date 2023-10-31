package FancyPhoneNumberTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import FancyPhoneNumber.FancyPhoneRanker;

class FancyPhoneNumberTest {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
	}
	@Test
    public void testFancyPhoneWithAllDigitsSame() {
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("8888888888");
        List<String> rankedPhoneNumbers = FancyPhoneRanker.rankFancyPhoneNumbers(phoneNumbers);
        assertEquals("8888888888", rankedPhoneNumbers.get(0));
    }
 
    @Test
    public void testFancyPhoneWithPalindrome() {
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("12321");
        List<String> rankedPhoneNumbers = FancyPhoneRanker.rankFancyPhoneNumbers(phoneNumbers);
        assertEquals("12321", rankedPhoneNumbers.get(0));
    }
 
    @Test
    public void testNonFancyPhoneWithRandomDigits() {
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("9876543210");
        List<String> rankedPhoneNumbers = FancyPhoneRanker.rankFancyPhoneNumbers(phoneNumbers);
        assertEquals("9876543210", rankedPhoneNumbers.get(0));
    }
    @Test
    public void testNonFancyPhoneWithAscendingOrder() {
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("0123456789");
        List<String> rankedPhoneNumbers = FancyPhoneRanker.rankFancyPhoneNumbers(phoneNumbers);
        assertEquals("0123456789", rankedPhoneNumbers.get(0));
    }
    @Test
    public void testNonFancyPhoneWithDescendingOrder() {
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("9876543210");
        List<String> rankedPhoneNumbers = FancyPhoneRanker.rankFancyPhoneNumbers(phoneNumbers);
        assertEquals("9876543210", rankedPhoneNumbers.get(0));
    }
	}

	

