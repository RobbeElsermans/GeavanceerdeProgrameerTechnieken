package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

/**
 * Een component dat informatie bevat.
 */
public class InformationComponent{
    private String preInfoText;
    private String information;
    public InformationComponent(){
        this.preInfoText = "";
        this.information = "";
    }
    public InformationComponent(String preText){
        this.preInfoText = preText;
        this.information = "";
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
