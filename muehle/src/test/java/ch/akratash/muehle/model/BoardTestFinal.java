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
        b.takeStone(0, 0, 0);
        
        // check it
        assertEquals(b.getPlayer(0, 0, 0), Player.NONE);
    }

    @Test
    public void makeMoveLegal1ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMove(0, 0, 0);
        b.makeMove(0, 1, 0);

        b.makeMove(0, 2, 0);
        b.makeMove(1, 0, 0);

        b.makeMove(1, 1, 0);
        b.makeMove(1, 2, 0);

        b.makeMove(2, 0, 0);
        b.makeMove(2, 1, 0);

        b.makeMove(2, 2, 0);
        b.makeMove(0, 0, 1);
        
        b.makeMove(1, 0, 1);
        b.makeMove(2, 0, 1);

        b.makeMove(0, 0, 2);
        b.makeMove(0, 1, 2);

        b.makeMove(0, 2, 2);
        b.makeMove(1, 0, 2);
        
        b.makeMove(1, 1, 2);
        b.makeMove(1, 2, 2);


        // test it
        b.makeMovePhase2(0, 2, 0, 0, 2, 1);
        
        // check it
        assertEquals(b.getPlayer(0, 2, 1), Player.WHITE);
    }

    @Test
    public void isMillPhase2ExpectFalse(){
        // prepare test
        Board b = new Board();
        b.makeMove(0, 0, 0);
        b.makeMove(0, 1, 0);

        b.makeMove(0, 2, 0);
        b.makeMove(1, 0, 0);

        b.makeMove(1, 1, 0);
        b.makeMove(1, 2, 0);

        b.makeMove(2, 0, 0);
        b.makeMove(2, 1, 0);

        b.makeMove(2, 2, 0);
        b.makeMove(0, 0, 1);
        
        b.makeMove(1, 0, 1);
        b.makeMove(2, 0, 1);

        b.makeMove(0, 0, 2);
        b.makeMove(0, 1, 2);

        b.makeMove(0, 2, 2);
        b.makeMove(1, 0, 2);
        
        b.makeMove(1, 1, 2);
        b.makeMove(1, 2, 2);


        // test it
        
        // check it
        assertFalse(b.isActiveMill());
    }

    @Test
    public void isMillPHASE2ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMove(0, 0, 0);
        b.makeMove(2, 0, 0);

        b.makeMove(1, 2, 1);
        b.makeMove(1, 0, 0);

        b.makeMove(0, 2, 0);
        b.makeMove(1, 2, 0);

        b.makeMove(0, 1, 2);
        b.makeMove(2, 1, 0);

        b.makeMove(2, 2, 0);
        b.makeMove(0, 0, 1);
        
        b.makeMove(1, 0, 1);
        b.makeMove(2, 0, 1);

        b.makeMove(1, 0, 2);
        b.makeMove(2, 2, 2);

        b.makeMove(0, 2, 2);
        b.makeMove(0, 0, 2);
        
        b.makeMove(1, 1, 2);
        b.makeMove(1, 2, 2);

        //Phase2
        b.makeMovePhase2(1, 2, 1, 0, 2, 1);


        // test it
        
        // check it
        assertTrue(b.isActiveMill());
    }

    @Test
    public void takeStoneLegal1ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMove(0, 0, 0);
        b.makeMove(1, 1, 0);

        b.makeMove(0, 1, 0);
        b.makeMove(1, 0, 0);

        b.makeMove(0, 2, 0);


        // test it
        b.takeStone(1, 1, 0);    
        // check it
        assertEquals(b.getPlayer(1, 1, 0),Player.NONE);
    }

    @Test
    public void isMill1ExpectFalse(){
        // prepare
        Board b = new Board();
        b.makeMove(0, 0, 0);
        b.makeMove(0, 1, 0);
        b.makeMove(0, 2, 0);

        //test
        b.isActiveMill();
        //check
        assertFalse(b.isActiveMill());

    }

    @Test
    public void isMill1ExpectTrue(){
        // prepare
        Board b = new Board();
        b.makeMove(0, 0, 0);
        b.makeMove(1, 1, 0);

        b.makeMove(0, 1, 0);
        b.makeMove(1, 0, 0);

        b.makeMove(0, 2, 0);
        

        //test
        b.isActiveMill();
        //check
        assertTrue(b.isActiveMill());

    }

    @Test
    public void isMillAtStartExpectFalse(){
        // prepare
        Board b = new Board();
        

        //test
        b.isActiveMill();
        //check
        assertFalse(b.isActiveMill());

    }

}