package Calculator.Classes;

import Calculator.ExistedInterfaces.CalculatorView;

public class Viewer implements CalculatorView {
    private final double firstArgument;
    private final double secondArgument;

    public Viewer(double firstArgument, double secondArgument) {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }

    @Override
    public void printResult(double result) {
        System.out.println("Result: " + result);
    }

    @Override
    public void displayError(String message) {
        System.out.println(message);
    }

    @Override
    public String getFirstArgumentAsString() {
        return String.valueOf(firstArgument);
    }

    @Override
    public String getSecondArgumentAsString() {
        return String.valueOf(secondArgument);
    }
}
