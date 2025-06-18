public class ConsoleUtil {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_CYAN = "\u001B[36m";

  public static final String ANSI_BG_BLACK = "\u001B[40m";
  public static final String ANSI_BG_RED = "\u001B[41m";
  public static final String ANSI_BG_GREEN = "\u001B[42m";
  public static final String ANSI_BG_YELLOW = "\u001B[43m";
  public static final String ANSI_BG_BLUE = "\u001B[44m";
  public static final String ANSI_BG_PURPLE = "\u001B[45m";
  public static final String ANSI_BG_CYAN = "\u001B[46m";
  public static final String ANSI_BG_WHITE = "\u001B[47m";

  public static final String ANSI_BOLD = "\u001B[1m";

  public static void printHighlighted(String text, String bgColor) {
    System.out.print(bgColor + ANSI_BOLD + text + ANSI_RESET);
  }

public static void clearScreen() {
    try {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            Runtime.getRuntime().exec("clear");
        }
    } catch (Exception e) {
        // Fallback menggunakan metode alternative
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // For Windows
                Runtime.getRuntime().exec("cls");
            }
        } catch (final Exception e2) {
            // Jika semua gagal, gunakan newlines
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
}

  public static void printHeader(String text) {
    String border = "=".repeat(60);
    System.out.println("\n" + ANSI_YELLOW + border);
    System.out.println(centerText(text, 60));
    System.out.println(border + ANSI_RESET);
  }

  public static void printSubHeader(String text) {
    String border = "-".repeat(60);
    System.out.println("\n" + ANSI_BLUE + border);
    System.out.println(centerText(text, 60));
    System.out.println(border + ANSI_RESET);
  }

  public static String centerText(String text, int width) {
    return String.format("%" + (width + text.length()) / 2 + "s", text);
  }

  public static void printSuccess(String message) {
    System.out.print(ANSI_BG_GREEN + ANSI_BOLD + " SUCCESS " + ANSI_RESET + " ");
    System.out.println(message);
  }

  public static void printError(String message) {
    System.out.println(ANSI_RED + "✗ " + message + ANSI_RESET);
  }

  public static void pressEnterToContinue() {
    System.out.println("\nTekan Enter untuk melanjutkan...");
    try {
      System.in.read();
    } catch (Exception e) {}
  }
}