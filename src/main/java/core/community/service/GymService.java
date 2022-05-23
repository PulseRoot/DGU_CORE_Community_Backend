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
                gymCard.setName(gym.getName());
                gymCard.setLocation(gym.getLocation());
                gymCard.setPrice(gym.getPrice());

                list.add(gymCard);
            }
            return list;
    }

    // 특정 gym 가져오기 - GymDto를 사용할 필요가 없어보임
    public GymDto getGym(Long id) {
        Gym gym = gymRepository.getById(id);
        GymDto gymDto = new GymDto();
        gymDto.setName(gym.getName());
        gymDto.setLocation(gym.getLocation());
        gymDto.setPrice(gym.getPrice());
        gymDto.setDescription(gym.getDescription());
        gymDto.setJoinedDate(gym.getJoinedDate());

        return gymDto;
    }


    // 특정 지역의 gyms 가져오기
    public List<?> getLocationGyms(String location) {
        List<GymListDto> list = new ArrayList<>();

        for (Gym gym : gymRepository.findByLocation(location)) {
            GymListDto gymCard = new GymListDto();
            gymCard.setName(gym.getName());
            gymCard.setPrice(gym.getPrice());
            gymCard.setLocation(gym.getLocation());

            list.add(gymCard);
        }
        return list;
    }

    public List<?> getNameGyms(String name) {
        List <GymListDto> list = new ArrayList<>();

        for (Gym gym : gymRepository.customSearch(name)) {
            GymListDto gymCard = new GymListDto();
            gymCard.setName(gym.getName());
            gymCard.setPrice(gym.getPrice());
            gymCard.setLocation(gym.getLocation());

            list.add(gymCard);
        }
        return list;

    }

}