package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.InformationComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

/**
 * Een abstracte entiteit dat een tekst kan bevatten. Deze entiteit kan gebruikt worden om zaken te tonen op het scherm.
 * <p>
 * De ATextEntity zorgt voor text visualisatie met eventueel variabele informatie die elk moment kan wijzigen.
 * <p>
 * Wanneer men deze entity wilt implementeren, moet men de visualize methode overerven van IVisualize.
 * Deze methode wordt gebruikt om de entiteit af te beelden.
 *
 * @see IVisualize
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
     * <p>
     * De default parameters zijn terug te vinden in PositionComponent en InformationComponent.
     *
     * @see PositionComponent
     * @see InformationComponent
     */
    public ATextEntity() {
        this.positionComponent = new PositionComponent();
        this.informationComponent = new InformationComponent();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param positionComponent De locatie (in graphics-coordinates) van de entiteit.
     * @param preText           De tekst die voor de informatie moet komen te staan.
     * @see PositionComponent
     * @see InformationComponent
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
     * @see PositionComponent
     * @see InformationComponent
     */
    public ATextEntity(PositionComponent positionComponent, String preText, String text) {
        this.positionComponent = positionComponent;
        this.informationComponent = new InformationComponent(preText, text);
    }

    /**
     * @return De positionComponent van de entiteit.
     */
    public PositionComponent getPositionComponent() {
        return positionComponent;
    }

    /**
     * @return De informationComponent van de entiteit.
     */
    public InformationComponent getInformationComponent() {
        return informationComponent;
    }
}
