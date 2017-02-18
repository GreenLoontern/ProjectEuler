/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems60to69;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class Problem62 {

    /**
    The cube, 41063625 (3453), can be permuted to produce two other cubes: 56623104 (3843) and 66430125 (4053). In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

    Find the smallest cube for which exactly five permutations of its digits are cube.
     */
    
    public static List<int[]> permutations = new ArrayList<int[]>();
    static int currentCubes = 0;
    static int[] digitArr;
    
    //create the biginteger to store the number that will create the cube.
    static BigInteger num = BigInteger.valueOf(340);
    //create the biginteger to store the cube
    static BigInteger pow;
    
    public static void main(String[] args) {
        // TODO code application logic 
        final int count = 5;
        
        List<Double> cubes = new ArrayList<Double>();
        
        while(currentCubes != count){
            
            //create the array to hold the cubes
            cubes = new ArrayList<Double>();
            
            //reset all of the values (get next number, create next cube, set currentCubes to 0, etc)
            reset();
            
            cubes.add(num.doubleValue());
            
            List<Integer> digits = new ArrayList<Integer>();
            
            //add all of the digits to the list
            while(pow.compareTo(BigInteger.ZERO) == 1){
                BigInteger LastDigit = pow.mod(BigInteger.TEN);
                digits.add(LastDigit.intValue());
                pow = pow.divide(BigInteger.TEN);
            }
            //turn the arrayList into an integer array
            digitArr = new int[digits.size()];
            for(int k = 0; k < digitArr.length; k++){
                digitArr[k] = digits.get(k);
            }
            
            //permute the array
            Problem62 obj = new Problem62();
            obj.heapPermutation(digitArr, digitArr.length, digitArr.length);
            
            currentCubes = 1;        
            //go through the list and check to see how many are cubes
            for(int l = 0; l < permutations.size(); l++){
                int[] temp = permutations.get(l);
//                System.out.println(Arrays.toString(temp));
                long tempNum = 0;
                for(int m = temp.length - 1; m >= 0; m--){
                    tempNum *= 10;
                    tempNum += temp[m];
                }
//                System.out.println(tempNum);
                //check to see if the number is a cube
                double cubed = Math.cbrt(tempNum);
                if(cubed % 1 == 0 && cubes.indexOf(cubed) == -1){
                    
//                    System.out.println(cubed);
                    cubes.add(cubed);
                    currentCubes++;
                }
            }
            
            
        }
        
        System.out.println(num.pow(3) + cubes.toString());
        
    }
    
    public static void reset(){
        currentCubes = 0;
        
        permutations.clear();
        
        num = num.add(BigInteger.ONE);
        
        System.out.println(num.toString());
    
        pow = num.pow(3);
        System.out.println(pow);
    }
    
    void heapPermutation(int a[], int size, int n)
    {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            addArr(a);
 
        for (int i=0; i<size; i++)
        {
            heapPermutation(a, size-1, n);
 
            // if size is odd, swap first and last
            // element
            if (size % 2 == 1)
            {
                int temp = a[0];
                a[0] = a[size-1];
                a[size-1] = temp;
            }
 
            // If size is even, swap ith and last
            // element
            else
            {
                int temp = a[i];
                a[i] = a[size-1];
                a[size-1] = temp;
            }
        }
    
    }

    private void addArr(int[] a) {
        int[] temp = new int[a.length];
        for(int i = 0; i < a.length; i++){
            temp[i] = a[i];
            permutations.add(temp);
        }
    }
    
    
}
