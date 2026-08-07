package codeshop.codeshop.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "orders")
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
