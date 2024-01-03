class Matrix {
    double[][] elements;
    int rows;
    int columns;
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        elements = new double[rows][columns];
    }
    public Matrix(double[][] elements) {
        this.rows = elements.length;
        this.columns = elements[0].length;
        this.elements = elements;
    }
    public Matrix add(Matrix other) {
        // Проверяем, имеют ли матрицы одинаковые размеры
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Несоответствующие размеры матриц");
        }

        // Создаем новую матрицу для результата
        Matrix result = new Matrix(rows, columns);

        // Складываем соответствующие элементы
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.elements[i][j] = elements[i][j] + other.elements[i][j];
            }
        }

        return result;
    }
    public Matrix multiply(double number) {
        // Создаем новую матрицу для результата
        Matrix result = new Matrix(rows, columns);

        // Умножаем каждый элемент на число
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.elements[i][j] = elements[i][j] * number;
            }
        }

        return result;
    }
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
    }

}
