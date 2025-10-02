package org.lessons.java.esao_backoffice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "records")
public class Record {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "Il titolo del disco deve essere inserito")
  private String title;

  @NotBlank(message = "Un disco deve avere un artista")
  private String artist;

  @NotBlank(message = "È obbligatorio specificare in che anno è stato pressato il disco")
  @Column(name = "pressing_year")
  private String pressingYear;

  @Column(name = "is_first_press")
  private Boolean isFirstPress;

  private String duration;

  @Lob
  private String description;

  @Column(name = "listening_link")
  private String listeningLink;

  @Column(name = "cover_path")
  private String coverPath;

  @OneToMany(mappedBy = "record")
  private List<Track> tracks;

  @ManyToOne
  @JoinColumn(name = "condition_id", nullable = false)
  @JsonBackReference
  private Condition condition;

  public Record() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getPressingYear() {
    return pressingYear;
  }

  public void setPressingYear(String pressingYear) {
    this.pressingYear = pressingYear;
  }

  public Boolean getIsFirstPress() {
    return isFirstPress;
  }

  public void setIsFirstPress(Boolean isFirstPress) {
    this.isFirstPress = isFirstPress;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getListeningLink() {
    return listeningLink;
  }

  public void setListeningLink(String listeningLink) {
    this.listeningLink = listeningLink;
  }

  public String getCoverPath() {
    return coverPath;
  }

  public void setCoverPath(String coverPath) {
    this.coverPath = coverPath;
  }

  public List<Track> getTracks() {
    return tracks;
  }

  public void setTracks(List<Track> tracks) {
    this.tracks = tracks;
  }

  public Condition getCondition() {
    return condition;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

}
