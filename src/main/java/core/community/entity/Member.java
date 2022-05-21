package core.community.entity;

import core.community.dto.GymBoardDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Column(unique = true)
    @Nullable
    private String email;

    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<GymBoard> gymBoards = new ArrayList<>();


    //모든 사용자 글 생성
    public static Member createRandomMember(GymBoardDto gymBoardDto){
        Member member = new Member();//랜덤멤버생성 비번,보드만 연결
        member.setName(gymBoardDto.getMemberName());
        member.setPassword(gymBoardDto.getRandomPassword());
        return member;
    }
}
