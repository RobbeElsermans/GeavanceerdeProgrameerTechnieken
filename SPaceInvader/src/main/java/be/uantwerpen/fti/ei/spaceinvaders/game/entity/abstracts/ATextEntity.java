package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.InformationComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.StaticComponent;

public abstract class ATextEntity implements IVisualize {
    /**
     * De entiteit bevat een statische positie.
     */
    private StaticComponent staticComponent;
    /**
     * De entiteit bevat een informatie component.
     */
    private InformationComponent informationComponent;

    public ATextEntity(){
        this.staticComponent = new StaticComponent();
        this.informationComponent = new InformationComponent();
    }
    public ATextEntity(StaticComponent staticComponent, String preText){
        this.staticComponent = staticComponent;
        this.informationComponent = new InformationComponent(preText);
    }
    public ATextEntity(StaticComponent staticComponent, String preText, String text){
        this.staticComponent = staticComponent;
        this.informationComponent = new InformationComponent(preText, text);
    }

    public StaticComponent getStaticComponent() {
        return staticComponent;
    }

    public void setStaticComponent(StaticComponent staticComponent) {
        this.staticComponent = staticComponent;
    }

    public InformationComponent getInformationComponent() {
        return informationComponent;
    }

    public void setInformationComponent(InformationComponent informationComponent) {
        this.informationComponent = informationComponent;
    }
}
