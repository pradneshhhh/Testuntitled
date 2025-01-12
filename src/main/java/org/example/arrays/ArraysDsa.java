package org.example.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysDsa {

    public static boolean hasDuplicate(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       for(int i: nums){
           set.add(i);
       }
       return nums.length!=set.size();
    }

    public static boolean isAnagram(String s, String t) {
       if(s.length()!=t.length()) {
           return false;
       }
       int[] store = new int[26];
       for(int i=0; i<s.length(); i++) {
           store[s.charAt(i) - 'a']++;
           store[t.charAt(i) - 'a']--;
       }
       for(int i: store){
           if(i>0) {
               return false;
           }
        }
       return true;
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]+nums[j]==target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }
       return null;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new LinkedHashMap<>();
        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(map.containsKey(sorted)) {
                List<String> val = map.get(sorted);
                List<String> v = new ArrayList<>(val);
                v.add(str);
                map.put(sorted, v);
            } else {
                List<String> val = List.of(str);
                map.put(sorted, val);
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if(nums.length==1 || nums.length==0) {
            return nums;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i: nums) {
            if(map.containsKey(i)) {
                int count = map.get(i)+1;
                map.put(i, count);
            } else {
                map.put(i,1);
            }
        }
        return map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).mapToInt(m->m.getKey()).limit(k).toArray();
    }

    public static String encode(List<String> strs) {
        if((strs.size()==1&&strs.get(0).isBlank()) || strs.size()==0) {
            return "";
        }
        StringBuilder string = new StringBuilder();
        for(int i=0;i<strs.size();i++) {
            if(i==strs.size()-1) {
                string.append(strs.get(i));
            } else {
                string.append(strs.get(i)).append(",");
            }
        }
        return string.toString();
    }

    public static List<String> decode(String str) {
        if(str.isBlank()) {
            return List.of(str);
        }
        return Arrays.stream(str.split(",")).collect(Collectors.toList());
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        char[] res = new char[str.length()];
        for(int i=0;i<str.length();i++){
            res[i]=str.charAt(i);
        }
        int m=0;
        int l=0;
        int r=str.length()-1;
        while(m<str.length()/2){
            if(res[l]!=res[r]){
                return false;
            }
            l++;
            r--;
            m++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,6};
        System.out.println(hasDuplicate(nums));
        System.out.println(isAnagram("jar","jat"));
        System.out.println(Arrays.toString(twoSum(nums, 8)));
        System.out.println(Arrays.toString(twoSumHashMap(nums, 8)));
        String[] anagrams = {"act","pots","tops","cat","stop","hat"};
        System.out.println(groupAnagrams(anagrams).toString());
        int[] topKFrequent = {1,2,2,3,3,3};
        topKFrequent(topKFrequent, 2);
        System.out.println(decode(encode(List.of(""))));
        int[] productExceptSelfArr = {1,2,4,6};
        productExceptSelf(productExceptSelfArr);
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));
    }
}
