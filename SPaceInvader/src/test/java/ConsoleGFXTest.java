import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.FactoryConsole;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleGFXTest {
    @Test
    void testConsoleClear() {
        AFactory gfxFac = new FactoryConsole();
        gfxFac.setupGameDimentions(new Dimension(5, 5));

        AEnemyEntity enemy = gfxFac.getEnemyEntity();

        while (true) {
            gfxFac.render();
            enemy.visualize();

            try {
                Thread.sleep(1000); //Wachten zodat totale tijd FPS behaald wordt.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
