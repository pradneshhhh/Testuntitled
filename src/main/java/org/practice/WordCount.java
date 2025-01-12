package org.practice;

public class WordCount {

    public static void main(String[] args) {
        String sentence = "This is a sample sentence to count words"; // Example sentence
        int wordCount = countWords(sentence);
        System.out.println("Number of words in the sentence: " + wordCount);
    }

    private static int countWords(String sentence) {
        return sentence.split(" ").length;
    }
}
