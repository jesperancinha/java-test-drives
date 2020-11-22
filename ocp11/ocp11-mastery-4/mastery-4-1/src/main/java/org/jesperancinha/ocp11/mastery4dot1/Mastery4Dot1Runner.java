package org.jesperancinha.ocp11.mastery4dot1;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery4dot1.levels.BeginnerException;
import org.jesperancinha.ocp11.mastery4dot1.levels.ExpertException;
import org.jesperancinha.ocp11.mastery4dot1.levels.JuniorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.MediorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.RookieException;
import org.jesperancinha.ocp11.mastery4dot1.levels.SeniorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.SuperSeniorException;
import org.jesperancinha.ocp11.mastery4dot1.riots.RaidException;
import org.jesperancinha.ocp11.mastery4dot1.riots.ResponseException;
import org.jesperancinha.ocp11.mastery4dot1.society.TheGreatSocietyAdapter;
import org.jesperancinha.ocp11.mastery4dot1.states.LBJGovernment;

import java.util.HashMap;
import java.util.Scanner;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;

public class Mastery4Dot1Runner {
    private static boolean skipQuestions;

    public static void main(String[] args) {
        if (args.length > 0) {
            skipQuestions = "-skip".equals(args[0]);
        }
        Consolerizer.typingWaitGlobal = 0;
        printBlueGenericLn("================== Master Module mastery-4-1 ==================");

        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();

        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with the united states of america's history flavour to it.");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
    }

    private static void exercise6() {
        printBrightCyanGenericLn("--- 6. Java Inheritance of state");
        printRainbowLn("==");
        printGreenGenericLn("Case: After JFK's assassination, LBJ inherited the bill of rights which JFK had fought for, for so long.");
        printGreenGenericLn("This was the time to make a move, and make a move LBJ did!");
        printGreenGenericLn("Marylin Monroe, didn't sing Happy B'Day to LBJ though.");
        var lbjGovernment  = new LBJGovernment();
        printMagentaGenericLn("Work to do:");
        printMagentaGenericLn("Civil Rights Bill passed: %s", lbjGovernment.civilRightsBill);
        printMagentaGenericLn("Happy birthday passed: %s", lbjGovernment.bDay);
        printMagentaGenericLn("But wait! This is not an instance member!: %s", LBJGovernment.bDay);
        printMagentaGenericLn("So no `Happy Birthday Mr. President`for LBJ");
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Since we cannot have a subclass of multiple classes, only interfaces, then is no multiple inheritance of state in Java");
    }

    private static void exercise5() {
        printBrightCyanGenericLn("--- 5. Generics separation between `<T>` and `T`");
        printRainbowLn("==");
        printGreenGenericLn("Case: Lyndon B. Johnson envisioned `The Great Society plan` in 1963.");
        printGreenGenericLn("This led through the years to the civil rights act of 1964 and 1965.");
        printGreenGenericLn("We can make a few sentences with this:");
        var theGreatSocietyString = new TheGreatSocietyAdapter<String>();
        try {
            final String theGreatSociety = theGreatSocietyString.printSocietyAdapterMethod(1963, 1);
        } catch (ClassCastException e) {
            printRedGenericLn("This happens because we specified that the `printSocietyAdapterMethod` would return `String` -> %s", e);
            printRedGenericLn("However we also generically specify that if input parameters are numbers, then it should return a `Double` number.");
            printRedGenericLn("This is why it fail this way. Let's make it good now.");
        }
        printMagentaGenericLn(theGreatSocietyString.printSocietyAdapterMethod("The civil liberties act was signed off by LBJ in ", 1963));
        var theGreatSocietyDouble = new TheGreatSocietyAdapter<Double>();
        printMagentaGenericLn("The Great Society term was coined in %d which led to the creation of the Civil Rights act of %f", 1964, theGreatSocietyDouble.printSocietyAdapterMethod(1963, 1));
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. We can specify a generic type for one specify class before runtime or during runtime with anonymous classes");
        printGreenGenericLn("2. We can also, regardless of the class generic type, specify the input params of each individual method of an instance object during runtime");
        printGreenGenericLn("3. We can, in the same way specify the return parameters");
    }

