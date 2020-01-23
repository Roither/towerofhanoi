/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aima.core.agent.Action;

/**
 *
 * @author erich
 */
public class Move implements Action{
    public int disk;
    public int rod;
    
    public Move(int disk, int rod){
        this.disk = disk;
        this.rod = rod;
    }
    
    @Override
    public boolean isNoOp(){
        return false;
    }
}
