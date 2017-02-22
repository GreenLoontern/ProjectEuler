/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems20to29;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Problem23 {

    /**
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. 
For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, 
which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n 
and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest 
number that can be written as the sum of two abundant numbers is 24. 
By mathematical analysis, it can be shown that all integers greater than 28123 
can be written as the sum of two abundant numbers. However, this upper limit 
cannot be reduced any further by analysis even though it is known that the 
greatest number that cannot be expressed as the sum of two abundant numbers is 
less than this limit.

Find the sum of all the positive integers which cannot be written as the 
sum of two abundant numbers.
     */
    public static void main(String[] args) {
        List<Integer> AbundantNumbers = new ArrayList<Integer>();
        BigInteger AbundantSumSum = BigInteger.ZERO;
        int x = 28213;
        
        //find all of the abundant divisors
        for(int i = 0; i <= x; i++){
            if(getDivisors(i) > i){
                AbundantNumbers.add(i);
                 if (i % 2 == 1) System.out.println(i);
            }
        }
        
        //find if a number is the sum of two abundant numbers
        for(int i = 1; i <=x; i++){
            boolean FoundAlready = false;
            for(int j = AbundantNumbers.size() - 1; j >= 0; j--){
                if(FoundAlready) break;
                if(AbundantNumbers.indexOf(i - AbundantNumbers.get(j)) != -1){
                    FoundAlready = true;
                }
                
            }
            
            if(!FoundAlready){
                AbundantSumSum = AbundantSumSum.add(BigInteger.valueOf(i));
//                    System.out.println(i);
            }
        }
        
        System.out.println(AbundantSumSum.toString());
    }

    private static int getDivisors(int num) {
       int sum = 0;
       for(int i = 1; i < num; i++){
           if(num % i == 0) sum += i;
       }
       
       return sum;
    }
    
}
