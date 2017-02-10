package Problems10to19;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Problem12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creating the number num that we are going to add to and the amount x that we add by
        int num = 0, x = 1;
        // temp int for number of divisors
        int temp = 0;
        while(temp < 500){
            num += x;
            temp = numFactors(num);
                    
            x++;
            
            System.out.println(num + ", " + temp);
        }
        
        
    }
    
    static private int numFactors(int x){
        //int for storing number of factors
        int factors = 1;
        
        for(int i = 1; i <= Math.sqrt(x); i++){
            if(x % i == 0 && i * i == x) factors++;
            else if(x % i == 0) factors += 2;
        }
        
        return factors;
    }
    
}
