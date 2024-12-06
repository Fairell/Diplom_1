import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.Bun;

public class BunTest {

    private static final double DELTA = 0.001;

    @Test
    public void shouldReturnCorrectName() {
        Bun bun = new Bun("test bun", 50);
        assertEquals("test bun", bun.getName());
    }

    @Test
    public void shouldReturnCorrectPrice() {
        Bun bun = new Bun("test bun", 50);
        assertEquals(50, bun.getPrice(), DELTA);
    }
}
