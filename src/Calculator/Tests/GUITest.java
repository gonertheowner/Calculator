package Calculator.Tests;

import Calculator.Classes.GUI;
import org.junit.jupiter.api.*;
import org.mockito.Mock;

public class GUITest {
    @Mock
    GUI gui = new GUI();

    @BeforeEach
    void displayGUI() {
        gui.display();
    }

    @AfterEach
    void clearGUI() {
        gui.clear();
    }

    @AfterAll
    static void closeGUI() {
        GUI.close();
    }

    @Test
    public void calculateSummary() throws InterruptedException {
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