import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.text.DecimalFormat;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;

    @Before
    public void setUp() {
        burger = new Burger();

        // Моки для булочек и ингредиентов
        bun = Mockito.mock(Bun.class);
        sauce = Mockito.mock(Ingredient.class);
        filling = Mockito.mock(Ingredient.class);

        // Задаем возвращаемые значения для моков
        when(bun.getPrice()).thenReturn(100.0f);
        when(bun.getName()).thenReturn("test bun");

        when(sauce.getPrice()).thenReturn(50.0f);
        when(sauce.getName()).thenReturn("sauce");
        when(sauce.getType()).thenReturn(IngredientType.SAUCE);

        when(filling.getPrice()).thenReturn(80.0f);
        when(filling.getName()).thenReturn("filling");
        when(filling.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void shouldSetBunsCorrectly() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldAddIngredientCorrectly() {
        burger.addIngredient(sauce);
        assertEquals(1, burger.ingredients.size());
        assertEquals(sauce, burger.ingredients.get(0));
    }

    @Test
    public void shouldRemoveIngredientCorrectly() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(filling, burger.ingredients.get(0));
    }

    @Test
    public void shouldMoveIngredientCorrectly() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);
        assertEquals(filling, burger.ingredients.get(0));
        assertEquals(sauce, burger.ingredients.get(1));
    }

    @Test
    public void shouldCalculateTotalPriceCorrectly() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        float expectedPrice = 2 * bun.getPrice() + sauce.getPrice() + filling.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void shouldGenerateReceiptCorrectly() {
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        // Форматируем цену с количеством символов и заменяем точку на запятую
        DecimalFormat decimalFormat = new DecimalFormat("#.000000");
        String formattedPrice = decimalFormat.format(burger.getPrice());

        String expectedReceipt = "(==== test bun ====)\n"
                + "= sauce sauce =\n"
                + "= filling filling =\n"
                + "(==== test bun ====)\n"
                + "\nPrice: " + formattedPrice + "\n";

        String actualReceipt = burger.getReceipt();

        // Вывод ожидаемого и фактического результата для отладки
        System.out.println("Expected:\n" + expectedReceipt);
        System.out.println("Actual:\n" + actualReceipt);

        assertEquals(expectedReceipt.replace("\r\n", "\n").trim(), actualReceipt.replace("\r\n", "\n").trim());
    }
}