    private static void exercise4() {
        printBrightCyanGenericLn("--- 4. Last `Exception` to execute before exiting program abruptly");
        printRainbowLn("==");
        printGreenGenericLn("Case: It is 1969, June 28th and you went downtown NY to the famous `The Stonewall Inn`");
        printGreenGenericLn("It was a nice cosy night and now its early morning and all of the sudden the police charges in!");
        printGreenGenericLn("You are now facing the beginnings of what later became known as the Stonewall riots");

        try {
            try {
                printMagentaGenericLn("Patrons are having after hours fun!");
                throw new RaidException();
            } finally {
                try {
                    throw new ResponseException();
                } catch (ResponseException e) {
                    printRedGenericLn("This should be first exception: %s", e);
                    printRedGenericLn("If our story had ended here, the raid would have never happened.");
                    printRedGenericLn("In other words, System.exit(1), would have not allowed to see the output of RaidException.");
                    // System.exit(1);
                }
            }
        } catch (RaidException e) {
            printRedGenericLn("Notice when this exception occurs: %s", e);
        } finally {
            printRedGenericLn("You see this here, but if you did a System.exit(1) in the previous location, you wouldn't see this message");
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Although finally always occurs in a try catch, the exception doesn't do anything yet although it has been thrown, if no catch is declared");
        printGreenGenericLn("2. Further process that block the thread from continuing will prevent this exception to affect anything at all.");
    }

    private static void exercise3() {
        printBrightCyanGenericLn("--- 3. JLS evaluation order in multiple operands");
        printRainbowLn("==");
        printGreenGenericLn("https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html");
        printGreenGenericLn("Case: We have the initials LBJ and we want to know how many years was he/she president.");
        printGreenGenericLn("We don't know anything about them. Just the initials.");
        printGreenGenericLn("We have a map from initials to president name.");
        printGreenGenericLn("Another from president name to year.");
        printGreenGenericLn("Another from year to president number.");
        printGreenGenericLn("And finally and array from president number to how many years.");
        printGreenGenericLn("Can we do this in one go?");

        var mapPresidentName = new HashMap<String, String>() {{
            put("LBJ", "Lyndon B. Johnson");
        }};
        var mapNameToYear = new HashMap<String, Integer>() {{
            put("Lyndon B. Johnson", 1963);
        }};
        var mapYearToNumber = new HashMap<Integer, Integer>() {{
            put(1963, 37);
        }};
        var array = new Integer[45];
        var yearsInPower = 2;
        printRedGenericLn("We seem to have found a mistake. It wasn't %d years. That's for sure!", yearsInPower);
        var presidentName = "JFK";
        presidentSearch(presidentName, presidentName, presidentName = mapPresidentName.get("LBJ"));
        final int years = array[mapYearToNumber.get(mapNameToYear.get(mapPresidentName.get("LBJ"))) - 1] = yearsInPower = 3;
        printMagentaGenericLn("I guess our calculation is correct. They were %d years!", years);
        printMagentaGenericLn("An now it is corrected also in our data structures: %d years!", yearsInPower);
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Expression evaluation can be seriously complicated");
        printGreenGenericLn("2. Most counter intuitive rule might be that the left operand is evaluated first.");
        printGreenGenericLn("3. All operands have to be evaluated");
        printGreenGenericLn("4. Read https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html for more details±!");
    }

    private static void presidentSearch(String presidentName, String presidentName1, String lbj) {
        printBrightCyanGenericLn("We though it was %s, but then it wasn't %s and instead it was %s", presidentName, presidentName1, lbj);
    }

    private static void exercise2() {
        printBrightCyanGenericLn("--- 2. What is the output of `String` for it's 3 different kind of values: `null`, \"\" and \"Something\"");
        printRainbowLn("==");
        printGreenGenericLn("Case: Three students are making resets: Katie, Chloe and Susan");
        printBlueGenericLn("Teacher: In what year was JFK assigned to the ONI field office at Headquarters");
        final String katieResponse = null;
        printMagentaGenericLn("Katie: Hmmmm.... " + katieResponse);
        printBlueGenericLn("T: That is not correct. Chloe?");
        final var chloeResponse = "";
        printMagentaGenericLn("Chloe: I don't know, maybe, %s", chloeResponse);
        printBlueGenericLn("T: You also don't know? How about you Susan?");
        final Object susanResponse = "January 1942";
        printMagentaGenericLn("Susan: Of course I do! It was in %s", susanResponse);

        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. An empty string does not generate output");
        printGreenGenericLn("2. A null string generates `null` as output");
        printGreenGenericLn("3. A string with a value, generates that value as output");
    }

    private static void exercise1() {
        printBrightCyanGenericLn("--- 1. `Exception` `catch` order");
        printRainbowLn("==");
        printGreenGenericLn("Case: We have just made a test about the history of the United States of America.");
        printGreenGenericLn("You are applying for a United States residency and nationality.");
        printGreenGenericLn("You will be qualified in 6 levels in lowest to highest order:");
        printGreenGenericLn("rookie, beginner, junior, medior, expert or senior");
        final var scanner = new Scanner(System.in);
        try {
            question(scanner, "In what year was president JFK born?", "1917", new RookieException());
            question(scanner, "JFK was which president of the United States of America?", "35", new BeginnerException());
            question(scanner, "How many years was JFK in power?", "3", new JuniorException());
            question(scanner, "In what year did JFK enrolled in Harvard University?", "1936", new MediorException());
            question(scanner, "In what year did JFK write his senior thesis on " +
                    "how Britain was in a considerable weak position against the germans in WWII?", "1939", new ExpertException());
            question(scanner, "When did JFK graduated?", "1940", new SeniorException());
            question(scanner, "How many copies did `Why England Slept` sold?", "80000", new SuperSeniorException());
        } catch (SuperSeniorException e) {
            printMagentaGenericLn("You are a Super Senior!");
        } catch (SeniorException e) {
            printMagentaGenericLn("You are a Senior!");
        } catch (ExpertException e) {
            printMagentaGenericLn("You are a Expert!");
        } catch (MediorException e) {
            printMagentaGenericLn("You are a Medior!");
        } catch (JuniorException e) {
            printMagentaGenericLn("You are a Junior!");
        } catch (BeginnerException e) {
            printMagentaGenericLn("You are a Beginner!");
        } catch (RookieException e) {
            printMagentaGenericLn("You are a Rookie!");
        } catch (Exception e) {
            printRedThrowableAndExit(e);
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. In a try with multiple catches, the order is more specific to more generic");
    }

    private static void question(Scanner scanner, String s, String s2, RookieException e) throws RookieException {
        printBrightCyanGenericLn(s);
        String a7;
        if (skipQuestions) {
            a7 = s2;
            printGreenGenericLn(a7);
        } else {
            a7 = scanner.nextLine();
        }
        if (!a7.equals(s2)) {
            throw e;
        }
    }
}
