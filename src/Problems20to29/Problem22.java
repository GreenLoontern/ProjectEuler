/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems20to29;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Problem22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //get the names from the file into an arrayList
        File f = new File("src/Problems20to29/names.txt");
        Scanner s = new Scanner(f);
        s.useDelimiter("\"");
        List<String> tempNames = new ArrayList<String>();
        while(s.hasNext()){
            String str = s.next();
            if(!str.equals(",")){
                tempNames.add(str);
            }
        }
        
//        System.out.println(tempNames.size() + tempNames.toString());

        //convert the arrayList into an array
        String[] names = new String[tempNames.size()];
        for(int i = 0; i < names.length; i++){
            names[i] = tempNames.get(i);
        }
        
//        System.out.println(names.length + Arrays.toString(names));

        //sort the array by alphabetical order
        NameMergeSort nms = new NameMergeSort(names);
        String[] sorted = nms.sortNames();
        System.out.println(Arrays.toString(sorted) + "\n");
        
        //create the BigInteger to store the value of the name scores
        BigInteger nameScoreSum = BigInteger.ZERO;
        for(int i = 0; i < sorted.length; i++){
            int place = i + 1;
            String current = sorted[i];
            int nameSum = 0;
            for(int j = 0; j < current.length(); j++){
                nameSum += ((int)(current.charAt(j)) - 64);
            }
            
            int nameScore = place * nameSum;
            
            System.out.print(nameScore + " ");
            
            nameScoreSum = nameScoreSum.add(BigInteger.valueOf(nameScore));
        }
        
        //print out the total of the name scores
        System.out.println("\n" + "The sum of the name scores is: " + nameScoreSum.toString());
    }
    
}
