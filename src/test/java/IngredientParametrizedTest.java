import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class) // запускаем тест с параметрами
public class IngredientParametrizedTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    static Database db = new Database();

    public IngredientParametrizedTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][] {
                {db.availableIngredients().get(0).type, db.availableIngredients().get(0).name, db.availableIngredients().get(0).price},
                {db.availableIngredients().get(1).type, db.availableIngredients().get(1).name, db.availableIngredients().get(0).price},
                {db.availableIngredients().get(2).type, db.availableIngredients().get(2).name, db.availableIngredients().get(0).price},
                {db.availableIngredients().get(3).type, db.availableIngredients().get(3).name, db.availableIngredients().get(0).price},
                {db.availableIngredients().get(4).type, db.availableIngredients().get(4).name, db.availableIngredients().get(0).price},
                {db.availableIngredients().get(5).type, db.availableIngredients().get(5).name, db.availableIngredients().get(0).price},
        };
    }

    @Test
    public void getPriceCheck() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }

    @Test
    public void getNameCheck() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeCheck() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }
}