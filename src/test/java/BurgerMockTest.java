import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

@RunWith(MockitoJUnitRunner.class)// подключили Mockito к тестовому классу
public class BurgerMockTest {
    Burger burger;
    @Mock
    Bun bun;
    Ingredient firstIngredient = Mockito.mock(Ingredient.class);
    Ingredient secondIngredient = Mockito.mock(Ingredient.class);

    public BurgerMockTest() {
    }

    @Before
    public void setUp() {
        this.burger = new Burger();
    }

    @Test
    public void setBunsCheck() {
        this.burger.setBuns(this.bun);
        Assert.assertEquals(this.bun, burger.bun);
    }

    @Test
    public void addIngredientCheck() {
        this.burger.addIngredient(this.firstIngredient);
        Assert.assertEquals(this.firstIngredient, burger.ingredients.get(0));
    }

    @Test
    public void RemoveIngredientCheck() {
        this.burger.addIngredient(this.firstIngredient);
        this.burger.removeIngredient(0);
        Assert.assertTrue(this.burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientCheck() {
        this.burger.addIngredient(this.firstIngredient);
        this.burger.addIngredient(this.secondIngredient);
        this.burger.moveIngredient(0, 1);
        Assert.assertEquals(this.secondIngredient, burger.ingredients.get(0));
        Assert.assertEquals(this.firstIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getReceiptCheck() {
        this.burger.setBuns(bun);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn( "Adjika");
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn( "Bacon");
        this.burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        Mockito.when(bun.getName()).thenReturn("Bun");
        Mockito.when(bun.getPrice()).thenReturn(100500F);

        String expectedResult =
                "(==== Bun ====)\r\n" +
                "= sauce Adjika =\r\n" +
                "= filling Bacon =\r\n" +
                "(==== Bun ====)\r\n" +
                "\r\n" +
                "Price: 201000,000000\r\n";
        Assert.assertEquals(expectedResult, burger.getReceipt());
    }

    @Test
    public void getPriceCheck() {
        this.burger.setBuns(bun);
        this.burger.addIngredient(firstIngredient);
        this.burger.addIngredient(secondIngredient);

        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(firstIngredient.getPrice()).thenReturn(200F);
        Mockito.when(secondIngredient.getPrice()).thenReturn(300F);

        Assert.assertEquals(700.0F, burger.getPrice(), 0.0F);
    }
}