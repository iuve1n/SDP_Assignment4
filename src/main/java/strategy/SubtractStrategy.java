package strategy;

public class SubtractStrategy implements CalculationStrategy {
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
}
