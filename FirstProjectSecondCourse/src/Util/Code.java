/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author pc
 */
public class Code {
    private static String [] abc = {"A","B","C","D","E","F","G","H","d","e","j","y","n",
        "v","l","i","t","r","s","W","Q","v","z","Z","O","o","p"};
    private static int [] nums = {1,2,3,4,5,6,7,8,9,0};
    
    public static String getCode(){
        String result = "";
        for (int i = 0; i < 6; i++) {
            int randomABC = (int)(Math.random()*26+0);
            result += abc[randomABC];
            int randomNum = (int)(Math.random()*9+0);
            result += nums[randomNum];
        }
        return result;
    }
}
