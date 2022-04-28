import java.util.*;

/*
 * you know phones have letters under each digit from 2 to 9. this makes it it possible for businesses to have phone numbers that easy to remember
 1800-amazon  maps to 1800-262966  for example

you are given a list of words from a dictionary
dictionary = [aluminium, amazon, flowers, hut, pizza .... ]
write a class/function that takes a phone number and returns all words in the dictionary contained within that phone number 
phone_dict = PhoneDict([aluminium, amazon, flowers, hut, pizza .... ])
phone_dict.words_in_number("1800 74992488") -> [hut, pizza] 
phone_dict.words_in_number("1800 356 9377") -> [flowers]  
   

because pizza -> 74992 and 488 -> hut

order of words does not matter as long as all words are returned
if no words are contained in the phone number then return empty list
list of words can be large say up to 1 million words
phone number length won't be more than 24 digits 

Assume 1800 is not going to be converted to string and will always be there

-------------------------
|       |  ABC  |  DEF  |
|   1   |   2   |   3   |
-------------------------
|  GHI  |  JKL  |  MNO  |
|   4   |   5   |   6   |
-------------------------
| PQRS  |  TUV  | WXYZ  |
|   7   |   8   |   9   |
-------------------------
|       |       |       |
|   *   |   0   |   #   |
-------------------------


*/


public class PhoneButtonEncoding {
	static final String[] CHARS = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	//convert the dictionary one time or build a trie 
	static String[] WORDS = new String[] {"bob", "zyrus", "pizza", "james", "alice"};
	static class PhoneNumToWord {
    private final HashMap<String, Collection<String>> sigToWords = new HashMap();
    PhoneNumToWord(String[] words) {
      for(int i =0; i < words.length; i++) {
        String num = toNum(words[i]);
        Collection<String> wordsForNum = sigToWords.computeIfAbsent(num, k -> new HashSet<String>());
        wordsForNum.add(words[i]);
        
      }
    }

    private Collection<String> wordsInNum(String phoneNumber) {
		ArrayList<String> result = new ArrayList<String>();
      for(int i = 0; i < phoneNumber.length(); i++) {
        for(int j = i+1; j < phoneNumber.length(); j++) {
          Collection<String> words = sigToWords.getOrDefault(phoneNumber.substring(i,j+1), Collections.EMPTY_LIST);
          result.addAll(words);
        }
      }
		return result;
	}

    private static String toNum(String word) {
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        sb.append(charToDigit(ch));
      }
      return sb.toString();
    }
  }

  private static char charToDigit(char ch) {
    for(int i=2; i < CHARS.length; i++) {
      if(CHARS[i].indexOf(ch) != -1) {
        return (char)(i+48); //int to ascii value
        }
    }
    return '0';
    
  }
  
	public static void main(String[] args) {
		
		PhoneNumToWord phone_dict = new PhoneNumToWord(WORDS);
		
		System.out.print(phone_dict.wordsInNum("1800 7499248824"));
    System.out.print(phone_dict.wordsInNum("1800 254234262"));
		
	}

}
