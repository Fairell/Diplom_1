import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Parameterized.Parameter()
    public IngredientType type;

    @Parameterized.Parameter(1)
    public String name;

    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameters(name = "Type: {0}, Name: {1}, Price: {2}")
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 200},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.SAUCE, "barbecue", 150},
                {IngredientType.FILLING, "cheese", 120},
        };
    }

    @Test
    public void shouldReturnCorrectIngredientProperties() {
        // Создаем объект Ingredient с заданными параметрами
        Ingredient ingredient = new Ingredient(type, name, price);

        // Проверяем свойства ингредиента
        assertEquals("Тип ингредиента неверен", type, ingredient.getType());
        assertEquals("Имя ингредиента неверно", name, ingredient.getName());
        assertEquals("Цена ингредиента неверна", price, ingredient.getPrice(), 0.001);
    }
}
