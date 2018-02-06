import java.util.ArrayList;

public class KMP{

	/**
	* Calculates the length of the Longest proper Prefix of the pattern which is also the suffix.
	*/
	private static int[] computeLongestPrefix(String input){
		int[] longestPrefix = new int[input.length()];
		int i = 1;
		int length = 0;
		longestPrefix[0] = 0;
		while(i < input.length()){
			//Check whether there is a match for the last character of previous prefix with the new character
			//If yes, increase prefix by 1; 
			if(input.charAt(i) == input.charAt(length)){
				length++;
				longestPrefix[i] = length;
				i++; 
			}else{
				//If length is not zero means, there is a prefix of length-1 which needs to be compared with the new character.
				if(length!=0){
					length = longestPrefix[length-1];
				}else{
					//In this case the previous prefix size is zero and the new char doesnt match with last char of previous prefix.
					longestPrefix[i] = 0;
					i++;
				}
			}
		}
		return longestPrefix;
	}

	private static ArrayList<Integer> kmp(String text, String pattern, int[] longestPrefix){
        ArrayList<Integer> finalList = new ArrayList<>();
		int i = 0;
		int j = 0;
		while(i < text.length()){
		    //Check whether there is a match with the pattern.
			if(text.charAt(i) == pattern.charAt(j)){
			    //If yes, go to next character.
				i++;
				j++;
				//if the match of the pattern length reached, check whether the previous prefix from
                //right matches with the text.
                if(j==pattern.length()){
                    finalList.add(i-j);
                    j = longestPrefix[j-1];
                }
			}else if(i<text.length()){
			    //If no match, try checking from the index with previous prefix because if j doesn't satisfy
                // indices from start till that length also doesnt satisfy and can be ignored.
                if (j != 0) {
                    j = longestPrefix[j - 1];
                }else {
                    i++;
                }
            }
		}
		return finalList;
	}
	
	public static void main(String[] args){
		String pattern = "AABA";
		String input = "AABAACAADAABAABA";
		int[] longestPrefix = computeLongestPrefix(pattern);
		ArrayList<Integer> finalList = kmp(input, pattern, longestPrefix);
		for(int i = 0 ; i < finalList.size(); i++){
            System.out.println("Pattern found at "+finalList.get(i));
        }
	}
}