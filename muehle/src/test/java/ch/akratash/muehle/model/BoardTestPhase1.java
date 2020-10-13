package ch.akratash.muehle.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class BoardTestPhase1 
{

    @Test
    public void makeMovePhase1LegalExpectTrue()
    {
        Board b = new Board();
        boolean result = b.makeMovePhase1(2, 0, 0);

        assertTrue(result);

    }

    @Test
    public void makeMovePhase1Illegal1ExpectTrue()
    {
        Board b = new Board();
        boolean result = b.makeMovePhase1(0, 3, -1);

        assertFalse(result);
    }

    @Test
    public void makeMovePhase1Illegal2ExpectTrue()
    {
        Board b = new Board();
        boolean result = b.makeMovePhase1(3, 0, 0);

        assertFalse(result);
    }

    @Test
    public void makeMovePhase1Illegal3ExpectTrue()
    {
        Board b = new Board();
        boolean result = b.makeMovePhase1(1, -1, 1);

        assertFalse(result);
    }

    @Test
    public void makeMovePhase1Illegal4ExpectTrue()
    {
        Board b = new Board();
        boolean result = b.makeMovePhase1(0, 3, 0);

        assertFalse(result);
    }

    @Test
    public void makeMovePhase1Illegal5ExpectTrue()
    {
        Board b = new Board();
        boolean result = b.makeMovePhase1(0, 1, 1);

        assertFalse(result);
    }

    @Test
    public void makeMovePhase1Illegal6ExpectTrue()
    {
        Board b = new Board();
        boolean result = b.makeMovePhase1(1, 1, 1);

        assertFalse(result);
    }

    @Test
    public void makeMovePhase1IllegalDoubleSetIndexExpectTrue()
    {
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);

        assertFalse(b.makeMovePhase1(0, 0, 0));
    }


    @Test
    public void switchPlayerWorksExpectTrue()
    {
        Board b = new Board();
        b.makeMove(0, 0, 0);

        assertEquals(Player.BLACK, b.getActivePlayer());
    }

    @Test
    public void checkPlayerNoneExpectTrue()
    {
        Board b = new Board();

        assertEquals(Player.NONE, b.getPlayer(0, 0, 0));
    }

    @Test
    public void checkPlayerNoneExpectTrue1()
    {
        Board b = new Board();

        assertEquals(Player.NONE, b.getPlayer(0, 0, 2));
    }


    @Test
    public void makeMovePhase2Legal1ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(0, 0, 2);

        // test it
        boolean result = b.makeMovePhase2(0, 0, 0, 0, 0, 1);
        
        // check it
        assertTrue(result);
    }

    @Test
    public void makeMovePhase2Legal2ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 1, 0);
        b.makeMovePhase1(0, 0, 2);

        // test it
        boolean result = b.makeMovePhase2(0, 1, 0, 1, 1, 0);
        
        // check it
        assertTrue(result);
    }

    @Test
    public void makeMovePhase2Illegal1ExpectFalse(){
        //prepare Test
        Board b = new Board();
        b.makeMovePhase1(0, 2, 0);
        b.makeMovePhase1(0, 2, 1);
        b.makeMovePhase1(0, 2, 2);

        // test it
        boolean result = b.makeMovePhase2(0, 2, 0, 0, 2, 1);

        //check it
        assertFalse(result);
    }


    @Test
    public void makeMovePhase2Illegal2ExpectFalse(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(0, 0, 2);

        // test it
        boolean result = b.makeMovePhase2(0, 0, 0, 1, 0, 0);
        
        // check it
        assertFalse(result);
    }

    @Test
    public void makeMovePhase2Illegal3ExpectFalse(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(0, 0, 2);

        // test it
        boolean result = b.makeMovePhase2(0, 0, 0, 0, 2, 2);
        
        // check it
        assertFalse(result);
    }

    @Test
    public void makeMovePhase2Illegal4ExpectFalse(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(0, 0, 2);
        b.makeMove(0, 1, 0);// Wichtig --> sonst falscher activePlayer

        // test it
        boolean result = b.makeMovePhase2(0, 0, 2, 0, 2, 0);
        
        // check it
        assertFalse(result);
    }


    @Test
    public void makeMovePhase2Illegal5ExpectFalse(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(0, 0, 2);
        b.makeMove(0, 1, 0);// Wichtig --> sonst falscher activePlayer

        // test it
        boolean result = b.makeMovePhase2(0, 0, 2, 0, 2, 2);
        
        // check it
        assertFalse(result);
    }

   @Test
    public void testDimMillVertical1ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 1, 0);
        b.makeMovePhase1(0, 2, 0);
        b.makeMovePhase1(1, 1, 0);
        b.makeMovePhase1(0, 2, 1);
        b.makeMovePhase1(2, 1, 0);

        // test it
        boolean result = b.isActiveMill();
        
        // check it
        assertTrue(result);
    }

    @Test
    public void testDimMillVertical2ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(2, 1, 2);
        b.makeMovePhase1(0, 2, 0);
        b.makeMovePhase1(1, 1, 2);
        b.makeMovePhase1(0, 2, 1);
        b.makeMovePhase1(0, 1, 2);

        // test it
        boolean result = b.isActiveMill();
        
        // check it
        assertTrue(result);
    }

    @Test
    public void testDimMillHorizontal1ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(1, 2, 0);
        b.makeMovePhase1(0, 1, 0);
        b.makeMovePhase1(0, 2, 1);
        b.makeMovePhase1(0, 2, 0);

        // test it
        boolean result = b.isActiveMill();
        
        // check it
        assertTrue(result);
    }

    @Test
    public void testDimMillHorizontal2ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(1, 0, 1);
        b.makeMovePhase1(0, 1, 0);
        b.makeMovePhase1(2, 0, 1);
        b.makeMovePhase1(0, 2, 2);
        b.makeMovePhase1(0, 0, 1);

        // test it
        boolean result = b.isActiveMill();
        
        // check it
        assertTrue(result);
    }

    @Test
    public void testRowMillVertical1ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(1, 0, 2);
        b.makeMovePhase1(0, 0, 1);
        b.makeMovePhase1(2, 0, 1);
        b.makeMovePhase1(0, 0, 2);

        // test it
        boolean result = b.isActiveMill();
        
        // check it
        assertTrue(result);
    }

    @Test
    public void testRowMillVertical2ExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(0, 2, 0);
        b.makeMovePhase1(0, 0, 1);
        b.makeMovePhase1(0, 2, 1);
        b.makeMovePhase1(1, 0, 2);
        b.makeMovePhase1(0, 2, 2);

        // test it
        boolean result = b.isActiveMill();
        
        // check it
        assertTrue(result);
    }

    @Test
    public void testRowMillVertical1ExpectFalse(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(0, 1, 0);
        b.makeMovePhase1(0, 2, 0);

        // test it
        boolean result = b.isActiveMill();
        
        // check it
        assertFalse(result);
    }

    @Test
    public void takeStoneExpectTrue(){
        // prepare test
        Board b = new Board();
        b.makeMovePhase1(0, 0, 0);
        b.makeMovePhase1(0, 2, 0);
        b.makeMovePhase1(0, 0, 1);
        b.makeMovePhase1(0, 2, 1);
        b.makeMovePhase1(1, 0, 2);
        b.makeMovePhase1(0, 2, 2);

        // test it
        //b.takeStone(0, 0, 0);
        
        // check it
        assertEquals(b.getPlayer(0, 0, 0), Player.NONE);
    }
}
