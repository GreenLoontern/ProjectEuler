/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems20to29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Problem24 {

    /**
A permutation is an ordered arrangement of objects. For example, 
3124 is one possible permutation of the digits 1, 2, 3 and 4. 
If all of the permutations are listed numerically or alphabetically, 
we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
     */
    public static void main(String[] args) {
        List<Integer> digits =  new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        
       int count = 1000000;
       
       long end = 0;
       
       for(int i = 9; i >= 0; i--){
           
           int num = factorial(i);
           System.out.println(num + " " + i);
           int step = 1;
           while((step + 1) * num < count){
               step++;
           }
           if(step * num == 1) break;
           
           count -= (num * step);
           
           System.out.println(step  * num + " count = " + count);
           
           if(count == 1){
               end *= 10;
           end += digits.get(step + 1);
           digits.remove(step + 1);
           }
           
           end *= 10;
           end += digits.get(step);
           digits.remove(step);
           
           
           System.out.println(digits.toString());
           
           if(count == 0) break;
           
       }
       
       while(digits.size() > 0){
           end *= 10;
           end += digits.get(0);
           digits.remove(0);
       }
       
       System.out.println(end);
    }
    
    public static int factorial(int max){
        if(max == 0) return 1;
        int total = 1;
        for(int i = max; i > 1; i--){
            total *= i;
        }
        
        return total;
    }    
}
