
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
public class Problem28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigInteger sum = BigInteger.valueOf(0);
        long num = 1;
        int gridSize = 1001;
        int step = 2, count = 0;
        
        while(num <= gridSize * gridSize){
            
            System.out.println("the number is " + num);
            if(count == 4){
                count = 0;
                step += 2;
            }
            
            sum = sum.add(BigInteger.valueOf(num));
            
            System.out.println("The sum is " + sum.toString());
            num += step;
            
            count++;
        }
        
        
        
        System.out.println(sum.toString());
    }
    
}
