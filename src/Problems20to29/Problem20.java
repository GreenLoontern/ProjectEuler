/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems20to29;

import java.math.BigInteger;

/**
 *
 * @author gabriel
 */
public class Problem20 {

    /*
    n! means n × (n − 1) × ... × 3 × 2 × 1

    For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
    and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

    Find the sum of the digits in the number 100!
    */
    public static void main(String[] args) {
        BigInteger x = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;
        BigInteger ten = BigInteger.TEN;
        
        int n = 100;
        
        //multiply them all together
        for(int i = 1; i <= n; i++){
            x = x.multiply(BigInteger.valueOf(i));
        }
        
        //mod 10 to get the last digit, add it to the sum, and then divide it by 10.
        while(x.compareTo(BigInteger.ZERO) == 1){
            sum = sum.add(x.mod(ten));
            x = x.divide(ten);
        }
        
        System.out.println(sum.toString());
    }
    
}
