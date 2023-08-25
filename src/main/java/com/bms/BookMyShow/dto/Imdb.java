package com.bms.BookMyShow.dto;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Imdb extends BaseModel {
  private int rating;

  @ElementCollection
  private List<String> reviews;//limiting it here
}
