public class ArrayOps {
    public static void main(String[] args) {
        int [] arr = {1, -2, 3, 4};
        System.out.println(isSorted(arr));
    }
    
    public static int findMissingInt (int [] array) {
        int missingNum = 0;
        
        // find min value
        int min = array[0];
        int count = 0;
        while(min != 0 && count < array.length){
            if( array[count] == 0){
                min = 0;
            }
            count++;
        }

        // if the group doesnt have the value zero return zero
        if( min == 1)
            return 0;

        boolean isMissing = false;
        boolean nextOne = false;
        // loops that find the missing number
        while (isMissing == false) {
            int i = 0;
            while (nextOne == false && i < array.length){
                if (array[i] == min + 1){
                    min = array[i];
                    nextOne = true;
                }
                i++;
            }
            if(nextOne == false){
                missingNum = min + 1;
                isMissing = true;
            }
            else{
                nextOne = false;
            }
        }

        return missingNum;
    }

    public static int secondMaxValue(int [] array) {
        int max1;
        int max2;
        // decided which number between the first two numbers in the arr is bigger
        if (array[0] > array[1]){
            max1 = array[0];
            max2 = array[1];
        }
        else{
            max1 = array[1];
            max2 = array[0];
        }

        for (int i = 2; i < array.length; i++){
            if (array[i] > max1){
                max2 = max1;
                max1 = array[i];
            }
            else if (array[i] > max2){
                max2 = array[i];
            }
        }
        return max2;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        // need to check both loops. a->b and b->a
        Boolean isIdentical = false;
        
        // a->b
        for (int i1 = 0; i1 < array1.length; i1++){
            //restart the boolean to check id next num is identical
            isIdentical = false;
            for (int i2 = 0; i2 <array2.length; i2++){
                if (array1[i1] == array2[i2]) {
                    isIdentical = true;
                    break;
                }
            }
            // if we didnt find a number from arr1 that equal to arr2 can return false
            if (isIdentical == false) {
                return isIdentical;             
            }
        }

        // b->a
        for (int i1 = 0; i1 < array2.length; i1++){
            //restart the boolean to check id next num is identical
            isIdentical = false;
            for (int i2 = 0; i2 <array1.length; i2++){
                if (array2[i1] == array1[i2]) {
                    isIdentical = true;
                    break;
                }
            }
            // if we didnt find a number from arr1 that equal to arr2 can return false
            if (isIdentical == false) {
                return isIdentical;           
            }
        }

        return isIdentical;
    }

    public static boolean isSorted(int [] array) {
        boolean goingUp = false;
        boolean goingDown = false;

        // first loop create to find the trend
        // i < array.length -1 always checking i and i +1 so no out of bounds
        int i = 0;
        while ((goingDown == false) && (goingUp == false) && (i < array.length -1)) {
            if(array[i] > array[i+1])
                goingDown = true;
            
            else if(array[i] < array[i+1])
                goingUp = true;
            
            else
                i++;
            
        }

        // if all the number in the arr equal return true
        if((goingDown == false) && (goingUp == false))
            return true;

        // i < array.length -1 always checking i and i +1 so no out of bounds
        for (int j = 0; j < array.length - 1; j++){
            if((array[j] >= array[j+1]) && (goingDown == true)){
                j++;
            }
            else if((array[j] <= array[j+1]) && (goingUp == true)){
                j++;
            }
            // position i and i+1 break the trend
            else {
                return false;
            }
        }

        return true;
    }

}
