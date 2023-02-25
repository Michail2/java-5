import java.util.Scanner;

public class request_validation {
    static int InputNum(String msg, Scanner scanner) {
        int num;
        System.out.print(msg);
        do {
            System.out.println("Ожидание ввода...");
            while (!scanner.hasNextInt()) {
                System.out.println("Введите натуральное число: ");
                scanner.next();
            }
            num = scanner.nextInt();
        } while (num <= 0);
        return num;
    }

    static Boolean NumberWalls(int rows, int columns, int walls) {
        return walls <= rows * columns - 2;
    }

    static Boolean IsRoute(int[][] array, int[] finish) {
        return array[finish[0] + 1][finish[1]] > 0 || array[finish[0] - 1][finish[1]] > 0
                || array[finish[0]][finish[1] + 1] > 0 || array[finish[0]][finish[1] - 1] > 0;
    }

    static Boolean IsRigthIndex(int index, int size){
        return index <= size;
    }
}