package com.ssafy.flody.service.flowers;

import com.ssafy.flody.domain.flowers.Flowers;
import com.ssafy.flody.domain.flowers.FlowersRepository;
import com.ssafy.flody.domain.flowers.gardens.Gardens;
import com.ssafy.flody.domain.flowers.gardens.GardensRepository;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.flowers.GardenCreateRequestDto;
import com.ssafy.flody.dto.response.flowers.GardenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlowerServiceImpl implements FlowerService {
    private final GardensRepository gardenRepository;
    private final UsersRepository userRepository;
    private final FlowersRepository flowerRepository;

    // commit 시켜줘
    public List<GardenResponseDto> findFlowers(String email) {
        List<Gardens> entityList = gardenRepository.findAllByUser(findUser(email));
        List<GardenResponseDto> list = new ArrayList<>();
        for (Gardens garden : entityList) {
            list.add(new GardenResponseDto(garden));
        }
        return list;
    }

    public GardenResponseDto findFlowerById(Long garNo) {
        return new GardenResponseDto(gardenRepository.findById(garNo)
                .orElseThrow(() -> new IllegalArgumentException("Garden Not Found")));
    }

    public Long addFlower(String email) {
        GardenCreateRequestDto requestDto = new GardenCreateRequestDto();
        return gardenRepository.save(
                requestDto.toEntity(findFlower(requestDto.getName()), findUser(email))
        ).getGarNo();
    }

    public GardenResponseDto modifyFlower(Long garNo, int exp) {
        Gardens garden = findGarden(garNo);
        Long floNo = garden.getFlower().getFloNo();
        if (!garden.getFlower().getFloNo().equals(7L)) {
            if (garden.getExp() + exp < 100) {
                garden.addExp(exp);
            } else {
                garden.evolve(flowerRepository.findById(floNo + 1L)
                        .orElseThrow(() -> new IllegalArgumentException("Flower Not Found")));
                if (garden.getFlower().getFloNo().equals(7L)) {
                    garden.bloom();
                } else {
                    garden.addExp(exp - 100);
                }
            }
        }
        return new GardenResponseDto(gardenRepository.save(garden));
    }

    public Long removeFlower(Long garNo) {
        gardenRepository.delete(findGarden(garNo));
        return garNo;
    }

    public Gardens findGarden(Long garNo) {
        return gardenRepository.findById(garNo)
                .orElseThrow(() -> new IllegalArgumentException("Garden Not Found"));
    }

    public Users findUser(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    }

    public Flowers findFlower(String name) {
        return flowerRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Flower Not Found"));
    }
}
