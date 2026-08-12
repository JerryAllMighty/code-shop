package codeshop.codeshop.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
//TODO : 이거 정확하게 역할이 뭘까
public class PaymentServiceImpl implements PaymentService {

    //TODO : 결제 생성
    //TODO : PG 사 결제 요청
}
