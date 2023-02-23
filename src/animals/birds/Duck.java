package animals.birds;

import animals.AbsAnimal;

public class Duck extends AbsAnimal implements IFlying{

    public void fly(){
        System.out.println("\nЯ лечу!");
    }
    public void say() {
        System.out.println("\nКря!");
    }
}
