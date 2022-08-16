import java.util.Arrays;
//Siya Kamat
//period 7

class Main {
  public static void main(String[] args) {
    int[] arrA = {27, 15, 15, 11, 27};
    int[] arrB = {1, -2, 4, -4, 9, -6, 16, -8, 25, -10};
    int[] arrC = {74, 85, 102, 99, 101, 56, 84};

    System.out.println("The mean of the array " + (Arrays.toString(arrA)) + " is: " + mean(arrA));
     System.out.println("The mode of the array " + (Arrays.toString(arrA)) + " is: " + mode(arrA));
     System.out.println("The standard deviation of the array " + (Arrays.toString(arrB)) + " is: " + stdev(arrB));
     System.out.println("The median of the array " + (Arrays.toString(arrC)) + " is: " + median(arrC));
     System.out.println("The 2nd largest number of the array " + (Arrays.toString(arrC)) + " is: " + kthLargest(arrC, 2));
  }

/** Calculates the average of an array of numbers
@param arr - array
@return average - average of the numbers
*/
  public static double mean (int[] arr){
    double total = 0;
    for(int i=0; i<arr.length; i++){
        	total = total + arr[i];
    }
    double average = total / arr.length;
    return average;
  }

/** Calculates the most frequently occurring element of an array
@param arr - array
@return mode - most frequently occuring number
*/
  public static int mode (int[] arr){
    int mode = arr [0];
    int maxCount = 0;
    for (int i = 0; i < arr.length; i++){
        int value = arr[i];
        int count = 1;
        for (int j = 0; j < arr.length; j++){
            if (arr[j] == value) 
              count++;
            if (count > maxCount){
                mode = value;
                maxCount = count;
            }
        }
    }
    return mode;
  }

/** Calculates the standard deviation of an array 
@param arr - array
@return standDev - standard deviation of numbers
*/
  public static double stdev (int[] arr){
    double total = 0;
    for (int i = 0; i < arr.length; i++){
      total = total + Math.pow(arr[i] - mean(arr), 2);
    }
    double standDev = Math.sqrt (total / (arr.length -1));
    return standDev;
  }

/** Calculates the the median of the numbers in the array 
@param arr - array
@return median - median of numbers
*/
  public static double median (int[] arr){
    int value;
    for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr.length; j++){
        if (arr[i] < arr[j]){
          value = arr[i];
          arr[i] = arr[j];
          arr[j] = value;
        }
      }
    }
    double median = 0;
    if (arr.length % 2 == 0){
      median = ((double)arr[arr.length / 2] + (double)arr[(arr.length/ - 1) / 2]) / 2;
    }
    else{
      median = (double) arr[(arr.length - 1) / 2];
    }
    return median;
  }

/** Calculates the the kth largest integer of the array
@param arr - array
@param k - number used for k
@return - the element such that k elements have greater or equal value
*/
  public static int kthLargest (int[] arr, int k){
    int value;
    for (int i = 0; i < arr.length; i++){
      for (int j = 0; j < arr.length; j++){
        if (arr[i] > arr[j]){
          value = arr[i];
          arr[i] = arr[j];
          arr[j] = value;
        }
      }
    }
    return arr[k];
  }
}

/*
The mean of the array [27, 15, 15, 11, 27] is: 19.0
The mode of the array [27, 15, 15, 11, 27] is: 27
The standard deviation of the array [1, -2, 4, -4, 9, -6, 16, -8, 25, -10] is: 11.23733855402505
The median of the array [74, 85, 102, 99, 101, 56, 84] is: 85.0
The 2nd largest number of the array [56, 74, 84, 85, 99, 101, 102] is: 99
  */
