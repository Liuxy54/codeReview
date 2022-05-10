package com.liuxy.codeReview.com.lxy.designPattern.node23.memento.case01;

public class Client {
    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        calculator.setFirstNumber(10);
        calculator.setSecondNumber(100);
        System.out.println(calculator.getCalculationResult());
        PreviousCalculationToCareTaker memento = calculator.backupLastCalculation();
        calculator.setFirstNumber(17);
        calculator.setSecondNumber(-290);
        System.out.println(calculator.getCalculationResult());
        calculator.restorePreviousCalculation(memento);
        System.out.println(calculator.getCalculationResult());
    }
}


