import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {

    @Test
    public void testFileExist(){
        //Plaats in het bestand een waarde van 900;
        int setting = FileManager.getSetting("width_game", "src/test/java/configfiletest/gfx_config.txt", 500);
        assertEquals(setting, 900);
    }

    @Test
    public void testFileNotExist(){
        //genereer random naam zodat deze niet bestaat
        String name = String.valueOf(Math.round(Math.random() * (100 - 0 + 1)+0));
        int setting = FileManager.getSetting("width_game", "src/test/java/configfiletest/" + name +".txt", 500);
        assertEquals(setting, 500);
    }

    @Test
    public void testWrongFormat(){
        int setting = FileManager.getSetting("width_game", "src/test/java/configfiletest/configWrongFormat.txt", 500);
        assertEquals(setting, 500);
    }

}
