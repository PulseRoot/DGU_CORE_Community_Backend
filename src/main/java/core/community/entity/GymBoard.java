package core.community.entity;

import core.community.dto.GymBoardDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class GymBoard extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "member_id")
    private Member member;


    public void setMember(Member member) {
        this.member = member;
        member.getGymBoards().add(this);
    }
    public static GymBoard createAnyGymBoard(GymBoardDto gymBoardDto) {
        GymBoard gymBoard = new GymBoard();
        gymBoard.setTitle(gymBoardDto.getTitle());
        gymBoard.setContent(gymBoardDto.getContent());

        return gymBoard;
    }
}
