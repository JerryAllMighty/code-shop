package codeshop.codeshop.presentation.controller;

import codeshop.codeshop.application.MemberService;
import codeshop.codeshop.presentation.dto.request.member.ModifyProfileRequestDto;
import codeshop.codeshop.presentation.dto.request.member.SignUpRequestDto;
import codeshop.codeshop.presentation.dto.response.member.ModifyProfileResponseDto;
import codeshop.codeshop.presentation.dto.response.member.SignUpResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/members")
@Tag(name = "Member", description = "회원 관련 API")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "회원 가입", description = "새로운 회원을 생성한다")
    @PostMapping("/sign-up")
    public ResponseEntity<SignUpResponseDto> signUp(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        SignUpResponseDto signUpResponseDto = memberService.signUp(signUpRequestDto);
        return ResponseEntity.
                created(URI.create("/api/v1/members/" + signUpResponseDto.memberId()))
                .body(signUpResponseDto);
    }

    @Operation(summary = "회원 정보 수정", description = "회원 정보를 수정한다")
    @PatchMapping("/me")
    public ResponseEntity<ModifyProfileResponseDto> modifyProfile(@RequestBody @Valid ModifyProfileRequestDto modifyProfileRequestDto) {
        //TODO : 이메일 포함해서 보내면 어떻게 되는지? 에러처리할지? 에러가 없다면 그냥 냅둘지?
        ModifyProfileResponseDto modifyProfileResponseDto = memberService.modifyProfile(modifyProfileRequestDto);
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(modifyProfileResponseDto);
    }
}
