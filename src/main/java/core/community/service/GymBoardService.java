package core.community.service;

import core.community.dto.GymBoardDto;
import core.community.dto.GymBoardListDto;
import core.community.entity.GymBoard;
import core.community.entity.Member;
import core.community.repository.GymBoardRepository;
import core.community.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GymBoardService {
    private final GymBoardRepository gymBoardRepository;
    private final MemberRepository memberRepository;
    public String addPost(GymBoardDto gymBoardDto) {
        Member member = Member.createRandomMember(gymBoardDto);
        GymBoard gymBoard = GymBoard.createAnyGymBoard(gymBoardDto);
        gymBoard.setMember(member);

        return gymBoardRepository.save(gymBoard).getTitle();
    }


    public List<?> getPosts() {
        List<GymBoardListDto> list = new ArrayList<>();
        for(GymBoard gb :gymBoardRepository.findAll()){
            GymBoardListDto post = new GymBoardListDto();
            post.setId(gb.getId());
            post.setTitle(gb.getTitle());
            post.setMemberName(gb.getMember().getName());
            post.setCreatedDate(gb.getDate().toString());

            list.add(post);
        }

        return list;
    }
    public GymBoardDto getPost(Long id) {
        GymBoard gb = gymBoardRepository.getById(id);
        GymBoardDto gymBoardDto = new GymBoardDto();
        gymBoardDto.setContent(gb.getContent());
        gymBoardDto.setTitle(gb.getTitle());
        gymBoardDto.setMemberName(gb.getMember().getName());
        gymBoardDto.setRandomPassword("안알랴줌");

        return gymBoardDto;
    }
}
