package pl.polsl.aleksander.mekail.view;

import pl.polsl.aleksander.mekail.exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * View class handling UI
 *
 * @author Aleksander Mekail
 * @version 2.0
 */
public class View {
    /**
     * Read the size of the matrix (2 means 2x2 3 means 3x3 etc.).
     * Scanner used for reading from standard input stream
     * @return matrix size
     * @throws InputMismatchException thrown if the given value is not an integer.
     * @throws NegativeNumberException thrown if the given value is negative.
     */
    public int readMatrixSize() throws InputMismatchException, NegativeNumberException {
        Scanner scanner = new Scanner(System.in);
        int matrixSize;
        System.out.println("Please specify the size of the symmetrical matrix");
        matrixSize = scanner.nextInt();
        if (matrixSize < 1) {
            throw new NegativeNumberException("You can't input a negative value");
        } else
            return matrixSize;
    }

    /**
     * Reads the values of the matrix input by the user.
     * Scanner used for reading from standard input stream
     * @param row    states the rows index.
     * @param column states the column index.
     * @return matrix
     * @throws InputMismatchException thrown if the given value is not an integer.
     */

    public int readValues(int row, int column)
            throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("a[" + row + "]" + "[" + column + "]");
        return scanner.nextInt();
    }

    /**
     * Displays message on standard output
     *
     * @param message message to be displayed
     */
    public void print(String message) {
        System.out.println(message);
    }

    /**
     * Prints the calculated determinant.
     *
     * @param result is the determinant.
     */
    public void printResult(int result) {
        System.out.println("det(A)=" + result);
    }

    /**
     * Prints the matrix created by the user
     *
     * @param matrix input by the user
     */
    public void printMatrix(List<ArrayList<Integer>> matrix) {

        for (ArrayList<Integer> row : matrix) {
            for (int element : row)
                System.out.println(element);
        }

    }
}