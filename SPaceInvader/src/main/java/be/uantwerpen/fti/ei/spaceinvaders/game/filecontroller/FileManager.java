package be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller;

import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;

import java.io.*;
import java.util.Properties;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Help klassen die de functie krijgt om een bestand uit te lezen en hieruit parameters te halen en door te geven.
 * Een FIle manager klasse die bepaalde parameters uit bestanden kan halen.
 * <p>
 * Als het bestand niet bestaat en het pad is geldig, wordt het bestand gecreëerd met daarin de default parameter waardes.
 * Men kan zowel integer parameters als double parameters erin/uit halen.
 * Als het bestand bestaat en de property niet, wordt deze property aan het bestaande bestand toegevoegd.
 * <p>
 * Als laatste is het mogelijk om een bestand te overschrijven met een property value.
 */
public class FileManager {
    /**
     * Een methode die met behulp van de gegeven parameters, de parameter op haalt in het gegeven bestand als integer.
     * <p>
     * Als het bestand niet bestaat en het pad is geldig, wordt het bestand gecreëerd met daarin de default parameter waardes.
     * Men kan zowel integer parameters als double parameters erin/uit halen.
     * <p>
     * Als het bestand bestaat en de property niet, wordt deze property aan het bestaande bestand toegevoegd.
     *
     * @param propertyName De naam van de variabelen gedefinieerd in het bestand.
     * @param location     De locatie van het bestand + de bestandsnaam.
     * @param defaultValue De standaard waarden, als integer, voor moest het bestand of parameter niet bestaan.
     * @return int, De gevraagde/ default parameter waarden als integer.
     */
    public static int getSettingInteger(String propertyName, String location, int defaultValue) {
        int tempVal = defaultValue;
        try {
            FileInputStream configuration = new FileInputStream(location);
            Properties prop = new Properties();
            prop.load(configuration);
            tempVal = Integer.parseInt(prop.getProperty(propertyName));

        } catch (FileNotFoundException e) {
            System.out.println("Het bestand bestaat niet! Het wordt aangemaakt met default value.");
            try {
                File file = new File(location);
                file.createNewFile();

                String configString = propertyName + "=" + tempVal + "\n";

                FileWriter fileWriter = new FileWriter(location);
                fileWriter.append(configString);
                fileWriter.close();

            } catch (IOException ex) {
                //throw new RuntimeException(ex);
                System.out.println("Er is een fout bestand pad meegegeven!");
            }
        } catch (NumberFormatException ex) {
            //throw new NumberFormatException("De opgegeven propertyName is niet geldig! Default value wordt gebruikt.");
            System.out.println("De opgegeven propertyName is niet geldig! Default value wordt gebruikt");
            createProp(propertyName, location, String.valueOf(defaultValue));
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("Er is een fout bestand pad meegegeven!");
        }
        return tempVal;
    }

    /**
     * Een methode die met behulp van de gegeven parameters, de parameter op haalt in het gegeven bestand als double.
     * <p>
     * Als het bestand niet bestaat en het pad is geldig, wordt het bestand gecreëerd met daarin de default parameter waardes.
     * Men kan zowel integer parameters als double parameters erin/uit halen.
     * <p>
     * Als het bestand bestaat en de property niet, wordt deze property aan het bestaande bestand toegevoegd.
     *
     * @param propertyName De naam van de variabelen gedefinieerd in het bestand.
     * @param location     De locatie van het bestand + de bestandsnaam.
     * @param defaultValue De standaard waarden, als double, voor moest het bestand of parameter niet bestaan.
     * @return double, De gevraagde/ default parameter waarden als double.
     */
    public static double getSettingDouble(String propertyName, String location, double defaultValue) {
        double tempVal = defaultValue;
        try {
            FileInputStream configuration = new FileInputStream(location);
            Properties prop = new Properties();
            prop.load(configuration);
            tempVal = Double.parseDouble(prop.getProperty(propertyName));

        } catch (FileNotFoundException e) {
            System.out.println("Het bestand bestaat niet! Het wordt aangemaakt met default value.");
            try {
                File file = new File(location);
                file.createNewFile();

                String configString = propertyName + "=" + tempVal + "\n";

                FileWriter fileWriter = new FileWriter(location);
                fileWriter.append(configString);
                fileWriter.close();

            } catch (IOException ex) {
                //throw new RuntimeException(ex);
                System.out.println("Er is een fout bestand pad meegegeven!");
            }
        } catch (NullPointerException ex) {
            //throw new NumberFormatException("De opgegeven propertyName is niet geldig! Default value wordt gebruikt.");
            System.out.println("De opgegeven propertyName is niet geldig! Default value wordt gebruikt");
            createProp(propertyName, location, String.valueOf(defaultValue));
        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println("Er is een fout bestand pad meegegeven!");
        }

        return tempVal;
    }

