package MATRIX;

class matrix{
    private double[][] data;
    private int rows;
    private int columns;

    // конструктор
    public matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    // сравнение с второй матрицей
    public matrix add(matrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Matrix dimensions must be the same for addition.");
        }

        matrix result = new matrix(this.rows, this.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    // умножение
    public matrix multiply(double scalar) {
        matrix result = new matrix(this.rows, this.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return result;
    }

    // умножение матриц
    public matrix multiply(matrix other) {
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
        }

        matrix result = new matrix(this.rows, other.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    // вывод
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // пример значений матриц
        matrix matrix1 = new matrix(2, 3);
        matrix1.data = new double[][]{{1, 2, 3}, {4, 5, 6}};

        matrix matrix2 = new matrix(2, 3);
        matrix2.data = new double[][]{{7, 8, 9}, {10, 11, 12}};

        // сложение
        matrix sum = matrix1.add(matrix2);
        System.out.println("Matrix Sum:");
        sum.print();

        // умножение на число
        matrix scaled = matrix1.multiply(2);
        System.out.println("\nMatrix Scaled by 2:");
        scaled.print();

        // умножение матриц
        matrix matrix3 = new matrix(3, 2);
        matrix3.data = new double[][]{{1, 2}, {3, 4}, {5, 6}};

        matrix product = matrix1.multiply(matrix3);
        System.out.println("\nMatrix Product:");
        product.print();
    }
}