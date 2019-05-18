package test.pl.polsl.aleksander.mekail;

import org.junit.*;
import pl.polsl.aleksander.mekail.exceptions.NegativeNumberException;
import pl.polsl.aleksander.mekail.model.Calculator;
import pl.polsl.aleksander.mekail.view.View;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * @author Aleksander Mekail
 */

public class TestApplication {
    public TestApplication() {
    }

    /**
     * Testing the model's method.
     */
    @Test
    public void testCalculateDeterminant() {
        List<ArrayList<Integer>> matrixTest = new ArrayList<>();
        Calculator testObject = new Calculator();
        matrixTest.add(new ArrayList<>(Arrays.asList(2, 3)));
        matrixTest.add(new ArrayList<>(Arrays.asList(1, 4)));
        int expectedResult = 5;
        int result = testObject.calculateDeterminant(matrixTest, matrixTest.size() - 1);
        assertEquals(expectedResult, result);
    }

    /**
     * Testing wrong matrix dimension input.
     */
    @Test
    public void testWrongMatrixDimension() {
        View view = new View();
        String input = "-2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        try {
            view.readMatrixSize();
            fail("An exception should be thrown");
        } catch (NegativeNumberException e) {
            e.printStackTrace();
        }
    }

    /**
     * Testing InputMismatchException.
     */
    @Test
    public void testWrongValueInput() {
        View view = new View();
        List<ArrayList<Integer>> matrix = new ArrayList<>();
        String inputValues = "s";
        int matrixDimension = 1;
        InputStream inputStream = new ByteArrayInputStream(inputValues.getBytes());
        System.setIn(inputStream);
        try {
            for (int i = 0; i < matrixDimension; i++) {
                matrix.add(new ArrayList());
                for (int j = 0; j < matrixDimension; j++) {
                    matrix.get(i).add(view.readValues(i, j));
                }
            }
            fail("An exception should occur");
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }
}
