import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionMockTest {

    @Mock
    private Feline felineMock;

    private Lion lion;

    @Before
    public void initLion() throws Exception {
        // Проверки на оба пола делаются в параметризированном тесте
        lion = new Lion("Самка", felineMock);
    }

    @Test
    public void getKittensTest() {
        int expectedResult = 1;
        Mockito.when(felineMock.getKittens()).thenReturn(expectedResult);
        assertEquals("Метод getKittens с параметром должен возвращать переданное количество котят", expectedResult, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedResult);
        assertEquals("Метод getFood должен возвращать список с рационом для кошачьих", expectedResult, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void getFoodInvalidTest() throws Exception {
        new Lion("Невалидное значение", felineMock);
    }
}
