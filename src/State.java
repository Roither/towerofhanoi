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
        String sign = "_";

        for(int j = this.rods[0].length-1;j>=0; j--) {
            for (int i = 0; i < this.rods.length; i++) {
                if(this.rods[i][j]>0)
                    output += this.centerString(5,sign.repeat(this.rods[i][j]*2-1));
                else
                    output += this.centerString(5,"|");
            }
            output += "%n";
        }

        return String.format(output);
    }

    public boolean equals(Object o){
        return super.equals(o);
    }

    private static String centerString (int width, String s) {
        return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }
}
