public class Spell {
    //// tableau de sort avec chacun leur pourcentage de réussite
    private String spellName;
    public int successChance;
    public int damage;

    public Spell(String spellName, int successChance, int damage){
        this.spellName = spellName;
        this.successChance = successChance;
        this.damage = damage;
    }

    public int getSpellDamageByHouseName(String houseName){
        if (houseName == "Slytherin") return damage + 10;
        if (houseName == "Gryffindor") return damage - 10;
        return damage;
    }

}
