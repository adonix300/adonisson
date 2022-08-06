import models.Boss;
import models.GameMap;
import models.Hero;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Введите число: ");

        int n = Integer.parseInt(s.nextLine());
        int bossX;
        int bossY;
        int lastHeroY;
        int lastHeroX;
        int lastBossY;
        int lastBossX;

        if (n % 2 == 0) {
            bossX = (n / 2) - (int) (Math.random() * 2);
            bossY = (n / 2) - (int) (Math.random() * 2);
        } else {
            bossX = n / 2;
            bossY = n / 2;
        }

        GameMap gameMap = new GameMap(n);
        Hero hero = new Hero(0, 0, "\u001B[32m" + "|X_" + "\u001B[0m", 20);
        Boss boss = new Boss(bossX, bossY, "\u001B[31m" + "|Y_" + "\u001B[0m", 15);
        String defaultCell = "|__";
        label:
        while (true) {

            gameMap.setValue(hero.getY(), hero.getX(), hero.getIcon());
            gameMap.setValue(boss.getY(), boss.getX(), boss.getIcon());

            gameMap.printMap();
            System.out.print("Введите букву: ");
            String move = s.nextLine();

            lastHeroY = hero.getY();
            lastHeroX = hero.getX();
            lastBossX = boss.getX();
            lastBossY = boss.getY();

            switch (move) {
                case "w":
                    if (hero.getY() != 0) {
                        gameMap.setValue(lastHeroY, lastHeroX, defaultCell);
                        gameMap.setValue(lastBossY, lastBossX, defaultCell);
                        hero.setY(hero.getY() - 1);
                        boss.moveBoss(n);
                    } else {
                        System.out.println("пошел нафиг!");
                    }

                    break;
                case "d":
                    if (hero.getX() != n - 1) {
                        gameMap.setValue(lastHeroY, lastHeroX, defaultCell);
                        gameMap.setValue(lastBossY, lastBossX, defaultCell);
                        hero.setX(hero.getX() + 1);
                        boss.moveBoss(n);
                    } else {
                        System.out.println("пошел нафиг!");
                    }
                    break;
                case "s":
                    if (hero.getY() != n - 1) {
                        gameMap.setValue(lastHeroY, lastHeroX, defaultCell);
                        gameMap.setValue(lastBossY, lastBossX, defaultCell);
                        hero.setY(hero.getY() + 1);
                        boss.moveBoss(n);
                    } else {
                        System.out.println("пошел нафиг!");
                    }
                    break;
                case "a":
                    if (hero.getX() != 0) {
                        gameMap.setValue(lastHeroY, lastHeroX, defaultCell);
                        gameMap.setValue(lastBossY, lastBossX, defaultCell);
                        hero.setX(hero.getX() - 1);
                        boss.moveBoss(n);
                    } else {
                        System.out.println("пошел нафиг!");
                    }
                    break;
                case "x":
                    System.out.println("пошел нафиг!");
                    break label;

                default:
                    System.out.println("пошел нафиг!");
                    break;
            }

            if (hero.getX() == boss.getX() && hero.getY() == boss.getY()) {
//                System.out.println("Победа!");
//                break;
                boss.setHealth(boss.getHealth() - (int) (Math.random() * 5));
                hero.setHealth(hero.getHealth() - (int) (Math.random() * 6));
                System.out.println("Жизни босса: " + boss.getHealth());
                System.out.println("Жизни героя: " + hero.getHealth());
            }

            if (boss.getHealth() <=0) {
                System.out.println("Победа!");
                break;
            } else if (hero.getHealth() <= 0) {
                System.out.println("Поражение!");
                break;
            }


        }
    }
}