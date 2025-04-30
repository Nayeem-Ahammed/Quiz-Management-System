import java.util.Scanner;

public class Main {


public static String[] java = {
"                          @                                                            ",
"                         @@                                                            ",
"                        @@@                                                            ",
"                        @@@                                                            ",
"                       @@@                                                             ",
"                    @@@@@                                                              ",
"                  @@@@@    @@@@                                                        ",
"                @@@@@   @@@@                                                           ",
"              @@@@@  @@@@@                                                             ",
"             @@@@@  @@@@                                                               ",
"             @@@   @@@@                        @@@                                     ",
"             @@@    @@@@                       @@@@                                    ",
"              @@@    @@@@@                     @@@@                                    ",
"                @@   @@@@@                     @@@@ @@@@@@@@@@ @@@@     @@@@ @@@@@@@@@ ",
"                 @@    @@@                     @@@@ @@@   @@@@@ @@@@    @@@  @@    @@@@",
"           @@         @@@       @@@@@@         @@@@        @@@@  @@@@  @@@@        @@@@",
"     @@@@@                 @@@@     @@@        @@@@  @@@@@@@@@@  @@@@ @@@@    @@@@@@@@@",
"     @@@@@@@@@@@@@@@@@@@@@@@        @@@        @@@@ @@@@   @@@@   @@@@@@@@  @@@@   @@@@",
"                                   @@@@        @@@@ @@@    @@@@   @@@@@@@   @@@@   @@@@",
"         @@@@        @@@@@@@     @@@@          @@@@ @@@@@@@@@@@    @@@@@    @@@@@@@@@@@",
"          @@@@@@@@@@@@@@@@@    @@             @@@@     @@                       @      ",
"                                             @@@@                                      ",
"          @@@@@@@@@@@@@@@@@                 @@@@                                       ",
"            @@@@@@@@@@@@@@                                                             ",
 "@@@@@                             @@                                                  ",
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  @@                                                ",
"    @@@@@@@@@@@@@@@@@@@@@@@@@     @@@@                                                 ",
"        @@@@@@@@@@@@@@@@@@@@@@@@@@                                                     "
                                                                                 	
};

    public static String tab = "\t\t\t\t\t\t\t\t\t\t\t";
    public static void main(String[] args) {
        
        while (true) { 
            Design.clearScreen();
            Design.printDesign("\n\n" + Design.CYAN, Design.BOLD, tab+"Welcome to the Java Design Program\n\n" + Design.RESET);
            Design.printDesign(Design.RED, tab + "\t1. "+ Design.RESET + Design.GREEN + "Registration\n" + Design.RESET);
            Design.printDesign(Design.RED, tab + "\t2. "+ Design.RESET  + Design.GREEN + "Login\n" + Design.RESET);
            Design.printDesign(Design.RED, tab + "\t3. "+ Design.RESET  + Design.GREEN + "Exit\n" + Design.RESET);
            Design.printDesign(Design.YELLOW, tab + "Please select an option: " + Design.RESET);

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        }
    }
}