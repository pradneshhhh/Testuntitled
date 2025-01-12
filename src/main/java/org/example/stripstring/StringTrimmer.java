package org.example.stripstring;

import java.net.MalformedURLException;
import java.net.URL;

public class StringTrimmer {
    public static String trimString(String input) {
        if (input == null) {
            return null;
        }
        return input.strip();
    }

    public static void main(String[] args) throws MalformedURLException {
        String input = "  Hello, World!    ";
        String trimmedString = trimString(input);
        System.out.println("Original String: \"" + input + "\"");
        System.out.println("Trimmed String: \"" + trimmedString + "\"");

        URL url = new URL("https://www.test.com/homepage?flag=true&signal=false");
        System.out.println(url.getProtocol()+" "+url.getHost()+" "+url.getPath()+" "+url.getQuery());
    }
}

