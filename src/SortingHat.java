package HarryPotter;

public class SortingHat {

    public static House randomHouse(int randomNumber){
        if (randomNumber == 1) {
            return new House("Hufflepuff");
        }
        else if(randomNumber == 2) {
            return new House("Slytherin");
        }
        else if(randomNumber == 3) {
            return new House("Gryffindor");
        }
        else {
            return new House("Ravenclaw");
        }
    }

}
