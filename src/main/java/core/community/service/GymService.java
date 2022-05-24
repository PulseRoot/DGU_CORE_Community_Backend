package core.community.service;

import core.community.dto.GymDto;
import core.community.dto.GymListDto;
import core.community.entity.Gym;
import core.community.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class GymService {
    private final GymRepository gymRepository;

    public String addGym(GymDto gymDto) {
        Gym gym = Gym.createGym(gymDto);

        return gymRepository.save(gym).getName();
    }


    public List<?> getGyms() {
            List<GymListDto> list = new ArrayList<>();

            for (Gym gym: gymRepository.findAll()) {
                GymListDto gymCard = new GymListDto();
                gymCard.setId(gym.getId());
                gymCard.setName(gym.getName());
                gymCard.setLocation(gym.getLocation());
                gymCard.setPrice(gym.getPrice());
//                gymCard.setImgUrl(gym.getImgUrl());
                gymCard.setImgUrl("https://w.namu.la/s/4427fd7f8e430808ca41a4568e26cc3a5af4c2e599b0ea0dcbfb8fc04587a17e8fd7a6f09c1d463512ef85ad774bed6200d109d21e4de08d6c81baf2873a1a875078583be05e39a2b6b02a01b62eb8f3d5708d08c42f757a45cef295e990d3e5");

                list.add(gymCard);
            }
            return list;
    }

    // 특정 gym 가져오기 - GymDto를 사용할 필요가 없어보임
    public GymDto getGym(Long id) {
        Gym gym = gymRepository.getById(id);
        GymDto gymDto = new GymDto();
        gymDto.setId(gym.getId());
        gymDto.setName(gym.getName());
        gymDto.setLocation(gym.getLocation());
        gymDto.setPrice(gym.getPrice());
        gymDto.setDescription(gym.getDescription());
        gymDto.setJoinedDate(gym.getJoinedDate());
//        gymDto.setImgUrl(gym.getImgUrl());

        //임시 주소
        gymDto.setImgUrl("https://w.namu.la/s/4427fd7f8e430808ca41a4568e26cc3a5af4c2e599b0ea0dcbfb8fc04587a17e8fd7a6f09c1d463512ef85ad774bed6200d109d21e4de08d6c81baf2873a1a875078583be05e39a2b6b02a01b62eb8f3d5708d08c42f757a45cef295e990d3e5");

        return gymDto;
    }


    // 특정 지역의 gyms 가져오기
    public List<?> getLocationGyms(String location) {
        List<GymListDto> list = new ArrayList<>();

        for (Gym gym : gymRepository.findByLocation(location)) {
            GymListDto gymCard = new GymListDto();
            gymCard.setId(gym.getId());
            gymCard.setName(gym.getName());
            gymCard.setPrice(gym.getPrice());
            gymCard.setLocation(gym.getLocation());
//            gymCard.setImgUrl(gym.getImgUrl());
            gymCard.setImgUrl("https://w.namu.la/s/4427fd7f8e430808ca41a4568e26cc3a5af4c2e599b0ea0dcbfb8fc04587a17e8fd7a6f09c1d463512ef85ad774bed6200d109d21e4de08d6c81baf2873a1a875078583be05e39a2b6b02a01b62eb8f3d5708d08c42f757a45cef295e990d3e5");

            list.add(gymCard);
        }
        return list;
    }

    public List<?> getNameGyms(String name) {
        List <GymListDto> list = new ArrayList<>();

        for (Gym gym : gymRepository.customSearch(name)) {
            GymListDto gymCard = new GymListDto();
            gymCard.setId(gym.getId());
            gymCard.setName(gym.getName());
            gymCard.setPrice(gym.getPrice());
            gymCard.setLocation(gym.getLocation());
//            gymCard.setImgUrl(gym.getImgUrl());
            gymCard.setImgUrl("https://w.namu.la/s/4427fd7f8e430808ca41a4568e26cc3a5af4c2e599b0ea0dcbfb8fc04587a17e8fd7a6f09c1d463512ef85ad774bed6200d109d21e4de08d6c81baf2873a1a875078583be05e39a2b6b02a01b62eb8f3d5708d08c42f757a45cef295e990d3e5");

            list.add(gymCard);
        }
        return list;

    }

}