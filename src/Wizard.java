import java.util.ArrayList;
import java.util.Random;

public class Wizard extends Character {

    public Pet pet;
    private Wand wand;
    private House house;
    ArrayList<Spell> knownSpells = new ArrayList<>();

    public Wizard(String name, int hp, int level) {
        super(name, hp, level);
    }

    public void setWand(int size, Core core){
        this.wand = new Wand(size, core);
    }

    public Wand getWand() {return wand;}

    public void setHouse(House randomHouse){
        this.house = randomHouse;
    }

    public String getWizardHouse(){
        return house.getHouseName();
    }

    public int wizardAttack(Spell spell){

        /// le sorcier attaque, en fonction de ses chances de réussite, soit il fait perdre des HP, soit il rate
        int chanceReussite = spell.successChance;
        int random = new Random().nextInt(100-1+1)+1;
        if (random < chanceReussite){
            return attack(spell.damage);
        }
        return 0;
    }

    Pet[] allPet = Pet.values();
    Pet randomPet = randomElement(allPet);
    private Pet randomElement(Pet[] allPet) {
            return randomPet;
    }
}

enum Pet {
    OWL,
    RAT,
    CAT,
    TOAD
}



