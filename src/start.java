import java.util.Scanner;

public class start {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = s.nextInt();

        for (int i = 0; i <n; i++) {

            for (int j = 0; j < n;j++ ) {
                System.out.print(0);
            }
            System.out.println();
        }

    }
}