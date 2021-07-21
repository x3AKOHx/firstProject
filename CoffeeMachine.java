package machine;

import java.util.Scanner;

class CoffeeMachine {
    int water = 400;
    int milk = 540;
    int beans = 120;
    int money = 550;
    int cups = 9;

    public void action() {
        boolean isTrue = true;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();

            switch (a) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                            "back - to main menu:");
                    String b = sc.nextLine();
                    switch (b) {
                        case "1":
                            espressoCheck();
                            break;
                        case "2":
                            latteCheck();
                            break;
                        case "3":
                            cappuccinoCheck();
                            break;
                        default:
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    int c = sc.nextInt();
                    this.water += c;
                    System.out.println("Write how many ml of milk you want to add:");
                    int d = sc.nextInt();
                    this.milk += d;
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int e = sc.nextInt();
                    this.beans += e;
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    int f = sc.nextInt();
                    this.cups += f;
                    break;
                case "take":
                    System.out.println("I gave you " + "$" + this.money);
                    this.money = 0;
                    break;
                case "remaining":
                    resources();
                    break;
                case "exit":
                    isTrue = false;
                    break;
            }
        } while (isTrue);
    }

    public void resources() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public void espressoCheck() {
        if (water < 250)
            System.out.println("Sorry, not enough water!");
        else if (beans < 16)
            System.out.println("Sorry, not enough coffee beans!");
        else if (cups == 0)
            System.out.println("Sorry, not enough disposable cups!");
        else {
            water -= 250;
            beans -= 16;
            money += 4;
            cups--;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public void latteCheck() {
        if (water < 350)
            System.out.println("Sorry, not enough water!");
        else if (milk < 75)
            System.out.println("Sorry, not enough milk!");
        else if (beans < 20)
            System.out.println("Sorry, not enough coffee beans!");
        else if (cups == 0)
            System.out.println("Sorry, not enough disposable cups!");
        else {
            water -= 350;
            milk -= 75;
            beans -= 20;
            money += 7;
            cups--;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    public void cappuccinoCheck() {
        if (water < 200)
            System.out.println("Sorry, not enough water!");
        else if (milk < 100)
            System.out.println("Sorry, not enough milk!");
        else if (beans < 12)
            System.out.println("Sorry, not enough coffee beans!");
        else if (cups == 0)
            System.out.println("Sorry, not enough disposable cups!");
        else {
            water -= 200;
            milk -= 100;
            beans -= 12;
            money += 6;
            cups--;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }


    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.action();
    }
}