    /**
     * Een methode die met behulp van de gegeven parameters, de parameter op haalt in het gegeven bestand als IDimension.
     * <p>
     * Als het bestand niet bestaat en het pad is geldig, wordt het bestand gecreëerd met daarin de default parameter waardes.
     * Men kan zowel integer parameters als double parameters erin/uit halen.
     * <p>
     * Als het bestand bestaat en de property niet, wordt deze property aan het bestaande bestand toegevoegd.
     *
     * @param propertyNameWidth  De naam van de width variabelen gedefinieerd in het bestand.
     * @param propertyNameHeight De naam van de height variabelen gedefinieerd in het bestand.
     * @param location           De locatie van het bestand.
     * @param defaultValue       De standaard waarden voor moest het bestand of parameter niet bestaan als IDimension.
     * @return IDimension, De gevraagde/ default parameter waarden in IDimension formaat.
     */
    public static IDimension getSettingAsDimension(String propertyNameWidth, String propertyNameHeight, String location, IDimension defaultValue) {
        double width = FileManager.getSettingDouble(propertyNameWidth, location, defaultValue.getWidth());
        double height = FileManager.getSettingDouble(propertyNameHeight, location, defaultValue.getHeight());
        return new Dimension(width, height);
    }

    /**
     * Een methode die met behulp van de gegeven parameters, de parameter op haalt in het gegeven bestand als IPosition.
     * <p>
     * Als het bestand niet bestaat en het pad is geldig, wordt het bestand gecreëerd met daarin de default parameter waardes.
     * Men kan zowel integer parameters als double parameters erin/uit halen.
     * <p>
     * Als het bestand bestaat en de property niet, wordt deze property aan het bestaande bestand toegevoegd.
     *
     * @param propertyNameX De naam van de x-positie variabelen gedefinieerd in het bestand.
     * @param propertyNameY De naam van de y-positie variabelen gedefinieerd in het bestand.
     * @param location      De locatie van het bestand.
     * @param defaultValue  De standaard waarden voor moest het bestand of parameter niet bestaan als IPosition.
     * @return IPosition, De gevraagde/ default parameter waarden in IPosition formaat.
     */
    public static IPosition getSettingAsPosition(String propertyNameX, String propertyNameY, String location, IPosition defaultValue) {
        double width = FileManager.getSettingDouble(propertyNameX, location, defaultValue.getX());
        double height = FileManager.getSettingDouble(propertyNameY, location, defaultValue.getY());
        return new Position(width, height);
    }

    /**
     * Een methode die met behulp van de gegeven parameters, een bestand kan overschrijven met de gegeven value.
     *
     * @param propertyName De naam van de variabelen gedefinieerd in het bestand.
     * @param location     De locatie van het bestand + de bestandsnaam.
     * @param value        De value die in het bestand wordt geschreven in string formaat.
     */
    public static void overwriteFile(String propertyName, String location, String value) {
        try {
            String configString = propertyName + "=" + value + "\n";

            FileWriter fileWriter = new FileWriter(location, false);
            fileWriter.append(configString);
            fileWriter.close();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
            //System.out.println("Er is een fout bestand pad meegegeven!");
        }
    }

    /**
     * Voegt een property toe aan een bestand.
     *
     * @param propertyName De naam van de variabelen gedefinieerd in het bestand.
     * @param location     De locatie van het bestand + de bestandsnaam.
     * @param defaultValue De value in string formaat.
     */
    private static void createProp(String propertyName, String location, String defaultValue) {
        try {
            String configString = propertyName + "=" + defaultValue + "\n";

            FileWriter fileWriter = new FileWriter(location, true);
            fileWriter.append(configString);
            fileWriter.close();


        } catch (IOException ex) {
            throw new RuntimeException(ex);
            //System.out.println("Er is een fout bestand pad meegegeven!");
        }
    }
}
