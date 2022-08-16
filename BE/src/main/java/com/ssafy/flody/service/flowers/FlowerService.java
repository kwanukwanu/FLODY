package com.ssafy.flody.service.flowers;

import com.ssafy.flody.dto.response.flowers.GardenResponseDto;

import java.util.List;

public interface FlowerService {
    public List<GardenResponseDto> findFlowers(String email);
    public GardenResponseDto findFlowerById(Long garNo);
    public Long addFlower(String email);
    public GardenResponseDto modifyFlower(Long garNo, int exp);
    public Long removeFlower(Long garNo);
}
