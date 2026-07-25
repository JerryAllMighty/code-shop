package codeshop.codeshop.infra;

import codeshop.codeshop.domain.entity.Cart;
import codeshop.codeshop.domain.entity.QCart;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

public class CartRepositoryCustomImpl implements CartRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    //TODO : 왜 em을 삽입하는지?
    public CartRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Cart findOneByMemberEmail(String email) {
        QCart cart = QCart.cart;
        return queryFactory.selectFrom(cart)
                .where(cart.member.email.eq(email))
                .fetchOne();
    }
}
