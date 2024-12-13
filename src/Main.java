import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в программу создания коробки сладостей!");
        greetAndChooseOption();
        var bx = createOrChoseBox();
        optimization(bx);
    }

    public static void greetAndChooseOption() {
        System.out.println("""
                Пожалуйста, введите 1, если вы хотите продолжить, или 0, если хотите завершить программу.
                Мой выбор:""");
        Scanner input = new Scanner(System.in);

        try {
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("Вы выбрали продолжить программу.");
            } else if (choice == 0) {
                System.out.println("Спасибо за использование программы!");
                System.exit(0);
            } else {
                System.out.println("Вы ввели неверное значение. Пожалуйста, попробуйте еще раз.");
                greetAndChooseOption();
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели неверное значение. Пожалуйста, попробуйте еще раз.");
            input.next();
            greetAndChooseOption();
        }
    }

    public static BoxOfSweets createOrChoseBox() {
        BoxOfSweets gift1 = new BoxOfSweets()
                .addSweet(new BlackChocolate())
                .addSweet(new MilkChocolate())
                .addSweet(new Caramel())
                .addSweet(new Caramel())
                .addSweet(new BlackChocolate())
                .addSweet(new MilkChocolate())
                .addSweet(new Caramel())
                .addSweet(new Caramel());
        BoxOfSweets gift2 = new BoxOfSweets()
                .addSweet(new BlackChocolate())
                .addSweet(new MilkChocolate())
                .addSweet(new Lollipop())
                .addSweet(new Caramel())
                .addSweet(new Lollipop())
                .addSweet(new MilkChocolate())
                .addSweet(new Caramel());
        BoxOfSweets gift3 = new BoxOfSweets()
                .addSweet(new Lollipop())
                .addSweet(new Caramel())
                .addSweet(new Lollipop())
                .addSweet(new Caramel())
                .addSweet(new Lollipop())
                .addSweet(new MilkChocolate())
                .addSweet(new Caramel());
        System.out.println("Выберете коробку");
        System.out.println("""
                1. Коробка 1
                2. Коробка 2
                3. Коробка 3
                4. Добавить самостоятельно
                """);
        var chosenBox = new BoxOfSweets();
        try {
        Scanner input = new Scanner(System.in);

        int choice = input.nextInt();
        if (choice == 1) {
            chosenBox = gift1;
            chosenBox.displayInformation();
        } else if (choice == 2) {
            chosenBox = gift2;
            chosenBox.displayInformation();
        } else if (choice == 3) {
            chosenBox = gift3;
            chosenBox.displayInformation();
        } else if (choice == 4) {
            System.out.println("Создание коробки сладостей");
            chosenBox = createBox();
            chosenBox.displayInformation();
        } else {
            System.out.println("Вы ввели неверное значение. Пожалуйста, попробуйте еще раз.");
            createOrChoseBox();
        }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели неверное значение. Пожалуйста, попробуйте еще раз.");
            createOrChoseBox();
        }
        return chosenBox;
    }

    public static BoxOfSweets createBox() {
        var box = new BoxOfSweets();
        Scanner input1 = new Scanner(System.in);
        int choice1;
        while (true) {
            try {
                System.out.println("Сколько леденцов добавить?");
                choice1 = input1.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите число.");
                input1.next();
            }
        }
        for (int i = 0; i < choice1; i++) {
            box.addSweet(new Lollipop());
        }

        Scanner input2 = new Scanner(System.in);
        int choice2;
        while (true) {
            try {
                System.out.println("Сколько карамели добавить?");
                choice2 = input2.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите число.");
                input2.next();
            }
        }
        for (int i = 0; i < choice2; i++) {
            box.addSweet(new Caramel());
        }

        Scanner input3 = new Scanner(System.in);
        int choice3;
        while (true) {
            try {
                System.out.println("Cколько чёрного шоколада добавить?");
                choice3 = input3.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите число.");
                input3.next(); // Clear the invalid input
            }
        }
        for (int i = 0; i < choice3; i++) {
            box.addSweet(new BlackChocolate());
        }

        Scanner input4 = new Scanner(System.in);
        int choice4;
        while (true) {
            try {
                System.out.println("Cколько молочного шоколада добавить?");
                choice4 = input4.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите число.");
                input4.next();
            }
        }
        for (int i = 0; i < choice4; i++) {
            box.addSweet(new MilkChocolate());
        }
        return box;
    }

    public static void optimizeBoxByWeight(BoxOfSweets box, Double d) {
        if (box.getTotalWeight() > d) {
            System.out.println("Коробка слишком тяжелая. Удаляем самую легкую сладость.");
            box.removeLowestWeightSweet();
            optimizeBoxByWeight(box, d);
        } else {
            System.out.println("Коробка оптимизирована.");
        }
    }

    public static void optimizeBoxByPrice(BoxOfSweets box, Double d) {

        if (box.getTotalPrice() > d) {
            System.out.println("Коробка слишком дорогая. Удаляем самую дешёвую сладость.");
            box.removeLowestPriceSweet();
            optimizeBoxByPrice(box, d);
        } else {
            System.out.println("Коробка оптимизирована.");
        }
    }

    public static void optimization(BoxOfSweets bx) {
        System.out.println("""
                Если вас не устраивает коробка сладостей, вы можете ее оптимизировать.
                1. Оптимизировать по весу
                2. Оптимизировать по цене
                3. Выйти из программы
                """);
        Scanner way = new Scanner(System.in);

        try {
            int choice = way.nextInt();

            if (choice == 1) {

                System.out.println("Введите максимальный вес коробки:");
                Scanner weight = new Scanner(System.in);
                double d = weight.nextDouble();
                if (d <= bx.getHighestWeightSweet()){
                    System.out.println();
                    System.out.println("Вес коробки не может быть меньше или равен весу самой тяжелой конфеты - " + bx.getHighestWeightSweet() + " .");
                    optimization(bx);
                }
                if (d >= bx.getTotalWeight()){
                    System.out.println("Коробка и так подходит по весу");
                    optimization(bx);
                }
                optimizeBoxByWeight(bx, d);
                bx.displayInformation();
                System.out.println("Спасибо за ваш выбор!");
            } else if (choice == 2) {
                System.out.println("Введите максимальную цену коробки:");
                Scanner weight = new Scanner(System.in);
                double d = weight.nextDouble();
                if (d <= bx.getHighestPriceSweet()){
                    System.out.println("Цена коробки не может быть меньше или равна цене самой дорогой конфеты - " + bx.getHighestPriceSweet() + " .");
                    optimization(bx);
                }
                if (d >= bx.getTotalPrice()){
                    System.out.println("Коробка и так укладывается в ваш бюджет");
                    optimization(bx);
                }
                optimizeBoxByPrice(bx, d);
                bx.displayInformation();
                System.out.println("Спасибо за ваш выбор!");
            } else if (choice == 3) {
                System.out.println("Спасибо за использование программы!");
                System.exit(0);
            } else {
                System.out.println("Вы ввели неверное значение. Пожалуйста, попробуйте еще раз.");
                optimization(bx);
            }
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели неверное значение. Пожалуйста, попробуйте еще раз.");
            optimization(bx);
        }
    }
}