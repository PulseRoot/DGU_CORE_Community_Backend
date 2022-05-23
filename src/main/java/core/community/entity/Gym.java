package core.community.entity;

import core.community.dto.GymDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String name;

    private String location;

    private Integer price;

    private String description;

    private String joinedDate;

    public static Gym createGym(GymDto gymDto) {
        Gym gym = new Gym();
        gym.setName(gymDto.getName());
        gym.setPrice(gymDto.getPrice());
        gym.setLocation(gymDto.getLocation());
        gym.setDescription(gymDto.getDescription());
        gym.setJoinedDate(gymDto.getJoinedDate());
        return gym;
    }
}
