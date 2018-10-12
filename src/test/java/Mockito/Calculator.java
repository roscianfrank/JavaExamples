package Mockito;

public class Calculator {
    CalculatorService service;

    public Calculator(CalculatorService service) {
        this.service = service;
    }

    public int perform(int i, int j) {
        //To check mocking is working or not
        //return (i+j)*i;
        return service.add(i, j)*i;
    }

}
