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
public class Problem9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int c = 997;
        
        while(c > 1){
            for(int a = 1; a < 1000 - c; a++){
                int b = 1000 - c - a;
                
                if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)){
                    System.out.println(a + " " + b + " " + c);
                }
            }
                        
            c--;
        }
    }
    
}
    