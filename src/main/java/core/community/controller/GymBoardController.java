package core.community.controller;

import core.community.dto.GymBoardDto;
import core.community.service.GymBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000"})//프론트서버랑 연결
public class GymBoardController {

    private final GymBoardService gymBoardService;

    @PostMapping("/addAnyPost")
    ResponseEntity<?>  addPost(@RequestBody GymBoardDto gymBoardDto) throws URISyntaxException {
        return ResponseEntity.ok(gymBoardService.addPost(gymBoardDto));//글제목 반환
    }

    //모든 글 다 불러오는 페이지
    @GetMapping("/getAnyPost")
    ResponseEntity<?> getPosts(){
        return ResponseEntity.ok(gymBoardService.getPosts());
    }

    //선택한 글 불러오기
    @GetMapping("/getAnyPost/{id}")
    ResponseEntity<?> getPost(@PathVariable Long id){
        return ResponseEntity.ok(gymBoardService.getPost(id));
    }

}
