import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParamTest {
    private final String animalKind;
    private final List<String> animalsFood;

    public AnimalParamTest(String animalKind, List<String> animalsFood) {
        this.animalKind = animalKind;
        this.animalsFood = animalsFood;
    }

    @Parameterized.Parameters
    public static Object[][] getAnimalsData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void getFoodTest() throws Exception {
        Animal animal = new Animal();
        assertEquals(animalsFood, animal.getFood(animalKind));
    }

}
