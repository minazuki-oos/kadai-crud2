package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FishMapper {

  @Select("SELECT * FROM fish")
  List<Fish> findAll();

  @Insert("INSERT INTO fish (name, color) VALUES (#{name}, #{color})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int save(Fish fish); // 修正: 戻り値をint型に変更

  @Select("SELECT * FROM fish WHERE id = #{id}")
  Optional<Fish> findById(Long id);

}
