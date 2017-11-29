package rnd.composite.model.compositemodel;

public class Product {

    private int productId;
    private String productName;
    private int weight;

    public Product(){}

    public Product(int productId, String productName, int weight) {
        this.productId = productId;
        this.productName = productName;
        this.weight = weight;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
