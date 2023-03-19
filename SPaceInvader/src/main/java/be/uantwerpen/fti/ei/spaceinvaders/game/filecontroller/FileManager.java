package be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller;

import java.io.*;
import java.util.Properties;

public class FileManager {

    public static int getSetting(String propertyName, String location, int defaultValue) {
        int tempVal = defaultValue;
        try
        {
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

            }
            catch (IOException ex) {
                throw new RuntimeException(ex);
                //System.out.println("Er is een fout bestand pad meegegeven!");
            }
        }
        catch (NumberFormatException ex){
            //throw new NumberFormatException("De opgegeven propertyName is niet geldig! Default value wordt gebruikt.");
            System.out.println("De opgegeven propertyName is niet geldig! Default value wordt gebruikt");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
            //System.out.println("Er is een fout bestand pad meegegeven!");
        }


        return tempVal;
    }
}
