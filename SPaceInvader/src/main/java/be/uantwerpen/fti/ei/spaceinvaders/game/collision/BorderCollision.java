package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;

import java.util.ArrayList;
import java.util.List;

/**
 * Een klasse om rand collisions te detecteren tussen een positie (met dimensies) en de initiële gameDimension
 * Deze dimension wordt verkregen van de gfxFactory.
 *
 * @param gameDimensions De spel dimensies.
 */
public record BorderCollision(IDimension gameDimensions) {
    /**
     * Kijken of dat er een collision is met een rand van het spel.
     *
     * @param dc positie en dimensie van de entiteit
     * @return List<Boolean> met formaat [TOPCOLLISION, LEFTCOLLISION, BOTTOMCOLLISION, RIGHTCOLLISION]
     */
    public List<Boolean> checkBorderCollision(DimensionComponent dc) {
        List<Boolean> temp = new ArrayList<>();

        //Als links boven hoek tegen de bovenkant komt
        if (dc.getY() < 0)
            temp.add(true);
        else
            temp.add(false);

        //Als links boven hoek tegen de linkse kant komt
        if (dc.getX() < 0)
            temp.add(true);
        else
            temp.add(false);

        //Als recht onder hoek tegen de onderkant komt
        //Hierbij moeten de dimensies bij
        if (dc.getY() + dc.getHeight() > this.gameDimensions.getHeight())
            temp.add(true);
        else
            temp.add(false);

        //Als recht onder hoek tegen de rechterkant komt
        //Hierbij moeten de dimensies bij
        if (dc.getX() + dc.getWidth() > this.gameDimensions.getWidth())
            temp.add(true);
        else
            temp.add(false);

        return temp;
    }

    /**
     * De gamedimensies die opgeslagen zijn.
     *
     * @return
     */
    @Override
    public IDimension gameDimensions() {
        return gameDimensions;
    }
}
