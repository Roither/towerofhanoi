/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 *
 * @author erich
 */
public class State implements Cloneable {
    public int[][] rods;
    
    public State(int[][] rods) {        
        this.rods = new int[rods.length][rods[0].length];
        for(int i =0; i < rods.length; i++){
            for(int j = 0; j < rods[i].length; j++){
                this.rods[i][j] = rods[i][j];
            }
        }
    }

    public State clone(){
        return new State(this.rods);
    }

    public String toString(){
            String output = "";


            for(int rod_h = this.rods[0].length-1 ;rod_h>=0;rod_h--) {
               for (int i = 0; i < this.rods.length; i++) {
                   String count;
                   switch (this.rods[i][rod_h]) {
                       case 1:
                           count = "_";
                           break;
                       case 2:
                           count = "___";
                           break;
                       case 3:
                           count = "_____";
                           break;
                       default:
                           count = "";
                   }
                    output += this.centerString(5,count);
               }
               output += "%n";
            }
/*        System.out.println(this.centerString(5,"_"));
        System.out.println(this.centerString(5,"___"));
        System.out.println(this.centerString(5,"_____"));
*/

            return output;

    }

    public boolean equals(Object o){
        System.out.println("ad");
        return super.equals(o);
    }

    private String centerString (int width, String s) {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }
}
