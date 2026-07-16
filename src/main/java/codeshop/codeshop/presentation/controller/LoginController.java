package codeshop.codeshop.presentation.controller;

import codeshop.codeshop.application.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import codeshop.codeshop.domain.entity.Member;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final MemberService memberService;

    //TODO : 접근제한자 설정 기준 필요함
    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    //TODO : 접근제한자 설정 기준 필요함
    @PostMapping
    public void login(HttpServletRequest request) {
        //TODO : request에서 정보를 꺼내는 것과 requestParam이 어떻게 다를지?
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Optional<Member> member = memberService.findMember(email, password);
        //TODO: 왜 != null 보다 isPresent가 더 나은지?
        if(member.isPresent()){
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
    }
}
