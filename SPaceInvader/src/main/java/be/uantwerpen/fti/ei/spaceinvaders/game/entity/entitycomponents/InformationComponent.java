package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een component dat informatie bevat in de vorm van een pretext en de effectieve informatie.
 * <p>
 * Deze component kan gebruikt worden om iets te laten zien aan een gebruiker.
 * Hier is een preInfoText die statisch is. En de information tekst die de variabele tekst bevat.
 */
public class InformationComponent {
    private final String preInfoText;
    private String information;

    /**
     * Default constructor waarbij:
     * <ul>
     *     <li>preInfoText  -> ""</li>
     *     <li>information  -> ""</li>
     * </ul>
     */
    public InformationComponent() {
        this.preInfoText = "";
        this.information = "";
    }

    /**
     * Overload constructor waarbij we een preInfoText kunnen meegeven.
     * <ul>
     *     <li>preInfoText  -> preText</li>
     *     <li>information  -> ""</li>
     * </ul>
     */
    public InformationComponent(String preText) {
        this.preInfoText = preText;
        this.information = "";
    }

    /**
     * Overload constructor waarbij we een preInfoText en een information kunnen meegeven.
     * <ul>
     *     <li>preInfoText  -> preText</li>
     *     <li>information  -> text</li>
     * </ul>
     */
    public InformationComponent(String preText, String text) {
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

    /**
     * Voegt preInfoText en information tekst samen.
     * <p>
     * Er wordt niets tussen beiden geplaatst.
     *
     * @return Een concatenatie van preInfoText en information.
     */
    public String getInfoText() {
        return this.preInfoText + this.information;
    }
}
