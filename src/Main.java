import animals.AbsAnimal;
import data.AnimalTypeData;
import data.CommandsData;
import factories.AnimalFactory;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String command;
    static String type;
    static String name, color;
    static Integer age, weight;

    public static void main(String... args) {
       //commandsMenu();
        ArrayList<AbsAnimal> animals = new ArrayList<>();
       // ArrayList<AbsAnimal> animals = new ArrayList<AbsAnimal>();
        //Animal.add("CAT");
        //Animal.add("DOG");
       // Animal.add("DUCK");

        // CommandsData commandsData = CommandsData.ADD;
        // commandsData.name().toLowerCase(Locale.ROOT).trim();
        //AbsAnimal animal = fillAnimalData(AnimalTypeData.CAT);
//    }

   // public static void commandsMenu() {
        do {
            System.out.println("\nВведите одну из команд: \nadd  \tlist \texit");
            command = scanner.nextLine().toLowerCase().trim();

            switch (command) {
                case "add":
                    System.out.print("Вы ввели команду: " + CommandsData.ADD);
                    animals.add(create());
                    animals.get(animals.size()-1).say();
                    break;

                case "list":
                    System.out.print("Вы ввели команду: " + CommandsData.LIST);
                    {
                    if (animals.size() == 0) {
                        System.out.println("\nВ списке пока нет животных");
                    } else for (AbsAnimal animal_i: animals) System.out.println(animal_i);}
                    break;

                case "exit":
                    System.out.print("Вы ввели команду: " + CommandsData.EXIT);
                    break;
            }
        } while (!command.equals("exit"));
    }

    private static AbsAnimal create() {
        System.out.println("\nВведите тип животного: \ncat  \tdog \tduck");
        AnimalTypeData type = AnimalTypeData.valueOf(scanner.nextLine().toLowerCase().trim());
        return fillAnimalData(type);
    }
   /* public static void animalTypes() {
       AbsAnimal my_animal = null;
        do {
            System.out.println("\nВведите тип животного: \ncat  \tdog \tduck");
            type = scanner.nextLine();

            switch (type) {
                case "cat":
                    AbsAnimal animal = fillAnimalData(AnimalTypeData.CAT);
                    AbsAnimal Cat = fillAnimalData(AnimalTypeData.CAT);
                    animal = new Cat(name, color, age, weight);
                    animal.say();
                    break;

                case "dog":
                    AbsAnimal Dog = fillAnimalData(AnimalTypeData.DOG);
                    my_animal = new Dog(name, color, age, weight);
                    my_animal.say();
                    break;

                case "duck":
                    AbsAnimal Duck = fillAnimalData(AnimalTypeData.DUCK);
                    my_animal = new Duck(name, color, age, weight);
                    my_animal.say();
                    break;
            }
        } while (!command.equals("exit"));
    }*/

    private static AbsAnimal fillAnimalData(AnimalTypeData animalTypeData) {

        AnimalFactory animalFactory = new AnimalFactory();
        AbsAnimal animal = animalFactory.create(animalTypeData);// создаем объект животного

        ArrayList<String> animals = new ArrayList<>();

        System.out.println("Как зовут животное?");
        animal.setName(scanner.next());
        animals.add(name);

        System.out.println("Какой цвет у животного?");
        animal.setColor(scanner.next());
        animals.add(color);


        System.out.println("Какой возраст у животного?");
        String ageStr = scanner.next();
        while (!isNumber(ageStr)) {
            System.out.println("Введен неверный возраст");
            System.out.println("Повторите ввод");
            ageStr = scanner.next();
        }

        animal.setAge(Integer.parseInt(ageStr));
        animals.add(ageStr);


        System.out.println("Какой вес у животного?");
        String weightStr = scanner.next();
        while (!isNumber(weightStr)) {
            System.out.println("Введен неверный вес");
            System.out.println("Повторите ввод");
            weightStr = scanner.next();
        }
        animal.setWeight(Integer.parseInt(weightStr));
        animals.add(weightStr);

        animals.add(String.valueOf(animal));
        return animal;
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ignoring) {
            return false;
        }
    }
}