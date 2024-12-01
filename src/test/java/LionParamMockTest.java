import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionParamMockTest {
    private Lion lion;
    private final String sex;
    private final boolean hasMane;

    @Mock
    Feline felineMock;

    public LionParamMockTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void initSetup() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion(sex, felineMock);
    }

    @Parameterized.Parameters
    public static Object[][] getLionsData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeTest() {
        assertEquals(hasMane, lion.doesHaveMane());
    }
}
