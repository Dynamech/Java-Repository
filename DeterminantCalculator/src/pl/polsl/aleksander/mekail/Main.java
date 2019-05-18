//package pl.polsl.aleksander.mekail;
package pl.polsl.aleksander.mekail;

import pl.polsl.aleksander.mekail.model.Calculator;
import pl.polsl.aleksander.mekail.view.View;
import pl.polsl.aleksander.mekail.exceptions.NegativeNumberException;

/**
 * Contains ArrayList and it's operations as well as exception handling.
 */
import java.util.*;

/**
 * Main class playing the role of a controller
 *
 * @author Aleksander Mekail
 * @version 2.0
 */
public class Main {
    /**
     * Main program method
     *
     * @param args number of calculations we want to make
     */
    public static void main(String[] args) {
        int matrixDimension;
        List<ArrayList<Integer>> matrix = new ArrayList<>();
        Calculator calculator;
        View view = new View();

        try {
            for (int numberOfCalculations = 0; numberOfCalculations < Integer.parseInt(args[0]); numberOfCalculations++) {
                try {
                    matrixDimension = view.readMatrixSize();
                    for (int i = 0; i < matrixDimension; i++) {
                        matrix.add(new ArrayList());
                        for (int j = 0; j < matrixDimension; j++) {
                            matrix.get(i).add(view.readValues(i, j));
                        }
                    }
                    calculator = new Calculator();
                    view.printMatrix(matrix);
                    view.printResult((calculator.calculateDeterminant(matrix, matrix.size() - 1)));
                } catch (InputMismatchException e) {
                    view.print("Error: " + e);
                } catch (NegativeNumberException e) {
                    e.printError();
                }
                matrix.clear();
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            view.print("Error: " + e);
        }
    }
}