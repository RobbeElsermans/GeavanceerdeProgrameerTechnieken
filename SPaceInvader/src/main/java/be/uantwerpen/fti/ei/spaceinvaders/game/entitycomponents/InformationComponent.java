package be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents;

/**
 * Een entiteit dat informatie kan bevatten.
 */
public class InformationComponent{
    private String preInfoText;
    private String information;
    public InformationComponent(){
        this.information = "";
    }
    public InformationComponent(String preText){
        this.preInfoText = preText;
    }
    public InformationComponent(String preText, String text){
        this.preInfoText = preText;
        this.information = text;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    public String getPreInfoText() {
        return preInfoText;
    }
    public String getInfoText() {
        return this.preInfoText + this.information;
    }
}
