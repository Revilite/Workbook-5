
import java.util.ArrayList;

public class Farm {

    ArrayList<FarmAnimal> animals = new ArrayList<>();

    public void addAnimals(FarmAnimal a) {
        animals.add(a);
    }

    public void feedAnimals() {
        for (Animal a : animals) {
            a.eat();
        }
    }
}

