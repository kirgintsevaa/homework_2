package animals.pets;

import animals.AbsAnimal;

public class Cat extends AbsAnimal {

    public Cat() {

    }

    public void say() {
        System.out.println("\nМяу!");
    }

    public void eat() {
        System.out.println("\nЯ ем рыбку");
    }
}