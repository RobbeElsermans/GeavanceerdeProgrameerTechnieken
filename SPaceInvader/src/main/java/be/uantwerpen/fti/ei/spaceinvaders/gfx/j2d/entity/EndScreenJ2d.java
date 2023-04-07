package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AScreenEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ATextEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;

import java.util.List;

public class EndScreenJ2d extends AScreenEntity {
    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public EndScreenJ2d() {
        super();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param positionComponent De positie en dimensie van de entiteit.
     */
    public EndScreenJ2d(PositionComponent positionComponent) {
        super(positionComponent);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param positionComponent De positie en dimensie van de entiteit.
     * @param textEntityList    De tekst lijsten die de informatie bevatten.
     */
    public EndScreenJ2d(PositionComponent positionComponent, List<ATextEntity> textEntityList) {
        super(positionComponent, textEntityList);
    }

    @Override
    public void visualize() {
        this.getTextEntityList().forEach(ATextEntity::visualize);   //Visualiseer tekst
    }
}
