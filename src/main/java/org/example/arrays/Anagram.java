//package org.example.arrays;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.stream.Collectors;
//
//public class Anagram {
//
//    public static String sortChars(String str) {
//        return Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
//    }
//
//    public static void main(String[] args) {
//        List<String> input = List.of("cat","dog","tac","god","act");//[[cat,tac,act],[god,dog]]
//        Map<String, CopyOnWriteArrayList<String>> anagramMap = new HashMap<>();
//        for(String str: input) {
//            String sortedStr = sortChars(str);
//            List<String> res = anagramMap.get(sortedStr);
//            if(res!=null && !res.isEmpty()) {
//                res.add(str);
//                anagramMap.put(sortedStr, res);
//            } else {
//                List<String> list = new CopyOnWriteArrayList<>();
//                anagramMap.put(sortedStr, list.add(str));
//            }
//        }
//    }
//
//    Map<String,List<String>> anagramMap = new HashMap<>();
//for(String word : array){
//        char[] chars = words.toCharArray();
//        Arrays.sort(cahars);
//        String sortedWord = new String(chars);
//        if(!anagramMap.containsKey(sortedWord)) {
//            anagramMap.put(sortedWord,new ArrayList<>());
//            anagram<ap.get(sortedWord).add(word):
//        }
//        else anagramMap.get(sortedWord).add(word);
//    }
//    List<List<Strings>> anagramGroups = new ArrayList<>();
//for(List<String> anagramsList : anagramMap.values()){
//        if(anagramsList.size()>1) anagramGroup.add(anagramsList);
//    }
//}
//System.out.println(anagramGroups);
//}
