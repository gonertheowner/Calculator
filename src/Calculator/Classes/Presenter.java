package Calculator.Classes;

import Calculator.ExistedInterfaces.CalculatorPresenter;

public class Presenter implements CalculatorPresenter {
    @Override
    public void onPlusClicked() {
        System.out.println("+ is clicked");
    }

    @Override
    public void onMinusClicked() {
        System.out.println("- is clicked");
    }

    @Override
    public void onDivideClicked() {
        System.out.println("/ is clicked");
    }

    @Override
    public void onMultiplyClicked() {
        System.out.println("* is clicked");
    }
}
