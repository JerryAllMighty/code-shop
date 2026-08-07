package codeshop.codeshop.presentation.dto.response.product;

import codeshop.codeshop.domain.entity.Product;
import lombok.Getter;

@Getter
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
}
