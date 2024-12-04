import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void shouldContainSauceAsFirstElement() {
        assertEquals("First element SAUCE", IngredientType.SAUCE, IngredientType.values()[0]);
    }

    @Test
    public void shouldContainFillingAsSecondElement() {
        assertEquals("Second element FILLING", IngredientType.FILLING, IngredientType.values()[1]);
    }
}