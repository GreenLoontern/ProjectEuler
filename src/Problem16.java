
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Problem16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int pow = 1000, z = 2;
        
        BigInteger num = BigInteger.valueOf(z);
        
        num = num.pow(pow);
        
        BigInteger x = BigInteger.TEN;
        
        BigInteger sum = num.mod(x);
        
        BigInteger temp = num.divide(x);
        
        BigInteger zero = BigInteger.ZERO;
        
        do{
            
            
            System.out.println(temp.mod(x));
                    
             sum = sum.add(temp.mod(x));
             
             temp = temp.divide(x);
            
            
        }while(temp.compareTo(zero) == 1);
        
        System.out.println(sum.toString());
        
    }
    
}
