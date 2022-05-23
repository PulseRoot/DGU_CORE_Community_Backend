package core.community.controller;

import core.community.dto.GymDto;
import core.community.service.GymService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000"})//프론트서버랑 연결
public class GymController {
    private final GymService gymService;

    // 헬스장 정보 추가하기
    @PostMapping("/addAnyGym")
    ResponseEntity<?> addGym(@RequestBody GymDto gymDto) throws URISyntaxException {
        return ResponseEntity.ok(gymService.addGym(gymDto));
    }

    // 모든 헬스장 정보 불러오기
    @GetMapping("/getAnyGym")
    ResponseEntity<?> getGyms() {
        return ResponseEntity.ok(gymService.getGyms());
    }


    // 특정 id의 헬스장 정보불러오기
    @GetMapping("getAnyGym/id/{id}")
    ResponseEntity<?> getGym(@PathVariable Long id) {
        return ResponseEntity.ok(gymService.getGym(id));
    }


    // 특정 location 의 헬스장 정보 불러오기
    @GetMapping("getAnyGym/location/{location}")
    ResponseEntity<?> getLocationGyms(@PathVariable String location) {
        return ResponseEntity.ok(gymService.getLocationGyms(location));
    }
}
