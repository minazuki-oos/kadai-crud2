package com.example.demo;// FishController.java

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/fish_database")
public class FishController {

  private final FishService fishService;

  public FishController(FishService fishService) {
    this.fishService = fishService;
  }

  @GetMapping
  public ResponseEntity<String> getFishDatabase() {
    return ResponseEntity.ok("Fish database is available!");
  }

  @PostMapping
  public ResponseEntity<Fish> createFish(@RequestBody Fish fish, UriComponentsBuilder uriBuilder) {
    Fish createdFish = fishService.createFish(fish);

    // 新しい魚のURIを構築
    URI location = uriBuilder.path("/fish_database/{id}")
        .buildAndExpand(createdFish.getId())
        .toUri();

    // HTTPステータス201 (Created) とともに新しい魚の情報を含むレスポンスを返す
    return ResponseEntity.created(location).body(createdFish);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Fish> getFishById(
      @PathVariable Long id) {  // Fish を ResponseEntity<Fish> に変更
    Fish fish = fishService.getFishById(id);
    return ResponseEntity.ok(fish);
  }

  @GetMapping("/all_fish")
  public ResponseEntity<List<Fish>> getAllFish() {
    List<Fish> allFish = fishService.getAllFish();
    return ResponseEntity.ok(allFish);
  }
}
