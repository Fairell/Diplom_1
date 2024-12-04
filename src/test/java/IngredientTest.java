import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void shouldReturnCorrectName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        assertEquals("cutlet", ingredient.getName());
    }

    @Test
    public void shouldReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 200);
        assertEquals(200, ingredient.getPrice(), 0.001);
    }

    @Test
    public void shouldReturnCorrectType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
