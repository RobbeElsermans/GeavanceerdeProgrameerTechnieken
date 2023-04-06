package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

import java.util.ArrayList;
import java.util.List;

public abstract class AScreenEntity implements IVisualize {
    /**
     * De entiteit bevat een statische positie.
     */
    private final PositionComponent positionComponent;

    /**
     * De entiteit bevat informatie teksten
     */
    private List<ATextEntity> textEntityList;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public AScreenEntity() {
        this.positionComponent = new PositionComponent();
        this.textEntityList = new ArrayList<>();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param positionComponent De positie en dimensie van de entiteit.
     */
    public AScreenEntity(PositionComponent positionComponent) {
        this.positionComponent = positionComponent;
        this.textEntityList = new ArrayList<>();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param positionComponent De positie en dimensie van de entiteit.
     * @param textEntityList  De tekst lijsten die de informatie bevatten.
     */
    public AScreenEntity(PositionComponent positionComponent, List<ATextEntity> textEntityList) {
        this.positionComponent = positionComponent;
        this.textEntityList = textEntityList;
    }

    public PositionComponent getStaticComponent() {
        return positionComponent;
    }

    public List<ATextEntity> getTextEntityList() {
        return textEntityList;
    }

    public void addTextEntity(ATextEntity textEntity) {
        this.textEntityList.add(textEntity);
    }
}
