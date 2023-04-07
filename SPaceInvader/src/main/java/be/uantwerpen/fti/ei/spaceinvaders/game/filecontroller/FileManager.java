package be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller;

import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;

import java.io.*;
import java.util.Properties;

/**
 * Help klassen die de functie krijgt om een bestand uit te lezen en hieruit parameters te halen en door te geven.
 */
public class FileManager {

    /**
     * Een static methode die met behulp van de gegeven parameters, de parameter op te halen in het gegeven bestand.
     *
     * @param propertyName De naam van de variabelen gedefinieerd in het bestand.
     * @param location     De locatie van het bestand.
     * @param defaultValue De standaard waarden voor moest het bestand of parameter niet bestaan.
     * @return De gevraagde/ default parameter waarden.
     * @description Als een bestand niet gevonden wordt en de locatie is geldig, zal er een nieuw bestand gemaakt worden en wordt de parameter hierin geplaatst met de default value.
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
     * Een static methode die met behulp van de gegeven parameters, de parameter op te halen in het gegeven bestand.
     *
     * @param propertyName De naam van de variabelen gedefinieerd in het bestand.
     * @param location     De locatie van het bestand.
     * @param defaultValue De standaard waarden voor moest het bestand of parameter niet bestaan.
     * @return De gevraagde/ default parameter waarden.
     * @description Als een bestand niet gevonden wordt en de locatie is geldig,
     * zal er een nieuw bestand gemaakt worden en wordt de parameter hierin geplaatst met de default value.
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
     * Een static methode die met behulp van de gegeven parameters, de parameter op te halen in het gegeven bestand.
     *
     * @param propertyNameWidth     De naam van de width variabelen gedefinieerd in het bestand.
     * @param propertyNameHeight    De naam van de height variabelen gedefinieerd in het bestand.
     * @param location     De locatie van het bestand.
     * @param defaultValue De standaard waarden voor moest het bestand of parameter niet bestaan als IDimension.
     * @return De gevraagde/ default parameter waarden in IDimension formaat.
     * @description Als een bestand niet gevonden wordt en de locatie is geldig,
     * zal er een nieuw bestand gemaakt worden en wordt de parameter hierin geplaatst met de default value.
     */
    public static IDimension getSettingAsDimension(String propertyNameWidth,String propertyNameHeight, String location, IDimension defaultValue) {
        double width = FileManager.getSettingDouble(propertyNameWidth, location, defaultValue.getWidth());
        double height = FileManager.getSettingDouble(propertyNameHeight, location, defaultValue.getHeight());
        return new Dimension(width, height);
    }

    /**
     * Wijzig een bestand met een property.
     *
     * @param propertyName De naam van de property.
     * @param location     Het bestands-pad met de naam included.
     * @param value De default value in string formaat.
     */
    public static void propOverwrite(String propertyName, String location, String value) {
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
     * Voeg een property toe aan een bestand.
     *
     * @param propertyName De naam van de property.
     * @param location     Het bestands-pad met de naam included.
     * @param defaultValue De default value in string formaat.
     */
    protected static void createProp(String propertyName, String location, String defaultValue) {
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
