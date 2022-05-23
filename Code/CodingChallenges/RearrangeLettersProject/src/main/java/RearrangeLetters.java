public class RearrangeLetters {
    public static void main(String[] args) {
        System.out.println(rearrange("abcabcgfeke"));
    }
    public static String rearrange(String str) {
        String result = "";
        //Storing letters in char array
        char letterArray[] = str.toCharArray();
        //Alphabetizing the letters
        for (int i=0; i<letterArray.length; i++) {
            for (int j=i+1; j<letterArray.length; j++) {
                char temp;
                if (letterArray[i] > letterArray[j]) {
                    temp = letterArray[i];
                    letterArray[i] = letterArray[j];
                    letterArray[j] = temp;
                }
            }
        }
        //Dropping letter w/ only one occurrence
        for(int i=0; i<letterArray.length; i++) {
            for(int j=i+1; j< letterArray.length; j++) {
                if(letterArray[i] == letterArray[j]) {
                    result += letterArray[i];
                    result += letterArray[j];
                }
            }
        }
        return result;
    }
}
