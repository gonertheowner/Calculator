package Calculator.Classes;

import Calculator.ExistedInterfaces.CalculatorPresenter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GUI extends JFrame  implements CalculatorPresenter, ActionListener {
    static String  a = "", b = "" , operation = "";
    static  JFrame frame;
    Calc calculator = Calc.getInstance();
    public JPanel buttonsPanel = new JPanel();
    public ArrayList<JButton> buttons = new ArrayList<>();
    public static JTextField result;

    public void display() {
        GUI listener = new GUI();

        frame = new JFrame("Calculator");
        result = new JTextField(16);
        result.setEditable(false);
        result.setText("");

        List<String> operations = Arrays.asList("+", "-", "/", "*", "c", "=");

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(listener);
            buttons.add(button);
        }


        buttons.forEach(buttonsPanel::add);

        operations.forEach(it -> {
            JButton button = new JButton(it);
            button.addActionListener(listener);
            buttons.add(button);
        });

        for (int i = 10; i < 16; i++) {
            buttonsPanel.add(buttons.get(i));
        }

        GridLayout layout = new GridLayout(4,4);
        buttonsPanel.setLayout(layout);

        JPanel panel = new JPanel();
        panel.add(result);
        panel.add(buttonsPanel);

        frame.add(panel);
        frame.setSize(360, 180);
        frame.setVisible(true);
    }

    @Override
    public double onPlusClicked() {
        return calculator.sum(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Override
    public double onMinusClicked() {
        return calculator.subtract(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Override
    public double onDivideClicked() {
        return calculator.divide(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Override
    public double onMultiplyClicked() {
        return calculator.multiply(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String s = e.getActionCommand();

        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            if (operation.equals("")) {
                a = a + s;
            } else {
                b = b + s;
            }
            result.setText(a + operation + b);
        } else if (s.charAt(0) == 'c') {
            a = operation = b = "";
            result.setText(a + operation + b);
        } else if (s.charAt(0) == '=') {
            double res =  switch (operation)
                    {
                        case "+" -> onPlusClicked();
                        case "-" -> onMinusClicked();
                        case "/" -> onDivideClicked();
                        case "*" -> onMultiplyClicked();
                        default -> 0;
                    };

            a = String.valueOf(res);
            result.setText(a);
            operation = b = "";
        } else if (operation.equals("")) {
            operation = s;
        }
        result.setText(a + operation + b);
    }

    public JButton getPlusButton() {
        return buttons.get(10);
    }

    public JButton getMinusButton() {
        return buttons.get(11);
    }

    public JButton getDivideButton() {
        return buttons.get(12);
    }

    public JButton getMultiplyButton() {
        return buttons.get(13);
    }

    public JButton getEqualsButton() {
        return buttons.get(14);
    }

    public JButton getClearButton() {
        return buttons.get(15);
    }

    public JTextField getResultField() {
        return result;
    }

    public void setFirstArgument(String a) {
        GUI.a = a;
    }

    public void setSecondArgument(String b) {
        GUI.b = b;
    }
}