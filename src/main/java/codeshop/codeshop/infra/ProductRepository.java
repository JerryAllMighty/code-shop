package codeshop.codeshop.infra;

import codeshop.codeshop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    // TODO : jpql 안 써줘도 되는가? 어디까지 자동 생성이고 어디까지 아닌지?
    Optional<Product> findOneById(Long id);
}
