import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerTest {

    private Burger burger;
    private Bun bun;

    @Parameterized.Parameter()
    public List<Ingredient> ingredients;

    @Parameterized.Parameter(1)
    public float expectedPrice;

    @Parameterized.Parameters(name = "Ingredients: {0}, Expected Price: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {Collections.singletonList(mockIngredient("sauce", 50.0f, IngredientType.SAUCE)), 250.0f},
                {Collections.singletonList(mockIngredient("filling", 80.0f, IngredientType.FILLING)), 280.0f},
                {Arrays.asList(
                        mockIngredient("sauce", 50.0f, IngredientType.SAUCE),
                        mockIngredient("filling", 80.0f, IngredientType.FILLING)
                ), 330.0f},
        };
    }

    private static Ingredient mockIngredient(String name, float price, IngredientType type) {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        when(ingredient.getName()).thenReturn(name);
        when(ingredient.getPrice()).thenReturn(price);
        when(ingredient.getType()).thenReturn(type);
        return ingredient;
    }

    @Before
    public void setUp() {
        burger = new Burger();

        // Mock for bun
        bun = Mockito.mock(Bun.class);
        when(bun.getPrice()).thenReturn(100.0f);
        when(bun.getName()).thenReturn("test bun");
    }

    @Test
    public void shouldCalculateTotalPriceCorrectly() {
        burger.setBuns(bun);
        ingredients.forEach(burger::addIngredient);

        float actualPrice = burger.getPrice();
        assertEquals("Цена бургера рассчитана неверно", expectedPrice, actualPrice, 0.001);
    }

    @Test
    public void shouldGenerateReceiptCorrectly() {
        burger.setBuns(bun);
        ingredients.forEach(burger::addIngredient);

        // Format price with six decimals and replace dot with comma
        DecimalFormat decimalFormat = new DecimalFormat("#.000000");
        String formattedPrice = decimalFormat.format(burger.getPrice());

        StringBuilder expectedReceipt = new StringBuilder("(==== test bun ====)\n");
        ingredients.forEach(ingredient -> expectedReceipt.append("= ")
                .append(ingredient.getName()).append(" ")
                .append(ingredient.getName()).append(" =\n"));
        expectedReceipt.append("(==== test bun ====)\n\nPrice: ").append(formattedPrice).append("\n");

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt.toString().replace("\r\n", "\n").trim(), actualReceipt.replace("\r\n", "\n").trim());
    }
}
