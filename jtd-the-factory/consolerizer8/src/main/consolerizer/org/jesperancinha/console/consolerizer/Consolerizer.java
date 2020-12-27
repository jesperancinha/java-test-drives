package org.jesperancinha.console.consolerizer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;
import static java.util.stream.Collectors.joining;
import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.ConColor.BRIGHT_WHITE;
import static org.jesperancinha.console.consolerizer.ConColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConColor.WHITE;

public class Consolerizer {

    private final static int TYPING_DEFAULT_MS = 10;
    private final static int MAX_LINE_CHARS = 0;
    private final static int RAINBOW_LINE_CHARS = 10;
    private final static int TITLE_SPREAD = 100;
    private final static ConColor CON_COLOR_DEFAULT = BRIGHT_WHITE;

    private int typingWait;

    public static int typingWaitGlobal = TYPING_DEFAULT_MS;
    public static int maxLineCharsGlobal = MAX_LINE_CHARS;
    public static int rainbowLineChars = RAINBOW_LINE_CHARS;
    public static int titleSpread = TITLE_SPREAD;
    public static boolean blackAndWhite;

    private ConColor conColor = CON_COLOR_DEFAULT;

    public Consolerizer() {
        typingWait = TYPING_DEFAULT_MS;
    }

    public Consolerizer(int typingWait) {
        this.typingWait = typingWait;
    }

    public static Consolerizer createGreen() {
        return new Consolerizer().conColor(ConColor.BRIGHT_GREEN);
    }

    public Consolerizer conColor(ConColor conColor) {
        this.conColor = conColor;
        return this;
    }

    public Consolerizer typingWait(int typingWait) {
        this.typingWait = typingWait;
        return this;
    }

    public static void printBlueGenericLn(String text, Object... args) {
        printBlueGeneric(text.concat("\n"), args);

    }

    public static void printBlueGenericLn(Object text) {
        printBlueGeneric(text.toString()
            .concat("\n"));
    }

    public static void printBlueGenericTitleLn(Object text) {
        final String fullText = text.toString();
        int remaining = titleSpread - fullText.length() - 2;
        int padding = (int) Math.ceil(remaining / 2f);
        printBlueGeneric(new String(new char[padding]).replace('\0', '=')
            .concat(" ")
            .concat(fullText)
            .concat(" ")
            .concat(new String(new char[padding]).replace('\0', '='))
            .substring(0, titleSpread)
            .concat("\n"));
    }

    public static void printBlueGeneric(String text) {
        System.out.print(BLUE.getConsoleColor());
        printPrivateText(text);
    }

    public static void printBlueGeneric(String text, Object... args) {
        System.out.print(BLUE.getConsoleColor());
        printPrivateText(text, args);
    }

    public static void printMagentaGenericLn(String text, Object... args) {
        printMagentaGeneric(text.concat("\n"), args);

    }

    public static void printMagentaGenericLn(Object text) {
        printMagentaGeneric(text.toString()
            .trim()
            .concat("\n"));
    }

    public static void printMagentaGeneric(Object text) {
        System.out.print(MAGENTA.getConsoleColor());
        printPrivateText(text.toString());
    }

    public static void printMagentaGeneric(String text, Object... args) {
        System.out.print(MAGENTA.getConsoleColor());
        printPrivateText(text, args);
    }

    public static void printBrightMagentaGenericLn(String text, Object... args) {
        printBrightMagentaGeneric(text.concat("\n"), args);

    }

    public static void printBrightMagentaGenericLn(Object text) {
        printBrightMagentaGeneric(text.toString()
            .concat("\n"));
    }

    public static void printBrightMagentaGeneric(Object text) {
        System.out.print(BRIGHT_MAGENTA.getConsoleColor());
        printPrivateText(text.toString());
    }

    public static void printBrightMagentaGeneric(String text, Object... args) {
        System.out.print(BRIGHT_MAGENTA.getConsoleColor());
        printPrivateText(text, args);
    }

