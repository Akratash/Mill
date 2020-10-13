package ch.akratash.muehle.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTestFinal {

    @Test
    public void testDimMillVertical2ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMove(2, 1, 2);
        b.makeMove(0, 2, 0);
        b.makeMove(1, 1, 2);
        b.makeMove(0, 2, 1);
        b.makeMove(0, 1, 2);

        // test it
        boolean result = b.isActiveMill();
        
        // check it
        assertTrue(result);
    }

    @Test
    public void testRowMillVertical1ExpectFalse(){
        // prepare test
        Board b = new Board();
        b.makeMove(0, 0, 0);
        b.makeMove(0, 1, 0);
        b.makeMove(0, 2, 0);

        // test it
        boolean result = b.isActiveMill();
        
        // check it
        assertFalse(result);
    }

    @Test
    public void takeStoneExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMove(0, 0, 0);
        b.makeMove(0, 2, 0);
        b.makeMove(0, 0, 1);
        b.makeMove(0, 2, 1);
        b.makeMove(1, 0, 2);
        b.makeMove(0, 2, 2);

        // test it
        //b.takeStone(0, 0, 0);
        
        // check it
        assertEquals(b.getPlayer(0, 0, 0), Player.NONE);
    }

}