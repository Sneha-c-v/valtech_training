package firstWeb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class WebsiteTextProcessing {
	 public static void main(String[] args) {
	        // Step 1: Create a set of common words
	        Set<String> commonWords = new HashSet<>();
	        commonWords.add("is");
	        commonWords.add("as");
	        commonWords.add("if");
	        commonWords.add("and");
	        commonWords.add("the");
	        commonWords.add("in");
	        commonWords.add("on");
	        commonWords.add("into");
	        commonWords.add("does");
	        commonWords.add("to");
	        commonWords.add("for");
	        commonWords.add("of");
	        commonWords.add(",");
	        
	        
	        
	        
	        // Add more common words as needed...
	 
	        // Step 2: Read the text from the input file
	        String inputFileName = "sample.txt";
	        String outputFileName = "output.txt";
	 
	        // Step 3: Create a map to store word counts
	        Map<String, Integer> wordCountMap = new HashMap<>();
	 
	        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
	             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
	 
	            String line;
	            while ((line = reader.readLine()) != null) {
	                // Step 4: Tokenize the text into words
	                String[] words = line.split("\\s+");
	                for (int i=0;i<words.length;i++) {
	                	words[i]=words[i].replaceAll("[^a-zA-Z]", "");
	                }
	 
	                // Step 5: Remove common words and count the remaining words
	                for (String word : words) {
	                    if (!commonWords.contains(word.toLowerCase())) {
	                        writer.write(word + " ");
	                        
	                        // Update the word count map
	                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
	                    }
	                }
	                writer.newLine();
	            }
	 
	            System.out.println("Common words removed and saved to " + outputFileName);
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	        // Step 6: Display the remaining word counts
	        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }
}

