package com.example.demo;// FishController.java

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<Fish> createFish(@RequestBody Fish fish) {
    Fish createdFish = fishService.createFish(fish);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdFish);
  }

  @GetMapping("/{id}")
  public Fish getFishById(@PathVariable Long id) {
    return fishService.getFishById(id);
  }


}

