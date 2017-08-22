/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems20to29;

/**
 *
 * @author gabriel
 */
public class Problem21 {

    /**
     Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
    If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

    For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

    Evaluate the sum of all the amicable numbers under 10000.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int x = 10000;
        
        int amicableSum = 0;
        int[] divisors = new int[x];
        
        //find the sums of the proper divisors.
        for(int i = 1; i < divisors.length; i++){
            for(int j = 1; j < i; j++){
                if(i % j == 0) divisors[i] += j;
            }
        }
        
        //add up all of the amicable numbers
        for(int i = 1; i < divisors.length - 1; i++){
            for(int j = i + 1; j < divisors.length; j++){
                if(divisors[i] == j && divisors[j] == i && divisors[i] != 0){
                    
                    System.out.println(i + " " + j);
                    amicableSum += divisors[i];
                    amicableSum += divisors[j];
                    divisors[i] = 0;
                    divisors[j] = 0;
                    
                }
            }
        }
        
        System.out.println(amicableSum);
        
        
    }
    
}
