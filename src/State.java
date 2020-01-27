/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

        for(int i =0; i < this.rods.length; i++){
            output +="[";
            for(int j = 0; j < this.rods[i].length; j++){
                output += this.rods[i][j];
            }
            output +="]";
        }

        return output;
    }

    public boolean equals(Object o){
        System.out.println("ad");
        return super.equals(o);
    }
}
