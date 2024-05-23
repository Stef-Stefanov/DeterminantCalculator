import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MatrixDeterminant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the path to the matrix file:");
        String filePath = scanner.nextLine();

        try {
            double[][] matrix = readMatrixFromFile(filePath);
            if (matrix != null) {
                double determinant = calculateDeterminant(matrix);
                System.out.println("The determinant of the matrix is: " + determinant);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Reads a square matrix from a file.
     * @param filePath the path to the file containing the matrix
     * @return a 2D array representing the matrix
     * @throws IOException if there is an error reading the file
     * @throws NumberFormatException if there is an error in the matrix format
     */
    public static double[][] readMatrixFromFile(String filePath) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();
        if (line == null) {
            throw new NumberFormatException("File is empty");
        }

        int n = Integer.parseInt(line.trim());
        double[][] matrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            if (line == null) {
                throw new NumberFormatException("Not enough rows in the file");
            }

            String[] tokens = line.trim().split("\\s+");
            if (tokens.length != n) {
                throw new NumberFormatException("Not enough columns in row " + (i + 1));
            }

            for (int j = 0; j < n; j++) {
                matrix[i][j] = Double.parseDouble(tokens[j]);
            }
        }

        br.close();
        return matrix;
    }

    /**
     * Calculates the determinant of a square matrix.
     * @param matrix the matrix
     * @return the determinant
     */
    public static double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double determinant = 0;
        for (int j1 = 0; j1 < n; j1++) {
            double[][] minor = new double[n - 1][];
            for (int k = 0; k < (n - 1); k++) {
                minor[k] = new double[n - 1];
            }

            for (int i = 1; i < n; i++) {
                int j2 = 0;
                for (int j = 0; j < n; j++) {
                    if (j == j1)
                        continue;
                    minor[i - 1][j2] = matrix[i][j];
                    j2++;
                }
            }
            determinant += Math.pow(-1.0, j1) * matrix[0][j1] * calculateDeterminant(minor);
        }
        return determinant;
    }
}
