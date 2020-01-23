/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erich
 */
public class State {
    public int[][] rods;
    
    public State(int[][] rods) {        
        this.rods = new int[rods.length][rods[0].length];
        for(int i =0; i < rods.length; i++){
            for(int j = 0; j < rods[i].length; j++){
                this.rods[i][j] = rods[i][j];
            }
        }
    }
    
}
