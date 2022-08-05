import java.util.Objects;
import java.util.Scanner;
import java.lang.Math;

public class Start {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);


        System.out.print("Введите число: ");
        int n = Integer.parseInt(s.nextLine());
        String[][] pole = new String[n][n];

        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n;j++ ) {
                pole[i][j] = "0  ";
            }
        }
        int x = 0;
        int y = 0;
        int a;
        int b;
        int bossX;
        int bossY;

        if (n%2==0) {

            bossX = (n /2)-(int) (Math.random()*2);
            bossY = (n /2)-(int) (Math.random()*2);
        } else {
            bossX = n /2;
            bossY = n/2;
        }

        label:
        while (true) {
            pole[y][x] = "X  ";
            pole[bossY][bossX] = "Y  ";
            Start m = new Start();
            m.printMap(pole);
            System.out.print("Введите букву: ");
            String move = s.nextLine();
            switch (move) {
                case "w":
                    if (y != 0) {
                        a = y;
                        b = x;
                        pole[a][b] = "0  ";
                        y--;
                    } else {
                        System.out.println("пошел нафиг!");
                    }

                    break;
                case "d":
                    if (x != n - 1) {
                        b=x;
                        a = y;
                        pole[a][b] = "0  ";
                        x++;

                    } else {
                        System.out.println("пошел нафиг!");
                    }
                    break;
                case "s":
                    if (y != n - 1) {
                        a = y;
                        b = x;
                        pole[a][b] = "0  ";
                        y++;
                    } else {
                        System.out.println("пошел нафиг!");
                    }
                    break;
                case "a":
                    if (x != 0) {
                        b = x;
                        a = y;
                        pole[a][b] = "0  ";
                        x--;
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
            if (Objects.equals(pole[y][x], pole[bossY][bossX])) {
                pole[y][x] = "X  ";
                System.out.println("Победа!");
                break;
            }
        }
    }

    public void printMap(String[][] pole){

        for (String[] strings : pole) {

            for (int j = 0; j < pole.length; j++) {
                System.out.print(strings[j]);
            }
            System.out.println();
        }

    }

}