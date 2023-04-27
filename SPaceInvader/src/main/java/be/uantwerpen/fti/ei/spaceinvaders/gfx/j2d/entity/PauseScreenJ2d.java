package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AScreenEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ATextEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;

import java.util.List;

public class PauseScreenJ2d extends AScreenEntity {
    private GraphicsContext gfx;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public PauseScreenJ2d() {
        super();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param positionComponent De positie en dimensie van de entiteit.
     */
    public PauseScreenJ2d(PositionComponent positionComponent, GraphicsContext gfx) {
        super(positionComponent);
        this.gfx = gfx;
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param positionComponent De positie en dimensie van de entiteit.
     * @param textEntityList    De tekst lijsten die de informatie bevatten.
     */
    public PauseScreenJ2d(PositionComponent positionComponent, List<ATextEntity> textEntityList, GraphicsContext gfx) {
        super(positionComponent, textEntityList);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {
        this.getTextEntityList().forEach(ATextEntity::visualize);   //Visualiseer tekst
    }
}