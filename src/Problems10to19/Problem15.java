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
public class Problem15 {

    /**
     * @param args the command line arguments
     */
    
    static long[][] arr;
    
    public static void main(String[] args) {
        
        //find the number of unique paths from the top right corner of a grid
        //width w, height h to the bottom left corner.
        int width = 20, height = 20 ;
        
        arr = new long[21][21];
        
        long paths = getPaths(width, height);
        
        System.out.println(paths);
       
    }
    
    public static long getPaths(int w, int h){
        if(arr[w][h] != 0){
                return arr[w][h];
        }
        
        if(w == 1 || h == 1){ 
            arr[w][h] = w + h;
            return arr[w][h];
        }
        else{
        arr[w][h] = getPaths(w - 1, h) + getPaths(w, h - 1);
        return arr[w][h];
        }
    }
    
    
    
    
    
}
