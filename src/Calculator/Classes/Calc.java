package Calculator.Classes;

import Calculator.ExistedInterfaces.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc implements Calculator {
    private static Calc instance;
    private static final Presenter presenter = new Presenter();
    private Viewer viewer;

    public Calc() {}

    public static Calc getInstance() {
        if (instance == null) {
            instance = new Calc();
        }
        return instance;
    }

    @Override
    public double sum(double a, double b) {
        presenter.onPlusClicked();
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        presenter.onMinusClicked();
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        presenter.onMultiplyClicked();
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        presenter.onDivideClicked();
        if (b == 0 || b < Math.pow(10, -8)) {
            throw new ArithmeticException();
        } else {
            return a / b;
        }
    }

    public void doOperator(String operator, String firstArgumentAsString, String secondArgumentAsString) {
        double result = 0, firstArgument = 0, secondArgument = 0;
        try {
            firstArgument = Double.parseDouble(firstArgumentAsString);
            secondArgument = Double.parseDouble(secondArgumentAsString);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

        switch (operator) {
            case "+" -> result = sum(firstArgument, secondArgument);
            case "-" -> result = subtract(firstArgument, secondArgument);
            case "/" -> result = divide(firstArgument, secondArgument);
            case "*" -> result = multiply(firstArgument, secondArgument);
            default -> throw new IllegalArgumentException();
        }
        viewer.printResult(result);
    }

    public void start() {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
            String firstArgument, secondArgument, operator;
            System.out.println("Please, input first argument:");
            firstArgument = buffer.readLine();

            System.out.println("Please, input second argument:");
            secondArgument = buffer.readLine();

            System.out.println("Please input operator:");
            operator = buffer.readLine();

            doOperator(operator, firstArgument, secondArgument);
            viewer = new Viewer(Double.parseDouble(firstArgument), Double.parseDouble(secondArgument));
        } catch (IOException e) {
            viewer.displayError(e.getMessage());
        }
    }
}