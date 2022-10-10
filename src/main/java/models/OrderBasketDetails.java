package models;

import pages.products.ProductPopupCartPage;
import providers.ProductFactory;

import java.util.ArrayList;
import java.util.List;

public class OrderBasketDetails {

    public static List<Product> productsOrder = new ArrayList<>();

    public OrderBasketDetails(List<Product> productsOrder) {
        OrderBasketDetails.productsOrder = productsOrder;
    }

    public OrderBasketDetails() {
    }

    public List<Product> getProducts() {
        return productsOrder;
    }

    public boolean isProductsOrderListEmpty() {
        return productsOrder.isEmpty();
    }

    public void addDetailsOfPickedProductsToList(ProductPopupCartPage productPopupCartPage) {
        ProductFactory productFactory = new ProductFactory();
        Product product = productFactory.getProductDetails(productPopupCartPage);
        boolean isAlreadyInBasket = false;
        for (Product productOrder : productsOrder) {
            if (productOrder.getProductName().equals(product.getProductName())) {
                isAlreadyInBasket = true;
                productOrder.setProductQuantity(product.getProductQuantity());
                productOrder.setProductCurrentPrice(product.getProductCurrentPrice());
                productOrder.setProductTotalPrice(product.getProductTotalPrice());
                break;
            }
        }
        if (!isAlreadyInBasket) {
            productsOrder.add(product);
        }
    }

    public OrderBasketDetails getBasket() {
        return new OrderBasketDetails(productsOrder);
    }
}