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
    public int srcRod;
    public int dstRod;
    
    public Move(int srcRod, int dstRod){
        this.srcRod = srcRod;
        this.dstRod = dstRod;
    }
    
    @Override
    public boolean isNoOp(){
        return srcRod == dstRod;
    }
}
