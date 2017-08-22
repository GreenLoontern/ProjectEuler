/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems20to29;

import java.util.Arrays;

/**
 *
 * @author gabriel
 */
public class NameMergeSort {
    
    static String[] names;
    static String[] helper;
    
    public NameMergeSort(String[] x){
        
        names = new String[x.length];
        
        //copy the passed array into our array
        for(int i = 0; i < x.length; i++){
            names[i] = x[i];
        }
        //create a helper with the same length
        helper = new String[x.length];
        
    }
    
    public String[] sortNames(){
        int number = names.length;
                
        mergesort(0, number - 1);
        
        return names;
    }
    
    private void mergesort(int low, int high) {
                // check if low is smaller then high, if not then the array is sorted
                if (low < high) {
                        // Get the index of the element which is in the middle
                        int middle = low + (high - low) / 2;
                        // Sort the left side of the array
                        mergesort(low, middle);
                        // Sort the right side of the array
                        mergesort(middle + 1, high);
                        // Combine them both
                        merge(low, middle, high);
                }
        }

        private void merge(int low, int middle, int high) {

                // Copy both parts into the helper array
                for (int i = low; i <= high; i++) {
                        helper[i] = names[i];
                }
                
//                System.out.println(Arrays.toString(helper));

                int i = low;
                int j = middle + 1;
                int k = low;
                // Copy the smallest values from either the left or the right side back
                // to the original array
                while (i <= middle && j <= high) {
                        if (helper[i].compareTo(helper[j]) < 0) {
                                names[k] = helper[i];
                                i++;
                        } else {
                                names[k] = helper[j];
                                j++;
                        }
                        k++;
                }
                // Copy the rest of the left side of the array into the target array
                while (i <= middle) {
                        names[k] = helper[i];
                        k++;
                        i++;
                }

        }
    
}
