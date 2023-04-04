package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Een klasse om rand collisions te detecteren tussen een positie (met dimensies) en de initiële gameDimensions
 */
public class BorderCollision {

    //TODO: misschien static maken om dan te gebruiken in CollisionManager

    /**
     * De spel dimensies.
     */
    private final IDimension gameDimensions;
    public BorderCollision(IDimension gameDimensions){
        this.gameDimensions = gameDimensions;
    }

    /**
     * Kijken of dat er een collision is met een rand van het spel.
     * @param position   positie van de entiteit
     * @param dimension   dimensie van de entiteit (hoe groot deze is).
     * @return List<Boolean>    met formaat [TOPCOLLISION, LEFTCOLLISION, BOTTOMCOLLISION, RIGHTCOLLISION]
     */
    public List<Boolean> checkBorderCollision(IPosition position, IDimension dimension){
        List<Boolean> temp = new ArrayList<>();

        //Als links boven hoek tegen de bovenkant komt
        if(position.getY() < 0)
            temp.add(true);
        else
            temp.add(false);

        //Als links boven hoek tegen de linkse kant komt
        if(position.getX() < 0)
            temp.add(true);
        else
            temp.add(false);

        //Als recht onder hoek tegen de onderkant komt
        //Hierbij moeten de dimensies bij
        if(position.getY() + dimension.getHeight() > this.gameDimensions.getHeight())
            temp.add(true);
        else
            temp.add(false);

        //Als recht onder hoek tegen de rechterkant komt
        //Hierbij moeten de dimensies bij
        if(position.getX() + dimension.getWidth() > this.gameDimensions.getWidth())
            temp.add(true);
        else
            temp.add(false);

        return temp;
    }

    /**
     * De gamedimensies die opgeslagen zijn.
     * @return
     */
    public IDimension getGameDimensions() {
        return gameDimensions;
    }
}
