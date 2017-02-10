package Problems60to69;


import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Problem67 {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        //input the triangle
        File triangle = new File("triangle.txt");
        Scanner s = new Scanner(triangle);
        
        //find the height of the triangle
        int x = 100;
        
        //create a value to hold the biggest line.
        long biggest = 0;
        
        int[][] values = new int[x][];
        int[][] highest = new int[x][];
        
        //read in the triangle values
        int currentRow = 0;
        while(s.hasNextLine()){
            
//            System.out.println("Setting up line " + currentRow);
            String triangleRow = s.nextLine();
//            System.out.println(triangleRow);
            String[] nums;
            if(triangleRow.length() > 2) {
                nums = triangleRow.split(" ");
            }
            else{
                nums = new String[]{triangleRow};
            }
            
//            System.out.println(nums[0]);
            values[currentRow] = new int[nums.length];
            highest[currentRow] = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                try{
                    values[currentRow][i] = Integer.parseInt(nums[i]);
                }catch(NumberFormatException e){ System.out.println("Couldn't read the numbers in.");}
            }
            currentRow++;
        }
        
        highest[0][0] = values[0][0];
        int row = 1;
             
        while(row < x){
            for(int i = 0; i < highest[row].length; i++){
                highest[row][i] += values[row][i];
                if(i == 0) highest[row][i] += highest[row-1][i];
                else if(i == highest[row].length -1) highest[row][i] += highest[row - 1][i - 1];
                else{
                    if(highest[row - 1][i] > highest[row - 1][i - 1]) highest[row][i] += highest[row - 1][i];
                    else highest[row][i] += highest[row - 1][i - 1];
                }
//                System.out.println(highest[row][i]);
                
            }
            
            row++;
        }
        
        for(int i = 0; i < highest[x - 1].length; i++){
            if(biggest < (long) highest[x - 1][i]){
                biggest = highest[x - 1][i];
//                System.out.println(biggest);
            }
        }
        
        //print out the best path
        System.out.println("The greatest sum is " + biggest);
        
        
    }
    
}
