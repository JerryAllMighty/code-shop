package codeshop.codeshop.presentation.dto.response.product;

import codeshop.codeshop.domain.entity.Product;
import lombok.Getter;

@Getter
public class GetProductsResponseDto {
    private String name;

    private long price;

    private long quantity;

    private boolean isPurchasable;

    public GetProductsResponseDto(String name, long price, long quantity, boolean isPurchasable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isPurchasable = isPurchasable;
    }

    //TODO : 객체 생성 패턴은 정적 팩토리와 빌더말고 뭐가 더 있는지?
    public static GetProductsResponseDto from(Product product) {
        String name = product.getName();
        long price = product.getPrice();
        long quantity = product.getQuantity();
        boolean isPurchasable = Product.isPurchasable(product);
        return new GetProductsResponseDto(name, price, quantity, isPurchasable);
    }
}
