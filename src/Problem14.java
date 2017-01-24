/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Problem14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Goal: Find the largest Collatz sequence for a number under one million
        
        //store the number and its Collatz length
        
        int num = 0; int length = 0;
        
        for(int i = 1; i < 1000000; i++){
            long temp = i;
            int tempLength = 1;
            while(temp > 1){
                tempLength ++;
                if(temp % 2 == 0){
                    temp /= 2;
                    
                }
                else{
                    temp = (3 * temp) + 1;
                    
                }
            }
            
        
            
            if(tempLength >= length){
                num = i;
                length = tempLength;
                System.out.println(i + ", " + tempLength);
            }
          
        }
        
        System.out.println(num + ", " + length);
    }
    
}
