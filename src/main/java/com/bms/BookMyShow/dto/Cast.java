package com.bms.BookMyShow.dto;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Cast extends BaseModel {
  /**
   * 1 Cast can have 1 Profile ->  Robert Downey Jr is an Actor/Male/Height: 1.74 m
   * 1 Profile can be associated with a single Cast -> Actor/Male/Height: 1.74 m is  Robert Downey Jr
   */
  @OneToOne
  private Profile profile;
  /**
   * 1 Cast can have multiple CastType ->  Shah Rukh Khan is an Actor,Producer
   * 1 CastType can be associated with a multiple Cast -> Actor,Producer are Shah Rukh Khan,Amir Khan
   */
//  @ManyToMany
  @ElementCollection
  @Enumerated(EnumType.ORDINAL)
  private List<CastType> castType;
  /**
   * 1 Cast can work in multiple Movies -> Robert Downey Jr worked on Iron Man (2008),Sherlock Holmes (2009),Chaplin (1992),Avengers: Endgame (2019)
   * 1 Movie can have multiple casts -> Avengers has Robert Downey Jr,Chris Evans,Mark Ruffalo,Chris Hemsworth,Scarlett Johansson,Jeremy Renner,Tom Hiddleston,Clark Gregg
   */
  @ManyToMany
  private List<Movie> movies;
}
