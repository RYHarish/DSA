public class Array {
    
    // Array demo
    public static void arrayDemo(){
        //Declaration and initialization of array
        // int arr[] = new int[5];
        // int[] arr4 = {3, 9, 3, 6, 7, 67, 43, 436, 2355};
        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
        
        
    }

    // Print array
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Remove even numbers from array
    public int[] removeEven(int arr[]){

        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 != 0){
                count++;
            }
        }

        int arr1[] = new int[count];
        int j = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 != 0){
                arr1[j] = arr[i];
                j++;
            }
        }

        return arr1;
    }

    // Reverse array
    public int[] reverseArray(int arr[]){

        for(int i =0; i <= arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - 1 - i] = temp;
        }

        return arr;
    }
    
    public int[] reverseArray(int arr[], int start, int end){

        while(start < end ){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return arr;
    }

    // Minimum element in array
    public int minimumElement(int arr[]){

        //edge case
        if(arr.length == 0){
            throw new IllegalArgumentException("Array is empty");
        }

        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }

        return min;
    }

    // Second maximun value in an array
    public int secondMax(int arr[]){

        //edge case
        if(arr.length < 2){
            throw new IllegalArgumentException("Array length is less than 2");
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length ; i++){
            if( arr[i] > max){
                secondMax = max;
                max = arr[i];
            }
            else if(arr[i] > secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }
        return secondMax;

    }

    // Move all zeros to end of an array
    // 0 1 0 3 12 0 0 78
    public int[] moveZeros(int arr[]){
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
        return arr;
    }

    //Resize a given array
    public int[] resizeArray(int arr[], int capacity){
        int[] temp = new int[capacity];
        
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
        return arr;
    }

    //Find a missing number
    public int findMissingNumb(int arr[]){
        int sum = (arr.length + 1) * (arr.length + 2) / 2;
        for(int i: arr){
            sum -= i;
        }
        return sum;
    }

    //Check palindrome
    public boolean isPalindrome(String word){
        char[] arr = word.toCharArray();
        int start = 0;  
        int end = arr.length - 1;
        while (end > start) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Helper method to print results
    public static void printResults(String message, int[] arr) {
        System.out.print(message+": ");
        printArray(arr);
        if (message.startsWith("After")) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println();
        Array array = new Array();
        int[] arr = {3, 9, 3, 6, 7, 67, 43, 436, 2355};

        // Remove even numbers from array
        printResults("Before removing even numbers", arr);
        printResults("After removing even numbers", array.removeEven(arr));

        // Reverse array
        printResults("Before reversing array", arr);
        printResults("After reversing array", array.reverseArray(arr));

        // Reverse array from start to end index
        printResults("Before reversing array from 1 to 3", arr);
        printResults("After reversing array from 1 to 3", array.reverseArray(arr, 1, 3));

        // Minimum element in array
        printResults("Array for minimum element", arr);
        System.out.println("Minimum element in array: " + array.minimumElement(arr)+ "\n");

        // Second maximum value in an array
        printResults("Array for second maximum value", arr);
        System.out.println("Second maximum value in array: " + array.secondMax(arr)+ "\n");

        // Move all zeros to end of an array
        int arrZeros[] = {0, 1, 0, 3, 12, 0, 0, 78};
        printResults("Before moving zeros to end", arrZeros);
        printResults("After moving zeros to end", array.moveZeros(arrZeros));

        // Resize array
        printResults("Before rezing the array", arr);
        printResults("After resizing the array", array.resizeArray(arr, 15));

        // Find a missing number
        int arrMissing[] = {1, 2, 3, 4, 5, 6, 7, 9, 10};
        printResults("Array for missing number", arrMissing);
        System.out.println("Missing number in array: " + array.findMissingNumb(arrMissing)+ "\n");

        // Check palindrome
        System.out.println("Is 'madam' a palindrome: " + array.isPalindrome("madam"));
        System.out.println("Is 'hello' a palindrome: " + array.isPalindrome("hello"));

    }

}

