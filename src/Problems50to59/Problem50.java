package Problems50to59;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Problem50 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //get a list of all of the primes
        List<Integer> l = getPrimes(1000000);
        
        //store the largest chain and the number that makes it that we already know of.
        int x = 953, chain = 21;
        
        //begin checking numbers for chains
        for( int i = l.indexOf(x); i < l.size(); i++){
            for(int offset = 0; offset < 10; offset++){
            int tempValue = l.get(i), tempChain = 0;
            
            while(tempValue > 0){
                int currentTerm = l.get(tempChain + offset);
                tempChain++;
                tempValue -= currentTerm;
                if(tempValue == 0){
                    if(tempChain > chain){
                        chain = tempChain;
                        x = l.get(i);
                        System.out.println(l.get(i) + ", chain length " + chain);
                    }
                }
            }
            }
        }
        
//        System.out.println(l.get(l.size() - 1));
    }

    private static boolean isPrime(int i) {
        for(int j = 2; j <= Math.sqrt(i); j++){
            if(i % j == 0) return false;
        }
        
        return true;
    }
    
    private static List getPrimes(int x){
        List<Integer> l = new ArrayList<Integer>();
        
        
        l.add(2);
        
        for(int i = 3; i < x; i += 2){
            if(isPrime(i)){ l.add(i);
            System.out.println(i);
            }
        }
        
        return l;
    }
    
}
