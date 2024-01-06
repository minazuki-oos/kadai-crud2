package com.example.demo;

public class FishNotFoundException extends RuntimeException {
  public FishNotFoundException(String message) {
    super(message);
  }
}
