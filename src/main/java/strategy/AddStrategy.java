package strategy;

public class AddStrategy implements CalculationStrategy {
    @Override
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
