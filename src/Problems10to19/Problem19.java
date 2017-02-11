/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Problems10to19;

/**
 *
 * @author gabriel
 */
public class Problem19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] months = {31, 28 ,31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapMonths = {31, 29 ,31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 2; //when it gets to 7 reset to 0;
                
        int startYear = 1901, endYear = 2001; 
        boolean firstOfMonth = false;
        
        int count = 0;
        
        //go for every year in the range.
        for(int i = startYear; i < endYear; i++){
            
            if(isLeapYear(i)){
                //cycle through months
                for(int j = 0; j < leapMonths.length; j++){
                    firstOfMonth = true;
                    //cycle through days
                    for(int k = 0; k < leapMonths[j]; k++){
                        if(firstOfMonth && day == 0){
                            count++;
                            System.out.println("Found one!");
                        }
                        firstOfMonth = false;
                        day++;
                        day %= 7;
                        System.out.println(day);
                    }
                }
            }
            else{
                //cycle through months
                for(int j = 0; j < months.length; j++){
                    firstOfMonth = true;
                    //cycle through days
                    for(int k = 0; k < months[j]; k++){
                        if(firstOfMonth && day == 0){
                            count++;
                            System.out.println("Found one!");
                        }
                        firstOfMonth = false;
                        day++;
                        day %= 7;
                        System.out.println(day);
                    }
                }
            }
            
        }
        
        System.out.println(count);
    }
    
    public static boolean isLeapYear(int year){
        if(year % 400 == 0) return true;
        else if(year % 4 == 0 && year % 100 != 0) return true;
        else return false;
    }
    
}
