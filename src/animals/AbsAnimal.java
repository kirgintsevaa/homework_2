package animals;

public abstract class AbsAnimal {

    private String name;
    private int age;
    private int weight;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void say() {
        System.out.println("Я говорю!");
    }

    public void drink() {
        System.out.println("Я пью!");
    }

    public void eat() {
        System.out.println("Я ем!");
    }

    public void go() {
        System.out.println("Я иду!");
    }

    public String toString() {
        return String.format("\nПривет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s", name, age, getYearStringPadej(age), weight, color);
    }

    private String getYearStringPadej(int age) {
        if (age % 10 == 0 || age % 10 >= 5 || age >= 11 && age <= 19) {
            return "лет";
        }
        if (age % 10 == 1) {
            return "год";
        }
        return "года";
    }
}
