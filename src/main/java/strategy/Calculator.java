package strategy;

public class Calculator {
    private CalculationStrategy strategy;

    public Calculator(CalculationStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(CalculationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        this.strategy = strategy;
    }

    public double calculate(double firstNumber, double secondNumber) {
        return strategy.calculate(firstNumber, secondNumber);
    }
}
