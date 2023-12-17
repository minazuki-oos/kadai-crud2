package com.example.demo;

public class Fish {

  private Long id;
  private String name;
  private String color; // 追加した行

  // コンストラクタ
  public Fish(String name, String color) {
    this.name = name;
    this.color = color;
  }
  // Getter, Setter, Constructors

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
