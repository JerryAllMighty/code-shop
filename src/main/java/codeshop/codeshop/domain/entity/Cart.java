package codeshop.codeshop.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //TODO : 왜 long은 안되다고 했더라?
    private Long id;

    //TODO : 연관관계 주인 어떻게 잡는지 다시 정립
    //TODO : 1대1 굳이 잡아줘야하나?
    //TODO : 양방향은 어떤 기준일 떄 잡았더라?
    @OneToOne
    private Member member;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItemList = new ArrayList<>();

    protected Cart() {
    }
}
