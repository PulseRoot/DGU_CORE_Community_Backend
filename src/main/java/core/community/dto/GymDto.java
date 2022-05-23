package core.community.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 이게...필요할까?
public class GymDto {
    private String name;  // 헬스장 이름
    private String location;  // 헬스장 위치
    private Integer price;  // 헬스장 월 회비
    private String description;  // 헬스장 설명
    private String joinedDate;  // 서비스 입점 날짜

}
