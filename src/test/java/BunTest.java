import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.Bun;

public class BunTest {

    @Test
    public void shouldReturnCorrectName() {
        Bun bun = new Bun("test bun", 50);
        assertEquals("test bun", bun.getName());
    }

    @Test
    public void shouldReturnCorrectPrice() {
        Bun bun = new Bun("test bun", 50);
        assertEquals(50, bun.getPrice(), 0.001);
    }
}
