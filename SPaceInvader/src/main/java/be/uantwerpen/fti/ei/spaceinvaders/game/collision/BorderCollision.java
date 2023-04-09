package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een klasse om rand collisions te detecteren tussen een positie met een dimensie.
 * <p>
 * De game dimensie wordt verkregen van het graphics-systeem. Hierdoor kan men de collision detecteren op graphics niveau.
 *
 * @param gameDimensions Het graphics-systeem dimensies.
 */
public record BorderCollision(IDimension gameDimensions) {
    /**
     * Kijken of dat er een collision is met een rand van het spel.
     * <p>
     * We bekijken een DimensionComponent of dat deze buiten het graphics-systeem dimensies valt of niet.
     * Aan de hand van welke kant de entiteit ergens te ver gaat, wordt een lijst terug gegeven met 4 booleans.
     * Hierdoor kan een entiteit tegen meerdere randen tegelijkertijd komen.
     * <p>
     * De lijst ziet er uit als volgt:
     * <ul>
     *     <li>0 - TOP_COLLISION</li>
     *     <li>1 - LEFT_COLLISION</li>
     *     <li>2 - BOTTOM_COLLISION</li>
     *     <li>3 - RIGHT_COLLISION</li>
     * </ul>
     * Wanneer een parameter true is, is er een botsing. False wanneer er geen botsing is.
     * Om makkelijk met deze functie te werken, kan gebruikt gemaakt worden van de Enum BorderCollisionType.
     * <p>
     * We kijken 1 value verder dan de rand. Dit omdat anders als een speler gewoon tegen de rand komt,
     * de velocity telkens op 0 wordt gezet. Hierdoor zou de speler niet meer kunnen bewegen.
     *
     * @param dc positie en dimensie van de entiteit
     * @return List<Boolean> met formaat [TOPCOLLISION, LEFTCOLLISION, BOTTOMCOLLISION, RIGHTCOLLISION]
     *
     * @see Edge
     */
    public Boolean[] checkBorderCollision(DimensionComponent dc) {
        Boolean[] temp = new Boolean[Edge.values().length];

        //Als links boven hoek tegen de bovenkant komt, geef dan true. Anders false.
        temp[Edge.TOP.getValue()]= dc.getY() < 0;

        //Als links boven hoek tegen de linkse kant komt, geef dan true. Anders false.
        temp[Edge.LEFT.getValue()]= dc.getX() < 0;

        //Als recht onder hoek tegen de onderkant komt, geef dan true. Anders false.
        //Hierbij moeten de dimensies bij
        temp[Edge.BOTTOM.getValue()]= dc.getY() + dc.getHeight() > this.gameDimensions.getHeight();

        //Als recht onder hoek tegen de rechterkant komt, geef dan true. Anders false.
        //Hierbij moeten de dimensies bij
        temp[Edge.RIGHT.getValue()]= dc.getX() + dc.getWidth() > this.gameDimensions.getWidth();

        return temp;
    }

    /**
     * De gameDimensies die opgeslagen is.
     *
     * @return IDimension die de graphics-systeem dimensies voorstelt in width en height.
     */
    @Override
    public IDimension gameDimensions() {
        return gameDimensions;
    }
}
