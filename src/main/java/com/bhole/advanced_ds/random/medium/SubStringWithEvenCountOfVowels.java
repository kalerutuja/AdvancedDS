package com.bhole.advanced_ds.random.medium;

import java.util.HashMap;
import java.util.Map;

public class SubStringWithEvenCountOfVowels {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> vowels =  new HashMap<>();
        vowels.put('a', 1);
        vowels.put('e', 2);
        vowels.put('i', 4);
        vowels.put('o', 8);
        vowels.put('u', 16);
        int state = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (vowels.containsKey(c)) {
                state = state ^ vowels.get(c);
            }
            if (map.containsKey(state)) {
                max = Math.max(max, i - map.get(state));
            } else {
                map.put(state , i);
            }
            String bin = Integer.toBinaryString(state);
            System.out.println(bin);

        }
        return max;
    }
    public static void main(String args[]) {
        String s= "eleetminicoworoep";
        SubStringWithEvenCountOfVowels subStringWithEvenCountOfVowels = new SubStringWithEvenCountOfVowels();
        System.out.println(subStringWithEvenCountOfVowels.findTheLongestSubstring(s));
    }
}
