package firstWeb;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountingVowelsinWord {
	
	public static void main(String[] args) {
		
	        String sentence = "Hello how are you?";
	        String[] words = sentence.split("[\\s.,!?]+"); // Updated regex to handle punctuation marks
	 
	        List<String> wordList = new ArrayList<>();
	 
	        for (String word : words) {
	            int vowelCount = countVowels(word);
	            wordList.add(word + ": " + vowelCount + " vowels");
	        }
	 
	        // Sort words based on vowel count in ascending order
	        Collections.sort(wordList, Comparator.comparingInt(s -> Integer.parseInt(s.split(":")[1].trim().split(" ")[0])));
	 
	        // Output sorted words
	        for (String word : wordList) {
	            System.out.println(word);
	        }
	    }
	 
	    public static int countVowels(String word) {
	        int count = 0;
	        for (char ch : word.toLowerCase().toCharArray()) {
	            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	                count++;
	            }
	        }
	        return count;
	    }
	 
		

	}


