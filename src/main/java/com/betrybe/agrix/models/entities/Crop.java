package com.betrybe.agrix.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
* Class responsible for parameterized attributes of the Crop table. 
*/
@Entity
@Table(name = "crop")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;
  
  private Double plantedArea;

  /**
  * Many-to-one relationship with the Farm table.
  */
  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  /**
  * Method responsible for capturing the id.
  */
  public Integer getId() {
    return id;
  }

  /**
  * Method responsible for inserting the id.
  */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
  * Method responsible for capturing the farmId.
  */
  public Farm getFarm() {
    return farm;
  }

  /**
  * Method responsible for inserting the farmId.
  */
  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  /**
  * Method responsible for capturing the name.
  */
  public String getName() {
    return name;
  }

  /**
  * Method responsible for inserting the name.
  */
  public void setName(String name) {
    this.name = name;
  }

  /**
  * Method responsible for capturing the plantedArea.
  */
  public Double getPlantedArea() {
    return plantedArea;
  }

  /**
  * Method responsible for inserting the plantedArea.
  */
  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }
}