    public static void printGreenGenericLn(Object text) {
        printGreenGeneric(trim(("" + text)).concat("\n"));
    }

    public static void printGreenGeneric(Object text) {
        System.out.print(ConColor.GREEN.getConsoleColor());
        printPrivateText(text.toString());
    }

    public static void printGreenGenericLn(String text, Object... args) {
        printGreenGeneric(text.concat("\n"), args);
    }

    public static void printGreenGeneric(String text, Object... args) {
        System.out.print(ConColor.GREEN.getConsoleColor());
        printPrivateText(text, args);
    }

    public static void printRedGenericLn(String text, Object... args) {
        printRedGeneric(text.concat("\n"), args);
    }

    public static void printRedGeneric(String text, Object... args) {
        System.out.print("\033[0;31m");
        printPrivateText(text, args);
    }

    public static void printRedGenericLn(Object text) {
        printRedGeneric(trim(("" + text)).concat("\n"));
    }

    public static void printRedGeneric(String text) {
        System.out.print("\033[0;31m");
        printPrivateText(text);
    }

    public static void printYellowGenericLn(Object text) {
        printYellowGeneric(text.toString()
            .concat("\n"));

    }

    public static void printYellowGenericLn(Object text, Object... args) {
        printYellowGeneric(text.toString()
            .concat("\n"), args);
    }

    public static void printOrangeGeneric(String text) {
        System.out.print(ConColor.ORANGE.getConsoleColor());
        printPrivateText(text);
    }

    public static void printOrangeGenericLn(Object text) {
        printOrangeGeneric(text.toString()
            .concat("\n"));
    }

    public static void printOrangeGenericLn(String text, Object... args) {
        printOrangeGeneric(text.concat("\n"), args);
    }

    public static void printOrangeGeneric(String text, Object... args) {
        System.out.print(ConColor.ORANGE.getConsoleColor());
        printPrivateText(text, args);
    }

    public static void printYellowGeneric(Object text) {
        System.out.print(ConColor.YELLOW.getConsoleColor());
        printPrivateText(text.toString());
    }

    public static void printYellowGeneric(String text, Object... args) {
        System.out.print(ConColor.YELLOW.getConsoleColor());
        printPrivateText(text, args);
    }

    public void printColorText(final ConColor conColor, String text) {
        System.out.print(conColor.getConsoleColor());
        printPrivateText(text);
    }

    public void printRed(String text) {
        System.out.print("\033[0;31m");
        printPrivateText(text);
    }

    public void printRed(String text, String... args) {
        System.out.print("\033[0;31m");
        printPrivateText(text, args);
    }

    public void printGreen(String text) {
        System.out.print("\033[1;32m");
        printPrivateText(text);
    }

    public void printBlue(String text) {
        System.out.print("\033[0;34m");
        printPrivateText(text);
    }

    public static void printBrightCyanGenericLn(final String text, final Object... args) {
        printBrightCyanGeneric(text.concat("\n"), args);
    }

    public static void printBrightCyanGenericLn(Object text) {
        printBrightCyanGeneric(("" + text).concat("\n"));
    }

    public static void printBrightCyanGeneric(Object text) {
        System.out.print(ConColor.BRIGHT_CYAN.getConsoleColor());
        printPrivateText(text.toString());
    }

    public static void printBrightCyanGeneric(String text, Object... args) {
        System.out.print(ConColor.BRIGHT_CYAN.getConsoleColor());
        printPrivateText(text, args);
    }


    public static void printWhiteGenericLn(final String text, final Object... args) {
        printWhiteGeneric(text.concat("\n"), args);
    }

    public static void printWhiteGenericLn(Object text) {
        printWhiteGeneric(("" + text).concat("\n"));
    }

    public static void printWhiteGeneric(Object text) {
        System.out.print(WHITE.getConsoleColor());
        printPrivateText(text.toString());
    }

    public static void printWhiteGeneric(String text, Object... args) {
        System.out.print(WHITE.getConsoleColor());
        printPrivateText(text, args);
    }

