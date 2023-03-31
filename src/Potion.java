public class Potion {
    private String name;
    private int HealthPoint;

    public void setHealthPoint(int newHealthPoint){
        HealthPoint = newHealthPoint;
    }

    public int getHealthPointByHouseName(String houseName) {
        if (houseName == "Hufflepuff") {
            System.out.println("Grace a votre maison vos potions sont plus efficaces");
            return HealthPoint + 100;
        }
        return HealthPoint +25;
    }
}
