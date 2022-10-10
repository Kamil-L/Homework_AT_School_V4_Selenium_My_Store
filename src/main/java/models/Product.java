package models;

public class Product {

    private String productName;
    private int productQuantity;
    private double productCurrentPrice;
    private double productTotalPrice;


    public Product(String productName, int productQuantity, double productCurrentPrice, double productTotalPrice) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productCurrentPrice = productCurrentPrice;
        this.productTotalPrice = productTotalPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getProductCurrentPrice() {
        return productCurrentPrice;
    }

    public double getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductCurrentPrice(double productCurrentPrice) {
        this.productCurrentPrice = productCurrentPrice;
    }

    public void setProductTotalPrice(double productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public Product(ProductBuilder productBuilder) {

        this.productName = productBuilder.productName;
        this.productQuantity = productBuilder.productQuantity;
        this.productCurrentPrice = productBuilder.productCurrentPrice;
        this.productTotalPrice = productBuilder.productTotalPrice;
    }

    public static final class ProductBuilder {
        private String productName;
        private int productQuantity;
        private double productCurrentPrice;
        private double productTotalPrice;

        public ProductBuilder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder setProductQuantity(int productQuantity) {
            this.productQuantity = productQuantity;
            return this;
        }

        public ProductBuilder setProductCurrentPrice(double productCurrentPrice) {
            this.productCurrentPrice = productCurrentPrice;
            return this;
        }

        public ProductBuilder setProductTotalPrice(double productTotalPrice) {
            this.productTotalPrice = productTotalPrice;
            return this;
        }

        public Product build() {

            if (productName.isEmpty()) {
                throw new IllegalStateException("Product name cannot be empty");
            }
            return new Product(this);
        }
    }
}