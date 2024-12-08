import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameter()
    public int index;

    @Parameterized.Parameter(1)
    public IngredientType expected;

    @Parameterized.Parameters(name = "Ingredients: {0}, Expected Price: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {0, IngredientType.SAUCE},
                {1, IngredientType.FILLING}
        };
    }

    @Test
    public void shouldHaveCorrectOrder() {
        assertEquals("Порядок элементов не совпадает", expected, IngredientType.values()[index]);
    }
}
