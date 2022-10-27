package Calculator.Tests.BDDTest;

import Calculator.Classes.Calc;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class SummaryBDDTest {
    private double firstArgument;
    private double secondArgument;
    private double result;
    private final Calc calc = Calc.getInstance();

    @Given("A $firstArgument and $secondArgument")
    public void setArguments(double firstArgument, double secondArgument)
    {
        this.firstArgument = firstArgument;
        this.secondArgument = secondArgument;
    }

    @When("User call $choice method")
    public void summary(String choice)
    {
        switch (choice) {
            case "sum" -> result = calc.sum(firstArgument, secondArgument);
            case "divide" -> result = calc.divide(firstArgument, secondArgument);
            case "multiply" -> result = calc.multiply(firstArgument, secondArgument);
            case "subtract" -> result = calc.subtract(firstArgument, secondArgument);
        }
    }
    @Then("Get the $result")
    public void getResult(double result)
    {
        Assert.assertEquals(this.result, result);
    }
}
