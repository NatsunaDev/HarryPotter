public abstract class Character {
    public String name;
    public int hp, lvl;
    public Character(String name, int hp, int lvl) {
        this.name = name;
        this.hp = hp;
        this.lvl = lvl;
    }
    public void setHp(int amount, boolean damage){
        if(!damage) this.hp += amount;
        else this.hp -= amount;
    }

    public void usePotion(Potion potion, String houseName){
        setHp(potion.getHealthPointByHouseName(houseName), false);
    }
    public void takeDamage(int amount){
        /// ici tu peux check la maison et réduire le nombre de dommage si c'est Gryffindor
        setHp(amount, true);
    }

    public int attack(int damage){
        return damage;
    }


}