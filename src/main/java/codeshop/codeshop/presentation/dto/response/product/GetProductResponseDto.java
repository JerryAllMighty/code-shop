package codeshop.codeshop.presentation.dto.response.product;

import codeshop.codeshop.domain.entity.Product;


public class GetProductResponseDto {
    private String name;

    private long price;

    private long quantity;

    private boolean isPurchasable;

    public GetProductResponseDto(String name, long price, long quantity, boolean isPurchasable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isPurchasable = isPurchasable;
    }

    public static GetProductResponseDto from(Product product) {
        String name = product.getName();
        long price = product.getPrice();
        long quantity = product.getQuantity();
        boolean isPurchasable = Product.isPurchasable(product);
        return new GetProductResponseDto(name, price, quantity, isPurchasable);
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
