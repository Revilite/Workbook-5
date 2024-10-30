public class Dog extends FarmAnimal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("I'm " + getName() + "! Slurp, Chomp. Sluurrp. !!!!");
    }
}
