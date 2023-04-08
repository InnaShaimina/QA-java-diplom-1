import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.*;

@RunWith(Parameterized.class) // запускаем тест с параметрами
public class BunParametrizedTest {
    private final String name;
    private final float price;
    static Database db = new Database();

    public BunParametrizedTest(String name, float price){
        this.name= name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][] {
                {db.availableBuns().get(0).name, db.availableBuns().get(0).price},
                {db.availableBuns().get(1).name, db.availableBuns().get(1).price},
                {db.availableBuns().get(2).name, db.availableBuns().get(2).price},
        };
    }

    @Test
    public void getNameCheck() {
        Bun bun = new Bun(name,price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceCheck() {
        Bun bun = new Bun(name,price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }
}