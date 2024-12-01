import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatMockTest {

    @Mock
    private Feline felineMock;

    private Cat cat;

    @Before
    public void initCat() {
        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundTest() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedResult);
        assertEquals(expectedResult, cat.getFood());
    }

}
