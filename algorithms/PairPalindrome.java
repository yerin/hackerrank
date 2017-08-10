import java.util.*;

public class PairPalindrome {

    public static void main(String[] args) {
        String[] test1 = {"bag", "air", "gab", "hi"};
        String[] test2 = {"aire", "bob", "gigeria", "bobo", "mom", "sky", "o"};
        String[] test3 = {"abc", "cba", "c", "c", "aabc", "cb"};
        System.out.println(findPairPalindromes(test1));
        System.out.println(findPairPalindromes(test2));
        System.out.println(findPairPalindromes(test3));
    }

    public static Set<Set<String>> findPairPalindromes(String[] arr) {
        Set<String> input = new HashSet<String>(Arrays.asList(arr));
        Set<Set<String>> result = new HashSet<Set<String>>();

        for(String word: arr){
            //Prefix palindromes
            for(int i = 1; i <= word.length(); i++){
                String prefix = word.substring(0, i);
                String reversedPrefix = reverse(prefix);
                if (!isPalindrome(word) && isPalindrome(word + reversedPrefix) && input.contains(reversedPrefix)){
                    Set<String> pair = new HashSet<String>();
                    pair.add(word);
                    pair.add(reversedPrefix);
                    result.add(pair);
                }
            }

            //Postfix palindromes
            for(int j = word.length() - 1; j > 0; j--){
                String postfix = word.substring(j);
                String reversedPostfix = reverse(postfix);
                if (!isPalindrome(word) && isPalindrome(reversedPostfix + word) && input.contains(reversedPostfix)){
                    Set<String> pair = new HashSet<String>();
                    pair.add(word);
                    pair.add(reversedPostfix);
                    result.add(pair);
                }
            }
        }
        return result;
    }

    public static String reverse(String s){
        char[] charArr = s.toCharArray();
        int low = 0;
        int hi = charArr.length-1;
        while(low < hi){
            char temp = charArr[low];
            charArr[low] = charArr[hi];
            charArr[hi] = temp;
            low++;
            hi--;
        }

        return new String(charArr);
    }

    public static boolean isPalindrome(String s) {
        int low = 0;
        int hi = s.length()-1;
        while(low < hi){
            if (s.charAt(low) != s.charAt(hi)){
                return false;
            }
            low++;
            hi--;
        }
        return true;
    }
}