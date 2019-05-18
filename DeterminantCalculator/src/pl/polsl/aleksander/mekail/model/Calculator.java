package pl.polsl.aleksander.mekail.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class calculating the determinant of the matrix
 *
 * @author Aleksander Mekail
 * @version 2.0
 */

public class Calculator {
    public Calculator() {
    }

    /**
     * Function that calculates the determinant of the matrix.If the size of the matrix is bigger than 2 it creates smaller matrices
     *
     * @param previousMatrix  before a smaller matrix (minor) with crossed out row and column is created, we retrieve the element corresponding to the row and column from the previous (bigger) matrix.
     * @param matrixDimension every recursion we decrease the dimension of the matrix until we are able to calculate 2x2 determinant.
     * @return determinant of given matrix.
     */
    public int calculateDeterminant(List<ArrayList<Integer>> previousMatrix, int matrixDimension) {
        /**
         * @param minorFlag is set to 1 when index is not that of the crossed out row and column.
         * @param minorIndex used to track index of the smaller matrix when adding values from the bigger matrix.
         * @param determinantA used to store the determinant.
         */
        int minorFlag = 0;
        int determinantA = 0;
        if (previousMatrix.size() == 1) {
            return previousMatrix.get(0).get(0);
        } else if (previousMatrix.size() == 2) {
            return previousMatrix.get(0).get(0) * previousMatrix.get(1).get(1) - previousMatrix.get(0).get(1) * previousMatrix.get(1).get(0);
        } else {

            for (int column = 0; column < previousMatrix.size(); column++) {
                List<ArrayList<Integer>> smallerMatrix = new ArrayList<>(matrixDimension);
                smallerMatrix.clear();
                int minorIndex = 0;

                for (int i = 0; i < matrixDimension; i++) {
                    smallerMatrix.add(new ArrayList());
                }

                for (int i = 1; i < previousMatrix.size(); i++) {
                    for (int j = 0; j < previousMatrix.size(); j++) {
                        if (!(j == column)) {
                            smallerMatrix.get(minorIndex).add(previousMatrix.get(i).get(j));
                            minorFlag = 1;
                        }
                    }
                    if (minorFlag == 1) {
                        minorIndex++;
                        minorFlag = 0;
                    }
                }
                determinantA += (int) (Math.pow(-1, column) * previousMatrix.get(0).get(column) * calculateDeterminant(smallerMatrix, matrixDimension - 1));
            }
            return determinantA;
        }
    }
}
