import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);

        int rows = request_validation.InputNum("Введите количество строк поля. ", iScanner);
        int columns = request_validation.InputNum("Введите количество столбцов поля. ", iScanner);
        int walls = request_validation.InputNum("Введите количество стен. ", iScanner);
        while (!request_validation.NumberWalls(rows, columns, walls)) {
            System.out.println("Количество стен превышает количество ячеек.");
            System.out.printf("Количество стен должно быть в диапазоне от 0 до %d.\n", rows * columns - 2);
            walls = request_validation.InputNum("Введите количество стен: ", iScanner);
        }

        int startRow = request_validation.InputNum("Введите индекс строки старта. ", iScanner);
        while (!request_validation.IsRigthIndex(startRow, rows)) {
            System.out.println("Номер строки не может быть больше количества строк.");
            System.out.printf("Введите число от 1 до %d.\n", rows);
            startRow = request_validation.InputNum("Введите номер строки: ", iScanner);
        }

        int startColumn = request_validation.InputNum("Введите индекс столбца старта. ", iScanner);
        while (!request_validation.IsRigthIndex(startColumn, columns)) {
            System.out.println("Номер столбца не может быть больше количества столбцов.");
            System.out.printf("Введите число от 1 до %d.\n", columns);
            startColumn = request_validation.InputNum("Введите номер столбца: ", iScanner);
        }

        int finishRow = request_validation.InputNum("Введите индекс строки финиша. ", iScanner);
        while (!request_validation.IsRigthIndex(finishRow, rows)) {
            System.out.println("Номер строки не может быть больше количества строк.");
            System.out.printf("Введите число от 1 до %d.\n", rows);
            finishRow = request_validation.InputNum("Введите номер строки: ", iScanner);
        }

        int finishColumn = request_validation.InputNum("Введите индекс столбца финиша. ", iScanner);
        while (!request_validation.IsRigthIndex(finishColumn, columns)) {
            System.out.println("Номер столбца не может быть больше количества столбцов.");
            System.out.printf("Введите число от 1 до %d.\n", rows);
            finishColumn = request_validation.InputNum("Введите номер столбца: ", iScanner);
        }

        iScanner.close();

        int[][] field = methods.CreateField(rows, columns);
        methods.BuildingWalls(field, walls);

        field[startRow][startColumn] = 1;
        field[finishRow][finishColumn] = -2;

        int[] finish = new int[]{finishRow, finishColumn};

        int step = methods.DrawRoutes(field);
        System.out.println();

        if (request_validation.IsRoute(field, finish)) {
            int[][] coordinates = methods.WritingRoute(field, finish, step);
            methods.ReverseArray(coordinates);
            System.out.println();
            System.out.println("Пошаговый маршрут c координатами каждой точки: ");
            methods.Show2dArrayWith2Col(coordinates);
            System.out.println();
            methods.ElementsColoring(field, coordinates);
        } else {
            common_methods.Show2dArray(field);
            System.out.println("Построить маршрут невозможно.");
        }
    }

}

