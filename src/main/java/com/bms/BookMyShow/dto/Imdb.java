package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Imdb extends BaseModel {
  private int rating;
  private List<String> reviews;//limiting it here
}
