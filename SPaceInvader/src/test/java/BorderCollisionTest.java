import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BorderCollisionTest {

    @Test
    void testNoBorderCollision(){
        //create parameters for rect
        IPosition position = new Position(10,20);
        IDimension dimension = new Dimension(20,20);
        //create params for borders
        int width = 300;
        int height = 400;

        int counter = 0;
        List<Boolean> collisions;


        collisions = BorderCollision.checkBorderCollision(position, dimension, width, height);

        assertEquals(false, collisions.get(0));
        assertEquals(false, collisions.get(1));
        assertEquals(false, collisions.get(2));
        assertEquals(false, collisions.get(3));

    }

    @Test
    void testLeftBorderCollision(){
        //create parameters for rect
        IPosition position = new Position(0,20);
        IDimension dimension = new Dimension(20,20);
        //create params for borders
        int width = 300;
        int height = 400;

        int counter = 0;
        List<Boolean> collisions;


        collisions = BorderCollision.checkBorderCollision(position, dimension, width, height);

        assertEquals(false, collisions.get(0));
        assertEquals(true, collisions.get(1));
        assertEquals(false, collisions.get(2));
        assertEquals(false, collisions.get(3));

    }

    @Test
    void testBottomBorderCollision(){
        //create parameters for rect
        IPosition position = new Position(10,380);
        IDimension dimension = new Dimension(20,20);
        //create params for borders
        int width = 300;
        int height = 400;

        int counter = 0;
        List<Boolean> collisions;

        collisions = BorderCollision.checkBorderCollision(position, dimension, width, height);

        assertEquals(false, collisions.get(0));
        assertEquals(false, collisions.get(1));
        assertEquals(true, collisions.get(2));
        assertEquals(false, collisions.get(3));

    }

    @Test
    void testRightBorderCollision(){
        //create parameters for rect
        IPosition position = new Position(280,10);
        IDimension dimension = new Dimension(20,20);
        //create params for borders
        int width = 300;
        int height = 400;

        int counter = 0;
        List<Boolean> collisions;

        collisions = BorderCollision.checkBorderCollision(position, dimension, width, height);

        assertEquals(false, collisions.get(0));
        assertEquals(false, collisions.get(1));
        assertEquals(false, collisions.get(2));
        assertEquals(true, collisions.get(3));

    }

    @Test
    void testTopBorderCollision(){
        //create parameters for rect
        IPosition position = new Position(10,0);
        IDimension dimension = new Dimension(20,20);
        //create params for borders
        int width = 300;
        int height = 400;

        int counter = 0;
        List<Boolean> collisions;

        collisions = BorderCollision.checkBorderCollision(position, dimension, width, height);

        assertEquals(true, collisions.get(0));
        assertEquals(false, collisions.get(1));
        assertEquals(false, collisions.get(2));
        assertEquals(false, collisions.get(3));
    }
}