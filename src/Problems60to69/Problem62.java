/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems60to69;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Problem62 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create an arrayList for each number
        List<Long> nums = new ArrayList<Long>();
        //create an arrayList for the largest permutation of each number
        List<Long> permutation = new ArrayList<Long>();
        //create an arrayList for the count of permutations that match that number (count goes to lowest of the two);
        List<Integer> count = new ArrayList<Integer>();
        
        //number that is used for the goal
        final int goal = 5;
        
        //current largest common permutation
        int largest = 0;
        
        //current number that is being cubed
        long current = 1;
        
        while(count.indexOf(goal) == -1){
            
//            System.out.println(current);
            
            //add the current number to the list
            nums.add(current);
            count.add(0);
            
            //find the largest permutation of that number
            long permuted = sortLargest(current * current * current);
            
            //store the permutation in the list
            permutation.add(permuted);
            
            //find out whether any previous numbers share the permutation
            if(permutation.indexOf(permuted) >= 0){
                int index = permutation.indexOf(permuted);
                count.set(index, count.get(index) + 1);
                if(count.get(index) >= largest) largest = count.get(index);
                
            }           
            
            current++;
            
        }
        long smallest = 1 +count.indexOf(largest);
        System.out.println(largest + " primes share a common permutation, the lowest of which is " + smallest);
        System.out.println("The value of the smallest cube is " + smallest * smallest * smallest);
        
        
    }
    
    private static List<Integer> x = new ArrayList<Integer>();

    private static long sortLargest(long pow) {
        
        //take the long and convert it into an array of digits
        x.clear();
//        System.out.println(pow);
        while(pow > 0){
            x.add((int)Math.abs(pow % 10));
            pow /= 10;
        }
        
//        System.out.println(x.toString());
        int[] digits = new int[x.size()];
        for(int i = 0; i < digits.length; i++){
            digits[i] = x.get(digits.length - 1 - i);
        }       
        
        //sort the array from largest to smallest
        MergeSort ms = new MergeSort();
        int[] sorted = ms.sort(digits);
        
        //convert the sorted array back into a long
        long largest = 0;
        for(int i = 0; i < sorted.length; i++){
            largest *= 10;
            largest += sorted[i];
        }
        
        //return the long
//        System.out.println(largest);
        return largest;
    }
    
    
    
}
