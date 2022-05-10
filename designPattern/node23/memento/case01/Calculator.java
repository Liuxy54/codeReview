package com.liuxy.codeReview.com.lxy.designPattern.node23.memento.case01;

public interface Calculator {

    PreviousCalculationToCareTaker backupLastCalculation();

    void restorePreviousCalculation(PreviousCalculationToCareTaker previousCalculation);

    int getCalculationResult();

    void setFirstNumber(int firstNumber);

    void setSecondNumber(int secondNumber);

}
