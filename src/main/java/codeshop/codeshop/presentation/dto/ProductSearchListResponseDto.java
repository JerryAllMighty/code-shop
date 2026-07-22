package codeshop.codeshop.presentation.dto;

import codeshop.codeshop.domain.entity.Product;

public class ProductSearchListResponseDto {
    private String name;

    private long price;

    private long quantity;

    private boolean isPurchasable;

    public ProductSearchListResponseDto(String name, long price, long quantity, boolean isPurchasable) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isPurchasable = isPurchasable;
    }

    //TODO : 객체 생성 패턴은 정적 팩토리와 빌더말고 뭐가 더 있는지?
    // TODO : 책임소재 dto에 있는게 맞는지? 엔티티에 만들었어야하는건 아닌지?
    public static ProductSearchListResponseDto from(Product product) {
        String name = product.getName();
        long price = product.getPrice();
        long quantity = product.getQuantity();
        boolean isPurchasable = Product.isPurchasable(product);
        return new ProductSearchListResponseDto(name, price, quantity, isPurchasable);
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
