import animals.AbsAnimal;
import data.AnimalTypeData;
import data.CommandsData;
import factories.AnimalFactory;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        ArrayList<AbsAnimal> animals = new ArrayList<>();
        CommandsData command = null;
        do {
            System.out.println("\nВведите одну из команд: \nadd  \tlist \texit");
            try {
                String commandCheck = scanner.next().toUpperCase();
                command = CommandsData.valueOf(commandCheck);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректная команда!");
            }
            switch (command) {
                case ADD: {
                    System.out.print("Вы ввели команду: " + CommandsData.ADD);
                    System.out.println("\nВведите тип животного: \ncat  \tdog \tduck");
                    String animalType = scanner.next().toUpperCase(Locale.ROOT).trim();
                    AnimalTypeData animalTypeData = AnimalTypeData.valueOf(animalType);
                    animals.add(fillAnimalData(animalTypeData));
                    animals.get(0).say();
                    animals.get(0).eat();
                    break;
                }

                case LIST: {
                    System.out.print("Вы ввели команду: " + CommandsData.LIST);
                    {
                        if (animals.size() == 0) {
                            System.out.println("\nВ списке пока нет животных");
                        } else {
                            for (int i = 0; i < animals.size(); i++) {
                                String result = animals.toString();
                                System.out.println(result);
                            }
                        }
                    }
                    break;
                }
                case EXIT: {
                    System.out.print("Вы ввели команду: " + CommandsData.EXIT);
                    break;
                }
            }
        } while (command != CommandsData.EXIT);
    }

    private static AbsAnimal fillAnimalData(AnimalTypeData animalTypeData) {

        AnimalFactory animalFactory = new AnimalFactory();
        AbsAnimal animal = animalFactory.create(animalTypeData);// создаем объект животного

        System.out.println("Как зовут животное?");
        animal.setName(scanner.next());

        System.out.println("Какой цвет у животного?");
        animal.setColor(scanner.next());

        System.out.println("Какой возраст у животного?");
        String ageStr = scanner.next();
        while (isNumber(ageStr)) {
            System.out.println("Введен неверный возраст");
            System.out.println("Повторите ввод");
            ageStr = scanner.next();
        }
        animal.setAge(Integer.parseInt(ageStr));

        System.out.println("Какой вес у животного?");
        String weightStr = scanner.next();
        while (isNumber(weightStr)) {
            System.out.println("Введен неверный вес");
            System.out.println("Повторите ввод");
            weightStr = scanner.next();
        }
        animal.setWeight(Integer.parseInt(weightStr));
        return animal;
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException ignoring) {
            return true;
        }
    }
}