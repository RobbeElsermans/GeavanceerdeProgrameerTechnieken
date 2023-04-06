package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.InformationComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

/**
 * Een abstracte entiteit dat een tekst kan bevatten. Deze entiteit kan gebruikt worden om zaken te tonen op het scherm.
 */
public abstract class ATextEntity implements IVisualize {
    /**
     * De entiteit bevat een statische positie.
     */
    private final PositionComponent positionComponent;
    /**
     * De entiteit bevat een informatie.
     */
    private final InformationComponent informationComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public ATextEntity() {
        this.positionComponent = new PositionComponent();
        this.informationComponent = new InformationComponent();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param positionComponent De positie en dimensie van de entiteit.
     * @param preText         De tekst die voor de informatie moet komen te staan.
     */
    public ATextEntity(PositionComponent positionComponent, String preText) {
        this.positionComponent = positionComponent;
        this.informationComponent = new InformationComponent(preText);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param positionComponent De positie en dimensie van de entiteit.
     * @param preText           De tekst die voor de informatie moet komen te staan.
     * @param text              De informatie text die na het pretext komt te staan.
     */
    public ATextEntity(PositionComponent positionComponent, String preText, String text) {
        this.positionComponent = positionComponent;
        this.informationComponent = new InformationComponent(preText, text);
    }
    public PositionComponent getPositionComponent() {
        return positionComponent;
    }
    public InformationComponent getInformationComponent() {
        return informationComponent;
    }
}
