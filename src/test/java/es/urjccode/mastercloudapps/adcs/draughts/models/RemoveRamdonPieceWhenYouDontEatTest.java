package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RemoveRamdonPieceWhenYouDontEatTest extends GameTest{
    private void assertMove(Coordinate... coordinates){
        assertNull(this.game.move(coordinates));
        assertEquals(this.game, this.expectedGame);
    }
    @Test
    public void testRemoveWhenMoveAndNotEatWhenPossibleInWhite() {
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            "     n  ",
            "      b ",
            "        ",
            "        ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "        ",
            "     n  ",
            "        ",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(5, 6),
            new Coordinate(4, 7)
        );
    }
    @Test
    public void testRemoveWhenDoOneMoveAndCanEat(){
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "   n    ",
            "        ",
            " n      ",
            "b       ",
            "        ",
            "        ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "   n    ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(5, 0),
            new Coordinate(3, 2)
        );
    }

    @Test
    public void testRemoveWhenDoManyMovesAndCanEat(){
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "     n  ",
            "        ",
            "   n    ",
            "        ",
            " n      ",
            "b       ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "     n  ",
            "        ",
            "        ",
            "        ",
            "        ",
            "        ");
        this.assertMove(
            new Coordinate(7, 0),
            new Coordinate(5, 2),
            new Coordinate(3,4)
        );
    }
    @Test
    public void testRemoveWhenDoOneMoveAndDontEat(){
        this.setGame(Color.WHITE,
            "        ",
            "        ",
            "        ",
            "        ",
            " n      ",
            "  b     ",
            "        ",
            "   b    ");
        this.setExpectedGame(Color.BLACK,
            "        ",
            "        ",
            "        ",
            "        ",
            " n      ",
            "        ",
            "    b   ",
            "        ");
        this.assertMove(
            new Coordinate(7, 3),
            new Coordinate(6, 4)
        );
    }
}
