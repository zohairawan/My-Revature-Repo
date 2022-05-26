public class RearrangeDig {

    public static void main(String[] args) {
        RearrangeDig r = new RearrangeDig();
        r.rearrangeNum(937249);
    }

    public void rearrangeNum(int n) {
        //Converts int n to String
        String num = String.valueOf(n);
        //Creates array based on size of n
        int numArray[] = new int[num.length()];
        int index = 0;
        while(n != 0) {
            //Stores right most digit of n
            int pop = n % 10;
            //Drops right most digit of n
            n /= 10;
            //Places right most digit into array
            numArray[index] = pop;
            index++;
        }
        //Sorts greatest to least
        for(int i = 0; i < numArray.length; i++) {
            for(int j = i+1; j < numArray.length; j++) {
                if(numArray[i] < numArray[j]) {
                    int temp = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }
        //Prints array
        for(int numbers : numArray) {
            System.out.print(numbers + " ");
        }
    }

    public void rearrange(int n) {
        String num = String.valueOf(n);
        char numArray[] = num.toCharArray();
        String newNum = "";
        int result;

        for(int i = 0; i < numArray.length; i++) {
            for(int j= i+1; j < numArray.length; j++) {
                if(numArray[i] < numArray[j]) {
                    char temp = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }
        for(char letter : numArray) {
            newNum += letter;
        }
        result = Integer.parseInt(newNum);
        System.out.println(result);
    }
}
