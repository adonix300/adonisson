import java.util.Scanner;

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

        label:
        while (true) {
            pole[y][x] = "X  ";
            Start m = new Start();
            m.printMap(pole);
            System.out.print("Введите букву: ");
            String move = s.nextLine();
            switch (move) {
                case "w":
                    if (y != 0) {
                        y--;
                    } else {
                        System.out.println("пошел нафиг!");
                    }

                    break;
                case "d":
                    if (x != n - 1) {
                        x++;
                    } else {
                        System.out.println("пошел нафиг!");
                    }
                    break;
                case "s":
                    if (y != n - 1) {
                        y++;
                    } else {
                        System.out.println("пошел нафиг!");
                    }
                    break;
                case "a":
                    if (x != 0) {
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