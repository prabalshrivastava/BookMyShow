package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Movie extends BaseModel {
  private String name;
  private List<Cast> casts;
  private List<Genre> genre;
  private Imdb imdb;
  private List<Language> languages;
  private float duration;
  private List<MovieFormat> movieFormats;
}
