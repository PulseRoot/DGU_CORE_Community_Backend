package core.community.controller;

import core.community.dto.GymDto;
import core.community.service.GymService;
import lombok.RequiredArgsConstructor;
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
    @GetMapping("getAnyGym/{id}")
    ResponseEntity<?> getGym(@PathVariable Long id) {
        return ResponseEntity.ok(gymService.getGym(id));
    }


    // 특정 location 의 헬스장 정보 불러오기
    @GetMapping("getAnyGym/location")
    ResponseEntity<?> getLocationGyms(@RequestParam(value = "gymLocation", required = false) String location) {
        return ResponseEntity.ok(gymService.getLocationGyms(location));
    }

    // 특정 이름을 포함하는 헬스장 정보 불러오기
    @GetMapping("getAnyGym/name")
    ResponseEntity<?> getNameGyms(@RequestParam(value = "gymName", required = false) String name) {
        return ResponseEntity.ok(gymService.getNameGyms(name));
    }
}
