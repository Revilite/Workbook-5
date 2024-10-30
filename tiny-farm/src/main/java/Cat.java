public class Cat extends FarmAnimal {

    public Cat(String name) {
        super(name);
    }

    @Override
     public void eat() {
        System.out.println("NOYB: Nibble. Nibble. Yum");
    }
}
