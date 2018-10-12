package Mockito;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestCalculator {

    Calculator c = null;

    //Creating stub
    /*CalculatorService service = new CalculatorService() {
        @Override
        public int add(int i, int j) {
            int sum = i +j;
            return sum;
        }
    };*/

    //using mockito
    //CalculatorService service = Mockito.mock(CalculatorService.class);


    //When using with @Mock annotation
    @Mock
    CalculatorService service;

    //@Rule is required When using with @Mock annotation
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setup(){
        c= new Calculator(service);
    }

    @Test
    public void testPerform(){
        when(service.add(2,3)).thenReturn(5);
        assertEquals(10,c.perform(2,3));
        verify(service,times(1)).add(2,3); // to verify
    }
}
