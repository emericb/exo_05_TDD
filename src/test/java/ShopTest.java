import entity.Product;
import entity.Shop;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {

    @Test
    public void testUpdateNormalProduct() {
        Product product = new Product("normal", "Normal Product", 10, 20);
        Shop shop = new Shop(List.of(product));
        shop.update(product);
        assertEquals(9, product.getSellIn());
        assertEquals(19, product.getQuality());
    }

    @Test
    public void testUpdateExpiredProduct() {
        Product product = new Product("normal", "Expired Product", 0, 20);
        Shop shop = new Shop(List.of(product));
        shop.update(product);
        assertEquals(-1, product.getSellIn());
        assertEquals(18, product.getQuality());
    }

    @Test
    public void testUpdateBrieVieilli() {
        Product product = new Product("brie vieilli", "Aged Brie", 10, 20);
        Shop shop = new Shop(List.of(product));
        shop.update(product);
        assertEquals(9, product.getSellIn());
        assertEquals(21, product.getQuality());
    }

    @Test
    public void testUpdateProduitLaitier() {
        Product product = new Product("produit laitier", "Dairy Product", 10, 20);
        Shop shop = new Shop(List.of(product));
        shop.update(product);
        assertEquals(9, product.getSellIn());
        assertEquals(18, product.getQuality());
    }

    @Test
    public void testUpdateProduitLaitierExpired() {
        Product product = new Product("produit laitier", "Expired Dairy Product", 0, 20);
        Shop shop = new Shop(List.of(product));
        shop.update(product);
        assertEquals(-1, product.getSellIn());
        assertEquals(16, product.getQuality());
    }

    @Test
    public void testQualityNeverNegative() {
        Product product = new Product("normal", "Normal Product", 10, 0);
        Shop shop = new Shop(List.of(product));
        shop.update(product);
        assertEquals(9, product.getSellIn());
        assertEquals(0, product.getQuality());
    }

    @Test
    public void testQualityNeverMoreThanFifty() {
        Product product = new Product("brie vieilli", "Aged Brie", 10, 50);
        Shop shop = new Shop(List.of(product));
        shop.update(product);
        assertEquals(9, product.getSellIn());
        assertEquals(50, product.getQuality());
    }
}