public class Main {
    public static void main(String[] args) {
        Farm f = new Farm();
        f.addAnimals(new Dog("Bernie"));
        f.addAnimals(new Cat("Puddles"));
        f.addAnimals(new Dog("Max"));
        f.addAnimals(new Dog("Dmitri"));

        f.feedAnimals();
    }
}
