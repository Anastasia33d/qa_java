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
import static org.junit.Assert.fail;

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
        assertEquals(expectedResult, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedResult);
        assertEquals(expectedResult, lion.getFood());
    }

    @Test
    public void getFoodInvalidTest() {
        try {
            new Lion("Сломанный", felineMock);
            // Если при инициализации объекта используется недопустимое значение, тест должен провалиться
            fail("Ожидается, что тут будет выброшена ошибка");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}
