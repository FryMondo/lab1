import java.util.Arrays;

public class lab1 {
    public static void main(String[] args) {
        // Оголошення матриці типу short
        short[][] matrix = {
                {30, 25, 33, 92, 66},
                {60, 20, 11, 8, 3},
                {49, 37, 59, 14, 95},
                {35, 54, 95, 74, 11},
                {90, 20, 3, 32, 42}
        };

        try {
            // Валідація матриці
            validation.matrixValidation(matrix);
            // Виконання транспонування матриці та вивід транспонованої матриці
            short[][] transportedMatrix = transpose.transposeMatrix(matrix);
            System.out.println("Transposed Matrix:");
            print.printMatrix(transportedMatrix);

            // Виведення суми найбільших та найменших елементів
            System.out.println("Biggest number sum: " + sum.bigSmallSum(transportedMatrix, true));
            System.out.println("Smallest number sum: " + sum.bigSmallSum(transportedMatrix, false));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class validation {
    // Метод валідації матриці
    public static void matrixValidation(short[][] matrix) {
        // Перевірка чи масив не порожній та чи масив є матрицею
        if (matrix == null || matrix.length < 2 || matrix[0].length < 2) {
            throw new IllegalArgumentException("Incorrect matrix!");
        }

        // Перевірка чи рядки матриці рівні
        for (short[] row : matrix) {
            if (row.length != matrix[0].length) {
                throw new IllegalArgumentException("Incorrect matrix!");
            }
        }
    }
}

class transpose {
    // Метод транспонування матриці
    public static short[][] transposeMatrix(short[][] matrix) {
        // Створення матриці для транспонування
        short[][] transposedMatrix = new short[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // Перестановка елементів
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }
}

class sum {
    // Метод обчислення суми найбільших або найменших чисел у матриці
    public static int bigSmallSum(short[][] matrix, boolean findBiggest) {
        // Ініціалізація sum для знаходження суми
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0 && findBiggest) {
                // Знаходження найбільшого числа в рядках з парними індексами
                short biggest = matrix[i][0];
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] > biggest) {
                        // Запис найбільшого числа
                        biggest = matrix[i][j];
                    }
                }
                // Додавання найбільших елементів матриці
                sum += biggest;
            } else if (i % 2 != 0 && !findBiggest) {
                // Знаходження найменшого числа в рядках з непарними індексами
                short smallest = matrix[i][0];
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] < smallest) {
                        // Запис найменшого числа
                        smallest = matrix[i][j];
                    }
                }
                // Додавання найменших елементів матриці
                sum += smallest;
            }
        }
        return sum;
    }
}

class print {
    // Метод для виведення матриці
    public static void printMatrix(short[][] matrix) {
        // За допомогою циклу for each виводимо рядки
        for (short[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}