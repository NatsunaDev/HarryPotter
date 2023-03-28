package HarryPotter;

public class Potion {
    private String name;
    private int HealthPoint;

    public void setHealthPoint(int newHealthPoint){
        HealthPoint = newHealthPoint;
    }

    public int getHealthPointByHouseName(String houseName) {
        if (houseName == "Hufflepuff") {
            return HealthPoint + 10;
        }
        return HealthPoint;
    }
}
