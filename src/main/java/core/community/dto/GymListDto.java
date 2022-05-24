package core.community.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 헬스장 정보를 모두 출력할 시에는 효율성을 위해 정보의 일부분만 출력한다
public class GymListDto {
    private Long id;
    private String name;
    private String location;
    private Integer price;
    private String imgUrl;
}