    public void printBrightCyan(Object text) {
        System.out.print(ConColor.BRIGHT_CYAN.getConsoleColor());
        printPrivateText(text.toString());
    }

    public void printBrightCyan(String text, Object... args) {
        System.out.print(ConColor.BRIGHT_CYAN.getConsoleColor());
        printPrivateText(text, args);
    }

    public void printText(String text) {
        System.out.print(conColor.getConsoleColor());
        printPrivateText(text);
    }

    public void printText(String text, Object... vars) {
        System.out.print(conColor.getConsoleColor());
        printPrivateText(text, vars);
    }

    private static void printPrivateText(String text) {
        if (blackAndWhite) {
            System.out.print(WHITE.getConsoleColor());
        }
        printPrivateText(text, typingWaitGlobal, maxLineCharsGlobal);
    }

    private static void printPrivateText(String text, Object... vars) {
        if (blackAndWhite) {
            System.out.print(WHITE.getConsoleColor());
        }
        if (vars instanceof String[][]) {
            printPrivateText(text, typingWaitGlobal, maxLineCharsGlobal,
                new Object[] { processMultiArrays2((String[][]) vars) });
        } else {
            for (int i = 0; i < vars.length; i++) {
                Object variable = vars[i];
                if (variable instanceof Exception) {
                    final StringWriter out = new StringWriter();
                    ((Exception) variable).printStackTrace(new PrintWriter(out));
                    vars[i] = out.toString();
                }
                if (variable instanceof Error) {
                    Throwable e = (Throwable) variable;
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    StringBuilder sb = new StringBuilder(e.getClass()
                        .getCanonicalName());
                    if (Objects.nonNull(e.getMessage())) {
                        sb.append("\n\t");
                        sb.append(e.getMessage());
                    }
                    Arrays.stream(stackTrace)
                        .forEach(stackTraceElement -> {
                            sb.append("\n\t");
                            sb.append(stackTraceElement.toString());
                        });
                    if (variable instanceof Error) {
                        Throwable cause = e.getCause();
                        if (Objects.nonNull(cause)) {
                            sb.append("\n");
                            sb.append(cause.getClass()
                                .getCanonicalName());
                            if (Objects.nonNull(cause.getMessage())) {
                                sb.append("\n\t");
                                sb.append(cause.getMessage());
                            }
                            Arrays.stream(cause.getStackTrace())
                                .forEach(stackTraceElement -> {
                                    sb.append("\n\t");
                                    sb.append(stackTraceElement.toString());
                                });
                        }
                    }
                    vars[i] = sb.toString();
                } else if (variable instanceof String[][]) {
                    vars[i] = processMultiArrays2((String[][]) vars[i]);
                } else if (variable instanceof String[]) {
                    vars[i] = "[".concat(String.join(",", (String[]) variable))
                        .concat("]");
                } else if (variable instanceof int[]) {
                    vars[i] = "[".concat(IntStream.of((int[]) variable)
                        .mapToObj(Integer::toString)
                        .collect(joining(","))
                        .concat("]"));
                }
            }
            printPrivateText(text, typingWaitGlobal, maxLineCharsGlobal, vars);
        }
    }

    private static String processMultiArrays2(String[][] vars) {
        return "[".concat(Arrays.stream(vars)
            .flatMap(x -> Stream.of("[".concat(String.join(",", x))
                .concat("]")))
            .collect(joining(",")))
            .concat("]");
    }

