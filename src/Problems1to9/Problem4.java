package Problems1to9;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author G
 */
public class Problem4 {
    /*
    A palindromic number reads the same both ways. 
    The largest palindrome made from the product of two 2-digit
    numbers is 9009 = 91 × 99.
    Find the largest palindrome made from the product of two 3-digit numbers.
    */
    
    public static void main(String[] args){
        /*
        The first step is to generate all palindromes.
        We shall do this by taking a 3 digit number, starting at 999,
        and then we will mirror it. 6 digit numbers will be the full mirror
        and five digit numbers will be only the first two digits mirrored.
        
        We will start by assuming that the answer will be six numbers
        
        The second step is to generate factors for this palindrome.
        We will generate factor pairs one by one and then test them for three digits.
        
        The first 3 digit factor pair palindrome is the answer.
        */
        
        //cycle through palindromes
        for(int i = 999; i >= 100; i--){
            
            //so we know when to stop
            boolean answerFound = false;
            
            //step 1
            int pal = createPalindrome(i);
            
            //step 2
            for(int j = 100; j <= Math.sqrt(pal); j++){
//                System.out.println(j);
                if(pal % j == 0) {
                
                int k = pal / j;
                
                if(j >= 100 && k >= 100 && k < 1000){
                    System.out.println(pal);
                    answerFound = true;
                }
                }
            }
            
            if(answerFound) break;
        }
        
    }       

    private static int createPalindrome(int i) {
        
        //find ones digit
        int ones = i / 100;
        
        //find tens digit
        int tens = (i / 10) % 10;
        
        //find hundreds digit
        int hundreds = i % 10;
        
        //create palindrome
        int pal = (i * 1000) + (hundreds * 100) + (tens * 10) + (ones);
        
        return pal;
    }
}
