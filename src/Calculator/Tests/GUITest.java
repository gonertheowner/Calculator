package Calculator.Tests;

import Calculator.Classes.GUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class GUITest {
    @Mock
    GUI gui = new GUI();

    @Test
    public void calculateSummary() throws InterruptedException {
        gui.display();
        Thread.sleep(500);

        gui.setFirstArgument("3");
        Thread.sleep(500);
        gui.setSecondArgument("4");
        Thread.sleep(500);
        gui.getPlusButton().doClick(500);
        Thread.sleep(500);
        gui.getEqualsButton().doClick(500);
        Thread.sleep(500);

        Assertions.assertEquals(gui.getResultField().getText(), "7.0");
    }

    @Test
    public void calculateSubtraction() throws InterruptedException {
        gui.display();
        Thread.sleep(500);

        gui.setFirstArgument("3");
        Thread.sleep(500);
        gui.setSecondArgument("4");
        Thread.sleep(500);
        gui.getMinusButton().doClick(500);
        Thread.sleep(500);
        gui.getEqualsButton().doClick(500);
        Thread.sleep(500);

        Assertions.assertEquals(gui.getResultField().getText(), "-1.0");
    }

    @Test
    public void calculateMultiplication() throws InterruptedException {
        gui.display();
        Thread.sleep(500);

        gui.setFirstArgument("3");
        Thread.sleep(500);
        gui.setSecondArgument("4");
        Thread.sleep(500);
        gui.getMultiplyButton().doClick(500);
        Thread.sleep(500);
        gui.getEqualsButton().doClick(500);
        Thread.sleep(500);

        Assertions.assertEquals(gui.getResultField().getText(), "12.0");
    }

    @Test
    public void calculateDivision() throws InterruptedException {
        gui.display();
        Thread.sleep(500);

        gui.setFirstArgument("4");
        Thread.sleep(500);
        gui.setSecondArgument("2");
        Thread.sleep(500);
        gui.getDivideButton().doClick(500);
        Thread.sleep(500);
        gui.getEqualsButton().doClick(500);
        Thread.sleep(500);

        Assertions.assertEquals(gui.getResultField().getText(), "2.0");
    }

    @Test
    public void clearTextField() throws InterruptedException {
        gui.display();
        Thread.sleep(500);

        gui.setFirstArgument("3");
        Thread.sleep(500);
        gui.setSecondArgument("4");
        Thread.sleep(500);
        gui.getMinusButton().doClick(500);
        Thread.sleep(500);
        gui.getClearButton().doClick(500);
        Thread.sleep(500);

        Assertions.assertEquals(gui.getResultField().getText(), "");
    }
}