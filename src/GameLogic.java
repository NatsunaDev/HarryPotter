package HarryPotter;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);


    //Get a  input
    public static int readInt(String prompt, int userChoices) {

        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please choose a INTEGER !");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.println("");
    }

    public static void Separator(int n){
        for(int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static void Header(String title){
        Separator(title.length());
        System.out.println(title);
        Separator(title.length());
    }
    public static void toContinue() {
        String confirm = "";
        while (!confirm.equals("y")) {
            System.out.println("Press : y to continue");
            confirm = scanner.nextLine();
        }
    }

    public static void startGame(){
        boolean nameSet = false;
        String name;


        clearConsole();
        Separator(35);
        Separator(30);
        System.out.println("WELCOME TO HARRY POTTER AT HOME");
        System.out.println("ENJOY YOUR GAME");
        Separator(30);
        Separator(35);
        toContinue();

        do {
            clearConsole();
            System.out.println("Hagrid : You're a Wizard, insert your name!");
            name = scanner.next();
            clearConsole();
            System.out.println("Hagrid : You're Wizard name is "+ name + ".\nIs that correct? ");
            System.out.println("(1) Yes !");
            System.out.println("(2) No, I want to change my wizard name.");
            int input = readInt("->", 2);
            if(input == 1)
                nameSet = true;
        }while (!nameSet);

        Wizard wizard = new Wizard(name, 100, 1);
        wizard.setWand(20, Core.PHOENIX_FEATHER);
        /// fait un random number entre 1-4
        wizard.setHouse(SortingHat.randomHouse(( int) Math.random() * (4-1)));

        System.out.println("Storting Hat : Your are in the (" + wizard.getWizardHouse() + ") house");

        /// niveau 1 : Wingardium Leviosa seulement

        wizard.knownSpells.add(new Spell("Wingardium Leviosa", 75, 25));


        /// premier enemie qui spawn

        Enemy troll = new Enemy("Troll", 25, 150, Place.TOILET_OF_DUNGEON,1);
        //troll.attack(wizard);

        Enemy basilisk = new Enemy("Basilisk", 35, 250, Place.CHAMBER_SECRETS,2);
        Enemy dementor = new Enemy("Dementor", 50, 300, Place.FORBIDDEN_FOREST_LAKE,3);
        Enemy group1 = new Enemy("Voldemort and Peter Pettigrow", 80, 150, Place.GRAVEYARD_OF_LITTLE_HANGLETON,4);
        Enemy dolores = new Enemy("Dolores Ombrage", 25, 150, Place.EXAMEN_CLASS_OF_POUDLARD,5);
        Enemy deatheaters = new Enemy("Death Eaters", 100, 500, Place.ASTRONOMY_TOWER,6);
        Enemy groupe2 = new Enemy("Death Eaters", 100, 500, Place.POUDLARD,7);
    }



}