/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Problem17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long sum = 0;
        
        int[] s = {0,3,3,5,4,4,3,5,5,4,3,6,6,8,8,7,7,9,8,8}; //zero through nineteen
        int[] d = {0,3,6,6,5,5,5,7,6,6};
        int h = 7;
        int t = 8;
        
        for(int i = 1; i <= 1000; i++){
            int ones = i % 10;
            int tens = (i / 10) % 10;
            int hundreds = (i / 100 % 10);
            int thousands = (i / 1000) % 10;
            
            //work out the tens and ones digits
            if(tens == 0 || tens == 1){ //if the number is less than twenty and is special
                sum += s[tens * 10 + ones];
            }
            else{
                sum += d[tens];
                sum += s[ones];
            }
            //work out the hundreds digit
            if(hundreds > 0){
                sum += s[hundreds] + h;
                //add the and the number is not an even hundred value (e.g. 100, 200, 300)
                if(i % 100 != 0) sum += 3;
            }
            
            //add the thousands digit
            if(thousands > 0)
            sum += s[thousands] + t;
            
        }
        
        System.out.println(sum);
        
    }
    
}
