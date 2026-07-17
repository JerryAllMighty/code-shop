package codeshop.codeshop.presentation.dto;
//
//import lombok.Builder;
//
//@Builder
public class ProductSearchResponseDto {
    private String name;

    private long price;

    private long quantity;

    private boolean isSaleAvailable;

    //TODO : 객체 생성 패턴은 정적 팩토리와 빌더말고 뭐가 더 있는지?


    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }

    public boolean isSaleAvailable() {
        return isSaleAvailable;
    }
}
