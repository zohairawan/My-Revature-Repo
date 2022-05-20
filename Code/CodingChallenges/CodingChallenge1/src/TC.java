public class TC {
    public static int countSubstring(String s)
    {
        int result = 0;
        for(int i = 0; i < s.length()-2; i++) {
            char letter1 = s.charAt(i);
            char letter2 = s.charAt(i+1);
            char letter3 = s.charAt(i+2);
            if(letter1 == 'a' || letter1 == 'e' || letter1 == 'i' || letter1 == 'o' || letter1 == 'u') {
                if (letter2 == 'a' || letter2 == 'e' || letter2 == 'i' || letter2 == 'o' || letter2 == 'u') {
                    if (letter3 == 'a' || letter3 == 'e' || letter3 == 'i' || letter3 == 'o' || letter3 == 'u') {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println( countSubstring("aeiupouifeaiu"));;
    }
}
