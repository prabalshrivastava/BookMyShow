package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Cast extends BaseModel {
  private Profile profile;
  private CastType castType;
  /**
   * 1 Cast can work in multiple Movies -> Robert Downey Jr worked on Iron Man (2008),Sherlock Holmes (2009),Chaplin (1992),Avengers: Endgame (2019)
   * 1 Movie can have multiple casts -> Avengers has Robert Downey Jr,Chris Evans,Mark Ruffalo,Chris Hemsworth,Scarlett Johansson,Jeremy Renner,Tom Hiddleston,Clark Gregg
   */
  @ManyToMany
  private List<Movie> movies;
}
