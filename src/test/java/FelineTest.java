import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

   private Feline feline;

    @Before
    public void initFeline() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParamsTest() {
        int defaultKittensCount = 1;
        assertEquals(defaultKittensCount, feline.getKittens());
    }

    @Test
    public void getKittensWithParamsTest() {
       int expectedResult = 4;
       assertEquals(expectedResult, feline.getKittens(expectedResult));

    }
}
