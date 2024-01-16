public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
       
    }

    public static String capVowelsLowRest (String string) {
        String answer = "";
        for(int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            int ascii = (int) c;
            //if the char is upper case keep the vowels and space as is and change the other chars to lowercase
            if((ascii > 64 && ascii < 91) || ascii == 32){
                if(ascii == 65 || ascii == 69 || ascii == 73 || ascii == 79 || ascii == 85 || ascii == 32){
                    answer += c;
                }
                else{
                    ascii += 32;
                    answer += (char) ascii;
                }
            }
            // if the char is lower case change vowels to uppercase and keep the other chars as is
            else{
                if(ascii == 97 || ascii == 101 || ascii == 105 || ascii == 111 || ascii == 117){
                    ascii -= 32;
                    answer += (char) ascii;
                }
                else{
                    answer += c;
                }
            }
        }
        return answer;
    }

    public static String camelCase (String string) {
        String answer = "";
        int count2 = 0;
        int count1 = 0;
        // if the word start with space
        if(string.indexOf(" ") == 0){
            boolean firstSpace = true;
            while(firstSpace == true){
                if(string.charAt(count1) == ' '){
                    count1 ++;
                }
                else{
                    firstSpace = false;
                }
            }
            count2 = count1;
        }

        // length of first word 
        char b = string.charAt(count2);
        while(b != ' '){
            count2++;
            b = string.charAt(count2);
        }

        // make the first word to lowercase
        for(int i = count1; i < count2; i++){
            char c = string.charAt(i);
            int ascii = (int) c;
            if(ascii > 64 && ascii < 91){
                ascii += 32;
                answer += (char) ascii;
            }
            else{
                answer += c;
            }
        }

        boolean isSpace = true;
        for(int i = count2; i < string.length(); i++){
            char c = string.charAt(i);
            int ascii = (int) c;
            // if char is space delete it form the answer
            if(ascii == 32){
                isSpace = true;
            }
            // if the first letter in a word is lowercase make it uppercase else keep it as is
            else if (isSpace == true){
                if(ascii > 64 && ascii < 91){
                    answer += c;
                }
                else{
                    ascii -= 32;
                    answer += (char) ascii;
                }
                isSpace = false;
            }
           
            // if letter is not first make it lowercase
            else{
                if(ascii > 96 && ascii < 123){
                    answer += c;
                }
                else{
                    ascii += 32;
                    answer += (char) ascii;
                }
            }
        }
        return answer;
    }

    public static int[] allIndexOf (String string, char chr) {
        int count = 0;
        // check how many time chr appear in the given string
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i)== chr){
                count ++;
            }
        }

        int [] answer = new int[count];
        int place = 0;

        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == chr){
                answer[place] = i;
                place ++;
            }
        }

        return answer;
    }
}
