package codeshop.codeshop.presentation.controller;

import codeshop.codeshop.application.MemberService;
import codeshop.codeshop.presentation.dto.MemberModifyRequestDto;
import codeshop.codeshop.presentation.dto.SignUpRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@Tag(name = "Member", description = "회원 관련 API")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "회원 가입", description = "새로운 회원을 생성한다")
    @PostMapping("/sign-up")
    public ResponseEntity<HttpStatus> signUp(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        memberService.signUp(signUpRequestDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Operation(summary = "회원 정보 수정", description = "회원 정보를 수정한다")
    @PatchMapping("/me")
    public ResponseEntity<HttpStatus> modifyProfile(@Valid @RequestBody MemberModifyRequestDto memberModifyRequestDto) {
        //TODO : 이메일 포함해서 보내면 어떻게 되는지? 에러처리할지? 에러가 없다면 그냥 냅둘지?
        memberService.modifyProfile(memberModifyRequestDto);
        //TODO : 적절한 상태값 고민해보기
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
