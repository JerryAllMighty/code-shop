package codeshop.codeshop.infra;

import codeshop.codeshop.domain.entity.Cart;

public interface CartRepositoryCustom {
    Cart findOneByMemberEmail(String email);
}
