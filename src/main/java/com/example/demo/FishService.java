package com.example.demo;

import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class FishService {

  private final FishMapper fishMapper;

  public FishService(FishMapper fishMapper) {
    this.fishMapper = fishMapper;
  }

  public List<Fish> getAllFish() {
    return fishMapper.findAll();
  }

  public Fish createFish(Fish fish) {
    fishMapper.insertsave(fish);
    return fish;
  }

  public Fish getFishById(Long id) {
    return fishMapper.findById(id)
        .orElseThrow(
            () -> new FishNotFoundException("指定されたIDの魚は見つかりませんでした: " + id));
  }
}
