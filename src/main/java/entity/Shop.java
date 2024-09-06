package entity;

import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    public void update(Product product) {
        product.setSellIn(product.getSellIn() - 1);

        switch (product.getType()) {
            case "brie vieilli":
                if (product.getQuality() < 50) {
                    product.setQuality(product.getQuality() + 1);
                }
                break;
            case "produit laitier":
                if (product.getSellIn() < 0) {
                    product.setQuality(product.getQuality() - 4);
                } else {
                    product.setQuality(product.getQuality() - 2);
                }
                break;
            default:
                if (product.getSellIn() < 0) {
                    product.setQuality(product.getQuality() - 2);
                } else {
                    product.setQuality(product.getQuality() - 1);
                }
                break;
        }

        if (product.getQuality() < 0) {
            product.setQuality(0);
        } else if (product.getQuality() > 50) {
            product.setQuality(50);
        }
    }
}