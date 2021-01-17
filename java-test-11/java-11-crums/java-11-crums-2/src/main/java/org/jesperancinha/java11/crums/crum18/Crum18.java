package org.jesperancinha.java11.crums.crum18;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum18 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 18 - Locale building and resources");

        final Locale locale = new Locale.Builder().setLanguage("portunol")
            .setRegion("ZZ")
            .build();

        final Locale locale2 = new Locale.Builder().setLanguage("portunol")
            .setRegion("WW")
            .build();

        MAGENTA.printGenericLn("We first try a happy case with locale -> %s", locale);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("dictionary", locale);
        resourceBundle.getKeys()
            .asIterator()
            .forEachRemaining(key -> Consolerizer.printOrangeGenericLn(resourceBundle.getString(key)));
        resourceBundle.getKeys()
            .asIterator()
            .forEachRemaining(Consolerizer::printOrangeGenericLn);

        MAGENTA.printGenericLn("Now we first try an unhappy case with locale -> %s", locale2);
        try {
            ResourceBundle resourceBundle2 = ResourceBundle.getBundle("dictionary", locale2);
            resourceBundle2.getKeys()
                .asIterator()
                .forEachRemaining(key -> Consolerizer.printOrangeGenericLn(resourceBundle.getString(key)));
            resourceBundle2.getKeys()
                .asIterator()
                .forEachRemaining(Consolerizer::printOrangeGenericLn);
        } catch (final MissingResourceException e) {
            printRedGenericLn("This is expected. In this case we should have some files that do not exist");
            printRedGenericLn("We should have had dictionary_portunol_WW.properties or any of the default files");
            printRedGenericLn("These would be dictionary.properties or dictionary_portunol.properties");
            printRedGenericLn("Exception thrown -> %s", e);
        }

        GREEN.printGenericLn("For the resource bundle to work we have some default hierarchy to follow");
        GREEN.printGenericLn("<bundle_name>_<language>_<location>.properties");
        GREEN.printGenericLn("If a location is not available, the ResourceBundle will try to look for other default files");
        GREEN.printGenericLn("<bundle_name>_<language>.properties");
        GREEN.printGenericLn("or <bundle_name>.properties");
        GREEN.printGenericLn("If all fails, the ResourceBundle will not load and will throw a MissingResource Exception");
        GREEN.printGenericLn("Its important to note that getBundle is a static method which gives back a ResourceBundle");
        GREEN.printGenericLn("The builder for Language uses setLanguage and setRegion to define a Locale, which is needed along with the bundle name to create a Resource bundle");
    }
}
