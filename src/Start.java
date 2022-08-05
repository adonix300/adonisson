import models.Boss;
import models.Hero;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = Integer.parseInt(s.nextLine());
        String[][] pole = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pole[i][j] = "0  ";
            }
        }
        int bossX;
        int bossY;
        if (n % 2 == 0) {
            bossX = (n / 2) - (int) (Math.random() * 2);
            bossY = (n / 2) - (int) (Math.random() * 2);
        } else {
            bossX = n / 2;
            bossY = n / 2;
        }

        Hero hero = new Hero(0, 0, "X  ", 20);
        Boss boss = new Boss(bossX, bossY, "Y  ", 15);

        int lastHeroY;
        int lastHeroX;
        int lastBossY;
        int lastBossX;
        Start m = new Start();

        label:
        while (true) {

            pole[hero.getY()][hero.getX()] = "X  ";
            pole[boss.getY()][boss.getX()] = "Y  ";

            m.printMap(pole);
            System.out.print("Введите букву: ");
            String move = s.nextLine();

            lastHeroY = hero.getY();
            lastHeroX = hero.getX();
            lastBossX = boss.getX();
            lastBossY = boss.getY();

            switch (move) {
                case "w":
                    if (hero.getY() != 0) {
                        pole[lastHeroY][lastHeroX] = "0  ";
                        pole[lastBossY][lastBossX] = "0  ";
                        hero.setY(hero.getY() - 1);
                        m.moveBoss(boss, n);
                    } else {
                        System.out.println("пошел нафиг!");
                    }

                    break;
                case "d":
                    if (hero.getX() != n - 1) {

                        pole[lastHeroY][lastHeroX] = "0  ";
                        pole[lastBossY][lastBossX] = "0  ";
                        hero.setX(hero.getX() + 1);
                        m.moveBoss(boss, n);
                    } else {
                        System.out.println("пошел нафиг!");
                    }
                    break;
                case "s":
                    if (hero.getY() != n - 1) {
                        pole[lastBossY][lastBossX] = "0  ";
                        pole[lastHeroY][lastHeroX] = "0  ";
                        hero.setY(hero.getY() + 1);
                        m.moveBoss(boss, n);
                    } else {
                        System.out.println("пошел нафиг!");
                    }
                    break;
                case "a":
                    if (hero.getX() != 0) {
                        pole[lastBossY][lastBossX] = "0  ";
                        pole[lastHeroY][lastHeroX] = "0  ";
                        hero.setX(hero.getX() - 1);
                        m.moveBoss(boss, n);
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
                System.out.println("Победа!");
                break;
            }
        }
    }

    public void printMap(String[][] pole) {

        for (String[] strings : pole) {

            for (int j = 0; j < pole.length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }

    }

    public void moveBoss(Boss boss, int n) {
        boolean isMoved = false;
        while (!isMoved) {
            int x = boss.getX() + (int) ((Math.random() * 4) - 2);
            int y = boss.getY() + (int) ((Math.random() * 4) - 2);
            if (y < n && y > 0 && x < n && x > 0) {
                isMoved = true;
                boss.setX(x);
                boss.setY(y);
            }
        }


    }


}