package providers;

import models.Product;
import pages.products.ProductPopupCartPage;

public class ProductFactory {

    public Product getProductDetails(ProductPopupCartPage productPopupCartPage) {
        String productName = productPopupCartPage.getProductName();
        int productQuantity = productPopupCartPage.getProductQuantity();
        float productCurrentPrice = productPopupCartPage.getProductPrice();
        float productTotalPrice = productPopupCartPage.getTotalProductsValue();
        return new Product.ProductBuilder()
                .setProductName(productName)
                .setProductQuantity(productQuantity)
                .setProductCurrentPrice(productCurrentPrice)
                .setProductTotalPrice(productTotalPrice)
                .build();
    }
}