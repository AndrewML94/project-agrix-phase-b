package com.betrybe.agrix.controllers;

import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.services.FertilizerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class responsible for the application's controller layer.
 */
@RestController
public class FertilizerController {
  @Autowired
  private FertilizerService fertilizerService;

  /**
   * Application post method for creating a new fertilizer.
   */
  @PostMapping("/fertilizers")
  public ResponseEntity<Fertilizer> createFertilizer(
      @RequestBody Fertilizer fertilizer) {
    Fertilizer newFertilizer = fertilizerService.createFertilizers(fertilizer);

    return ResponseEntity.status(HttpStatus.CREATED).body(newFertilizer);
  }

  /**
  * Application get method to get all fertilizers.
  */
  @GetMapping("/fertilizers")
  public ResponseEntity<List<Fertilizer>> getAllFertilizer() {
    List<Fertilizer> allFertilizer = fertilizerService.getAllFertilizer();

    return ResponseEntity.ok().body(allFertilizer);
  }
}
