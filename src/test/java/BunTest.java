import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private static final double DELTA = 0.001;

    @Parameterized.Parameter()
    public String name;

    @Parameterized.Parameter(1)
    public double price;

    @Parameterized.Parameters(name = "Bun: name={0}, price={1}")
    public static Object[][] data() {
        return new Object[][]{
                {"test bun", 50},
                {"another bun", 30.5},
                {"special bun", 99.99},
                {"cheap bun", 0.01}
        };
    }

    @Test
    public void shouldReturnCorrectNameAndPrice() {
        Bun bun = new Bun(name, (float) price);
        assertEquals("Имя булочки не совпадает", name, bun.getName());
        assertEquals("Цена булочки не совпадает", price, bun.getPrice(), DELTA);
    }
}
