package core.community.controller;

import core.community.entity.Member;
import core.community.repository.MemberRepository;
import core.community.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})//프론트서버랑 연결
public class MainController {

    private final MemberService memberService;

    @GetMapping(value =  "/")
    public ResponseEntity<?> main(Model model){
        List<Member> members = memberService.getMembers();

        return ResponseEntity.ok(members);
    }
}
