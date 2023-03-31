import java.util.Random;
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

    public static void fight(Wizard wizard, Enemy enemyName) {
        int wizardAttack;
        int enemyAttack;
        int input = 0;
        do {
            System.out.println("Quelle attaque souhaitez vous utilisez");
            System.out.println("Vos attaques disponible : ");
            int numOfQuestion = 1;
            int numOfIndex = 0;
            for (int i = 0; i < wizard.knownSpells.size(); i++) {
                System.out.println("(" + numOfQuestion + ") " + wizard.getSpellName(wizard.knownSpells.get(numOfIndex)));
                numOfQuestion++;
                numOfIndex++;
            }
            //On peut ajouter l'option de prendre une potion ici
            input = readInt("->", numOfQuestion);
            int selection = input-1;
            clearConsole();
            System.out.println("You use "+ wizard.getSpellName(wizard.knownSpells.get(selection)));
            Separator(30);
            toContinue();
            wizardAttack = wizard.wizardAttack(wizard.knownSpells.get(selection));
            if (wizardAttack > 0){
                /// l'enemie perd des points de vies
                enemyName.setHp(wizardAttack, true);
                System.out.println("Votre attack a touché, il reste lui " + enemyName.hp + "");
            }
            else {
                System.out.println("Votre attack a échoué");
            }
            System.out.println(enemyName.name+ " vous attaque !");
            enemyAttack = enemyName.attack(enemyName.getDamage());
            wizard.setHp(enemyAttack, true);
            System.out.println("Il vous reste "+ wizard.hp + "hp");
            if(wizard.getWizardHouse() == "Gryffindor"){
                wizard.hp += 25;
                System.out.println("Grace a votre maison l'attaque de l'ennemie est de 25 hp moins efficace");
                System.out.println("Vous restez donc à " + wizard.hp + "hp");
            }
        }
        while (wizard.hp > 0 && enemyName.hp > 0);
        if(wizard.hp > 0) {
            System.out.println("Vous avez gagné !");
            Separator(16);
            toContinue();
            clearConsole();
            wizard.lvl = wizard.lvl+1;
            Separator(24);
            Separator(24);
            System.out.println("Vous passez au niveau " + wizard.lvl);
            Separator(24);
            Separator(24);
        }else {
            System.out.println("YOU ARE DEAD...");
            System.exit(1); // Vous etes mort}
        }
    }

    /*public static void takeAChoice() {
        System.out.println("What do you want to do ?");
        System.out.println("(1) Attack !");
        System.out.println("(2) Take a potion.");
        System.out.println("(3) Surrender !");
        int input = readInt("->", 3);
        if(input == 1){
            fight();
        } else if (input == 2) {
            takeAPotion();
        }else {
            System.out.println("You surrend..");
        System.exit(2); // Status 2 :Vous avez abondonner fin du programme
        }


    }*/


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
        wizard.setWand(wizard.getWand().randomSize(), wizard.getWand().randomCore());
        wizard.setPet(wizard.getPet());
        /// fait un random number entre 1-4
        wizard.setHouse(SortingHat.randomHouse((int) ((Math.random()*(4-1))+1)));

        System.out.println("Storting Hat : Your are in the (" + wizard.getWizardHouse() + ") house");
        System.out.println("Storting Hat : Your have the (" + wizard.getWand().getSize() + "cm) of (" + wizard.getWand().getCore() + ") wand");
        System.out.println("Storting Hat : You have a (" + Wizard.randomPet() + ") house");
        Separator(50);
        toContinue();
        /// niveau 1 : Wingardium Leviosa seulement
        wizard.knownSpells.add(new Spell("Wingardium Leviosa", 75, 150));
        wizard.knownSpells.add(new Spell("Expelliarmus", 55, 25));
        /// premier enemie qui spawn
        Enemy troll = new Enemy("Troll", 25, 150, Place.TOILET_OF_DUNGEON,1);

        System.out.println("Un troll a spawn, il a " + troll.hp + "hp !! Quelle attaque souhaitez vous utilisez");
/*        System.out.println("Vos attaques disponible : ");


        int wizardAttack;
        int trollAttack;

        /// le combat se déroule tant que les perso ont encore des HP
        /// a mettre dans une fonction fight qui prend en paramètre les 2 personnages
        do {
            System.out.println("Vous attaquez !");
            wizardAttack = wizard.wizardAttack(wizard.knownSpells.get(0));
            if (wizardAttack > 0){
                /// le troll perd des points de vies
                troll.setHp(wizardAttack, true);
                System.out.println("Votre attack a touché, il reste " + troll.hp + "hp au troll");
            }
            else {
                System.out.println("Votre attack a échoué");
            }
            System.out.println("Le troll vous attaque !");
            trollAttack = troll.attack(10);
            wizard.setHp(trollAttack, true);
        }
        while (wizard.hp > 0 && troll.hp > 0);
*/
        //Zone de test

        fight(wizard,troll);


        if(wizard.getWizardHouse()=="Gryffindor")
        {
            wizard.knownSpells.add(new Spell("Sword", 70, 400));
        }else
            wizard.knownSpells.add(new Spell("Accio", 70, 200));
        System.out.println("Congratulation you have a new spell(" + wizard.getSpellName(wizard.knownSpells.get(3))+") !" );
        Separator(50);
        Enemy basilisk = new Enemy("Basilisk", 35, 250, Place.CHAMBER_SECRETS,2);
        System.out.println("Un Basilisk a spawn, il a " + basilisk.hp + "hp !! Quelle attaque souhaitez vous utilisez");
        fight(wizard,basilisk);

        wizard.knownSpells.add(new Spell("Expecto Patronum", 70, 200));
        System.out.println("Congratulation you have a new spell(" + wizard.getSpellName(wizard.knownSpells.get(4)) +") !" );
        Separator(50);
        Enemy dementor = new Enemy("Dementor", 50, 300, Place.FORBIDDEN_FOREST_LAKE,3);
        System.out.println("Dementor a spawn, il a " + dementor.hp + "hp !! Quelle attaque souhaitez vous utilisez");
        fight(wizard,dementor);



        Enemy group1 = new Enemy("Voldemort and Peter Pettigrow", 80, 150, Place.GRAVEYARD_OF_LITTLE_HANGLETON,4);
        System.out.println("Voldemort and Peter Pettigrow on spawn, il a " + group1.hp + "hp !! Quelle attaque souhaitez vous utilisez");
        fight(wizard,group1);

        Enemy dolores = new Enemy("Dolores Ombrage", 25, 150, Place.EXAMEN_CLASS_OF_POUDLARD,5);
        System.out.println("Dolores Ombrage a spawn, il a " + dolores.hp + "hp !! Quelle attaque souhaitez vous utilisez");
        fight(wizard,dolores);

        Enemy deatheaters = new Enemy("Death Eaters", 100, 500, Place.ASTRONOMY_TOWER,6);
        System.out.println("Death Eaters sont la " + deatheaters.hp + "hp !! Quelle attaque souhaitez vous utilisez");
        fight(wizard,deatheaters);

        Enemy groupe2 = new Enemy("Voldemort and Bellatrix Lestrange", 100, 500, Place.POUDLARD,7);
        System.out.println("Voldemort and Bellatrix Lestrange sont la" + groupe2.hp + "hp !! Quelle attaque souhaitez vous utilisez");
        fight(wizard,groupe2);


        System.out.println("You finish the game ! Congratulation  ");
        /// lister attaques disponibles par rapport au level avec une boucle for
        /// Augmenter le level du personnage et lui ajouter un sort dans le tableau knowSpell (wizard.knowSpell.add(...))













    }



}