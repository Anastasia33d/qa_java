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
        assertEquals("Метод eatMeat должен возвращать список с рационом для кошачьих", List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Метод getFamily должен возвращать правильное семейство животных", "Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutParamsTest() {
        int defaultKittensCount = 1;
        assertEquals("Метод getKittensWithoutParams без параметров должен возвращать количество котят по умолчанию", defaultKittensCount, feline.getKittens());
    }

    @Test
    public void getKittensWithParamsTest() {
       int expectedResult = 4;
       assertEquals("Метод getKittensWithParams с параметром должен возвращать переданное количество котят", expectedResult, feline.getKittens(expectedResult));
    }
}
