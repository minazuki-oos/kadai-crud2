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
    List<Fish> fishList = fishMapper.findAll();
    return fishList;
  }

  public Fish createFish(Fish fish) {
    // 作成ロジックを実装
    fishMapper.save(fish);
    // 戻り値がないので、何も返さない（void）
    return fish;
  }


  public Fish getFishById(Long id) {
    // IDを使用してFishを取得するロジックを実装
    Fish fish = fishMapper.findById(id).orElse(new Fish("魚がいません", "")); // 引数を受け取るコンストラクタを使用
    return fish;
  }
}
