/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;

/**
 *
 * @author gabriel
 */
public class Problem10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //we already know from the problem that the sum of the primes 10 and down is 17 so
        int start = 11, end = 2000000;
        long sum = 17;
        
        while(start <= end){
            
            if(isPrime(start)) sum += start;
            
            
            start++;
        }
        
        System.out.println(sum);
    }
    
    static public boolean isPrime(int x){
        for(int i = 2; i <= Math.ceil(Math.sqrt(x)); i++){
            if(x % i == 0) return false;
        }
        
        return true;
    }
    
}
