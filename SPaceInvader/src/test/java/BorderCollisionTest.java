import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class BorderCollisionTest {

    @Test
    void testNoBorderCollision(){
        //create parameters for rect
        IPosition position = new Position(10,20);
        IDimension dimension = new Dimension(20,20);
        //create params for borders
        int width = 300;
        int height = 400;

        Boolean[] collisions;
        BorderCollision borderCollision = new BorderCollision(new Dimension(width, height));

        collisions = borderCollision.checkBorderCollision(new DimensionComponent(position, dimension));

        assertEquals(false, collisions[0]);
        assertEquals(false, collisions[1]);
        assertEquals(false, collisions[2]);
        assertEquals(false, collisions[3]);

    }

    @Test
    void testLeftBorderCollision(){
        //create parameters for rect
        IPosition position = new Position(0,20);
        IDimension dimension = new Dimension(20,20);
        //create params for borders
        int width = 300;
        int height = 400;

        Boolean[] collisions;
        BorderCollision borderCollision = new BorderCollision(new Dimension(width, height));

        collisions = borderCollision.checkBorderCollision(new DimensionComponent(position, dimension));

        assertEquals(false, collisions[0]);
        assertEquals(true, collisions[1]);
        assertEquals(false, collisions[2]);
        assertEquals(false, collisions[3]);

    }

    @Test
    void testBottomBorderCollision(){
        //create parameters for rect
        IPosition position = new Position(10,380);
        IDimension dimension = new Dimension(20,20);
        //create params for borders
        int width = 300;
        int height = 400;

        Boolean[] collisions;
        BorderCollision borderCollision = new BorderCollision(new Dimension(width, height));

        collisions = borderCollision.checkBorderCollision(new DimensionComponent(position, dimension));

        assertEquals(false, collisions[0]);
        assertEquals(false, collisions[1]);
        assertEquals(true, collisions[2]);
        assertEquals(false, collisions[3]);
    }

    @Test
    void testRightBorderCollision(){
        //create parameters for rect
        IPosition position = new Position(280,10);
        IDimension dimension = new Dimension(20,20);
        //create params for borders
        int width = 300;
        int height = 400;

        Boolean[] collisions;
        BorderCollision borderCollision = new BorderCollision(new Dimension(width, height));

        collisions = borderCollision.checkBorderCollision(new DimensionComponent(position, dimension));

        assertEquals(false, collisions[0]);
        assertEquals(false, collisions[1]);
        assertEquals(false, collisions[2]);
        assertEquals(true, collisions[3]);

    }

    @Test
    void testTopBorderCollision(){
        //create parameters for rect
        IPosition position = new Position(10,0);
        IDimension dimension = new Dimension(20,20);
        //create params for borders
        int width = 300;
        int height = 400;

        Boolean[] collisions;
        BorderCollision borderCollision = new BorderCollision(new Dimension(width, height));

        collisions = borderCollision.checkBorderCollision(new DimensionComponent(position, dimension));

        assertEquals(true, collisions[0]);
        assertEquals(false, collisions[1]);
        assertEquals(false, collisions[2]);
        assertEquals(false, collisions[3]);
    }
}