    private static void printPrivateText(String text, int typingWait, int maxLineChars) {
        String printText = text;
        if (maxLineChars > 0 && printText.length() > maxLineChars) {
            printText = getParagraphFormat(maxLineChars, printText);
        }

        for (int i = 0; i < printText.length(); i++) {
            if (typingWait > 0) {
                try {
                    sleep(typingWait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(printText.charAt(i));
        }
        if (!text.contains("\n")) {
            System.out.print(" ");
        }
        System.out.print(WHITE.getConsoleColor());
    }

    private static String getParagraphFormat(int maxLineChars, String printText) {
        return Arrays.stream(printText.split("\n"))
            .map(paragraph -> Arrays.stream(getSplit(maxLineChars, paragraph))
                .map(Consolerizer::trim)
                .collect(joining("\n")))
            .collect(joining("\n"))
            .concat("\n");

    }

    private static void printPrivateText(String text, int typingWait, int maxLineChars, final Object... vars) {
        String newText = String.format(text, vars);
        String printText = newText;
        if (maxLineChars > 0) {
            printText = getParagraphFormat(maxLineChars, printText);
        }

        for (int i = 0; i < printText.length(); i++) {
            if (typingWait > 0) {
                try {
                    sleep(typingWait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(printText.charAt(i));
        }
        if (!text.contains("\n")) {
            System.out.print(" ");
        }
        System.out.print(WHITE.getConsoleColor());
    }

    private static String[] getSplit(int maxLineChars, String printText) {
        String[] split = trim(printText).split("(?<=\\G.{" + maxLineChars + "})");
        if (split.length > 1 && split[1].length() > maxLineChars) {
            String[] newSplit = getSplit(maxLineChars, split[1]);
            int newLength = newSplit.length + 1;
            String[] newStrings = new String[newLength];
            newStrings[0] = trim(split[0]);
            System.arraycopy(newSplit, 0, newStrings, 1, newSplit.length);
            return newStrings;
        }
        return split;
    }

    public static void printRainbowTitleLn(final Object title) {
        printRainbowTitle(title.toString()
            .trim());
        System.out.print("\n");
        System.out.print(WHITE.getConsoleColor());
    }

    public static void printRainbowTitleLn(final String title, final Object... objects) {
        printRainbowTitle(String.format(title, objects));
        System.out.print("\n");
        System.out.print(WHITE.getConsoleColor());
    }

    public static void printRainbowTitle(final String title) {
        List<String> consoleRainbow = ConColor.getConsoleRainbow();
        int k = 0;
        int i;
        for (i = 0; i < title.length(); i++) {
            if (k == consoleRainbow.size()) {
                k = 0;
            }
            System.out.print(consoleRainbow.get(k));
            System.out.print(title.charAt(i));
            if (title.charAt(i) != ' ') {
                k++;
            }
        }
        System.out.print(WHITE.getConsoleColor());
    }

    public static void printRainbowLn(final char c, int nchars) {
        printRainbowLn(Stream.generate(((Character) c)::toString)
            .limit(nchars)
            .collect(joining()));
    }

    public static void printRainbowLn(final char c) {
        printRainbowLn(Stream.generate(((Character) c)::toString)
            .limit(rainbowLineChars)
            .collect(joining()));
    }

    public static void printRainbowLn(final String theme) {
        printRainbow(theme);
        System.out.print("\n");
    }

    public static void printRainbow(final String theme) {
        ConColor.getConsoleRainbow()
            .forEach(color -> {
                System.out.print(color);
                System.out.print(theme);
            });
    }

    public static void printRainbowStack(final String theme) {
        ConColor.getConsoleRainbow()
            .forEach(color -> {
                System.out.print(color);
                System.out.println(theme);
            });
    }

    public static void printUnicornsLn(final int nUnicorns) {
        printRainbowLn('-', nUnicorns / 4);
        for (int i = 0; i < nUnicorns; i++) {
            System.out.print("🦄");
        }
        printNewLine();
        printRainbowLn('-', nUnicorns / 4);
    }

    public static void printSameLine(final String text, final Object... objects) {
        System.out.print("\r");
        System.out.printf(text, objects);
    }

    public static void printNewLine() {
        System.out.print("\n");
    }

    public static String trim(String string) {
        return string.replaceAll("^[\n]+|[\n]+$", "");
    }

    public static void printRedThrowableAndExit(Throwable e) {
        printRedGenericLn("Ooops! This should not have happened. Check your system! -> %s", e);
        printRedGenericLn("Check if there is a prepare.sh script and if you ran it.", e);
        System.exit(1);
    }
}