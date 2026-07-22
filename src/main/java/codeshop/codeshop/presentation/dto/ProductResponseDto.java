package codeshop.codeshop.presentation.dto;

import codeshop.codeshop.domain.entity.Product;


//TODO : dto 네이밍 더 좋은 건 없을까?
public class ProductResponseDto {
    private String name;

    private long price;

    private long quantity;

    private boolean isPurchasable;

    public ProductResponseDto(String name, long price, long quantity, boolean isPurchasable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isPurchasable = isPurchasable;
    }

    public static ProductResponseDto from(Product product) {
        String name = product.getName();
        long price = product.getPrice();
        long quantity = product.getQuantity();
        boolean isPurchasable = Product.isPurchasable(product);
        return new ProductResponseDto(name, price, quantity, isPurchasable);
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }

    public boolean isPurchasable() {
        return isPurchasable;
    }
}
