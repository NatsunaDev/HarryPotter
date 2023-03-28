package HarryPotter;

import java.util.ArrayList;

public class Wizard extends Character{

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

    public void setHouse(House randomHouse){
        this.house = randomHouse;
    }

    public String getWizardHouse(){
        return house.getHouseName();
    }

    public int wizardAttack(Spell spell){
        /// le sorcier attaque, en fonction de ses chances de réussite, soit il fait perdre des HP, soit il rate
        int chanceReussite = spell.successChance;
        int random = 55;
        if (random > chanceReussite){
            return attack(spell.damage);
        }
        return 0;
    }

}

