package com.bms.BookMyShow.model;

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
public class Movie extends BaseModel {

  private String name;
  /**
   * 1 Movie can have multiple castings -> Avengers has Robert Downey Jr,Chris Evans,Mark Ruffalo,Chris Hemsworth,Scarlett Johansson,Jeremy Renner,Tom Hiddleston,Clark Gregg
   * 1 Casting can work in multiple Movies -> Robert Downey Jr worked on Iron Man (2008),Sherlock Holmes (2009),Chaplin (1992),Avengers: Endgame (2019)
   */
  @ManyToMany
  private List<Casting> castings;
  /**
   * 1 Movie can have multiple Genre -> Avengers has Genre as science fiction, fantasy, and adventure
   * 1 Genre can have multiple Movies -> SciFi movies are Blade Runner (1982),The Matrix (1999),Inception (2010)
   */
//  @ManyToMany
  @ElementCollection
  @Enumerated(EnumType.ORDINAL)
  private List<Genre> genre;
  /**
   * 1 Movie can have 1 IMDB rating. -> Avengers has 5 star rating with reviews associated
   * 1 Imdb can be associated with only 1 Movie -> 5 Star rating with reviews are Avengers,The Matrix
   */
  @OneToOne
  private Imdb imdb;
  /**
   * 1 Movie can have multiple Language -> Avengers is available in English,MandarinChinese,Spanish,Hindi
   * 1 Language can have multiple Movies -> Movies in Hindi are Blade Runner (1982),The Matrix (1999),Inception (2010)
   */
//  @ManyToMany
  @ElementCollection
  @Enumerated(EnumType.ORDINAL)
  private List<Language> languages;
  private float duration;
  /**
   * 1 Movie can have multiple MovieFormat -> Avengers is available in 2D,3D,imax,
   * 1 MovieFormat can have multiple Movies -> Movies available in 2D are Blade Runner (1982),The Matrix (1999),Inception (2010)
   */
//  @ManyToMany
  @ElementCollection
  @Enumerated(EnumType.ORDINAL)
  private List<MovieFormat> movieFormats;
}
