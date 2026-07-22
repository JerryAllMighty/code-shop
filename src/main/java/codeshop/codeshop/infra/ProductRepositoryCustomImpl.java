package codeshop.codeshop.infra;

import codeshop.codeshop.domain.entity.Product;
import codeshop.codeshop.domain.entity.QProduct;
import codeshop.codeshop.presentation.dto.ProductSearchCondition;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    //TODO : JPAQueryFactory vs JPAQuery
    private final JPAQueryFactory queryFactory;

    public ProductRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Product> findProductsBySearchCondition(ProductSearchCondition productSearchCondition) {
        //TODO : DTO로 바로 리턴하는 것과 무슨 차이인지
        // TODO : 공식 문서랑 내용이 다르니 알아본다
        QProduct product = QProduct.product;
        return queryFactory.selectFrom(product)
                .where(
                    product.name.like(productSearchCondition.getProductName())
                        // TODO : N + 1 문제 방지를 위한거라면 왜 그런지?
                ).fetch();
    }
}
