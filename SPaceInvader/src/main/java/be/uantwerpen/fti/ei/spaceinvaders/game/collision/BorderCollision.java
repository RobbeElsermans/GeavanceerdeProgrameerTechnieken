package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;

import java.util.ArrayList;
import java.util.List;

public class BorderCollision {
    private IDimension gameDimensions;
    public BorderCollision(IDimension gameDimensions){
        this.gameDimensions = gameDimensions;
    }

    //Check of dat een entity tegen de rand zit.

    /**
     *
     * @param position   positie
     * @param dimension   dimensie
     * @return List<Boolean>    met formaat [TOPCOLLISION, LEFTCOLLISION, BOTTOMCOLLISION, RIGHTCOLLISION]
     */
    public List<Boolean> checkBorderCollision(IPosition position, IDimension dimension){
        List<Boolean> temp = new ArrayList<>();

        //Als links boven hoek tegen de bovenkant komt
        if(position.getY() <= 0)
            temp.add(true);
        else
            temp.add(false);

        //Als links boven hoek tegen de linkse kant komt
        if(position.getX() <= 0)
            temp.add(true);
        else
            temp.add(false);

        //Als recht onder hoek tegen de onderkant komt
        if(position.getY() + dimension.getHeight() >= this.gameDimensions.getHeight())
            temp.add(true);
        else
            temp.add(false);

        //Als recht onder hoek tegen de rechterkant komt
        if(position.getX() + dimension.getWidth() >= this.gameDimensions.getWidth())
            temp.add(true);
        else
            temp.add(false);

        return temp;
    }
}
