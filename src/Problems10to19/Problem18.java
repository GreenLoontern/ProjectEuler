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
public class Problem18 {
    
    /*
75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
    */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //declare height of pyramid
        int x = 15;
        
        //make array to store values of pyramid
        int[][] values = new int[x][];
        
        long sum = 75;
        
        //store the pyramid
        values[0] = new int[]  {75};
        values[1] = new int[]  {95, 64};
        values[2] = new int[]  {17, 47, 82};
        values[3] = new int[]  {18, 35, 87,10};
        values[4] = new int[]  {20, 04, 82, 47, 65};
        values[5] = new int[]  {19, 01, 23, 75, 03, 34};
        values[6] = new int[]  {88, 02, 77, 73, 07, 63, 67};
        values[7] = new int[]  {99, 65, 04, 28, 06, 16, 70, 92};
        values[8] = new int[]  {41, 41, 26, 56, 83, 40, 80, 70, 33};
        values[9] = new int[]  {41, 48, 72, 33, 47, 32, 37, 16, 94, 29};
        values[10] = new int[] {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14};
        values[11] = new int[] {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57};
        values[12] = new int[] {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48};
        values[13] = new int[] {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31};
        values[14] = new int[] {04, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60, 04, 23};
        
        //create an array containing the best path upwards from there
        int[][] highest = new int[x][];
        
        highest[0] = new int[1];
        highest[0][0] = values[0][0];
        highest[1] = new int[2];
        highest[2] = new int[3];
        highest[3] = new int[4];
        highest[4] = new int[5];
        highest[5] = new int[6];
        highest[6] = new int[7];
        highest[7] = new int[8];
        highest[8] = new int[9];
        highest[9] = new int[10];
        highest[10] = new int[11];
        highest[11] = new int[12];
        highest[12] = new int[13];
        highest[13] = new int[14];
        highest[14] = new int[15];
        
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
                
            }
            
            row++;
        }
        
        for(int i = 0; i < highest[x - 1].length; i++){
            if(highest[x - 1][i] > sum) sum = highest[x - 1][i];
        }
        
        
        
        System.out.println(sum);
        
        
    }
    
}
