package codeshop.codeshop.infra;

import codeshop.codeshop.domain.entity.Product;
import codeshop.codeshop.presentation.dto.request.product.SearchProductCondition;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static codeshop.codeshop.domain.entity.QProduct.*;

public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ProductRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Product> findProductsBySearchCondition(SearchProductCondition searchProductCondition, Pageable pageable) {
        List<Product> content =
                queryFactory.selectFrom(product)
                .where(nameLike(searchProductCondition.productName()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(order(pageable.getSort()))
                .fetch();

        JPAQuery<Long> countQuery =
                queryFactory.select(product.count())
                .from(product)
                .where(
                        nameLike(searchProductCondition.productName())
                );

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression nameLike(String name) {
        return StringUtils.hasText(name) ? product.name.like(name) : null;
    }

    private OrderSpecifier<String> order(Sort order) {
        return order.equals(Sort.Direction.ASC) ? product.name.asc() : product.name.desc();
    }
}
