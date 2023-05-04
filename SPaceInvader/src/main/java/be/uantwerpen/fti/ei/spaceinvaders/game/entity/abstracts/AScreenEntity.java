package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

import java.util.List;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een screen entity kan gebruikt worden om menu's te maken.
 * <p>
 * Een AScreenEntity bestaat uit een titel en 1 of meerdere ATextEntity's die zowel text en/of informatie kunnen afbeelden.
 * <p>
 * Wanneer men deze entity wilt implementeren, moet men de visualize methode overerven van IVisualize.
 * Deze methode wordt gebruikt om de entiteit af te beelden.
 * @see IVisualize
 * @see ATextEntity
 */
public abstract class AScreenEntity implements IVisualize {
    /**
     * De entiteit bevat een statische positie.
     */
    private final PositionComponent positionComponent;

    /**
     * De entiteit bevat informatie teksten
     */
    private final List<ATextEntity> textEntityList;

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param positionComponent De positie en dimensie van de entiteit.
     * @param textEntityList    De tekst lijsten die de informatie bevatten.
     */
    public AScreenEntity(PositionComponent positionComponent, List<ATextEntity> textEntityList) {
        this.positionComponent = positionComponent;
        this.textEntityList = textEntityList;
    }

    /**
     * @return De textEntityList van het scherm entiteit.
     */
    public List<ATextEntity> getTextEntityList() {
        return textEntityList;
    }
}
