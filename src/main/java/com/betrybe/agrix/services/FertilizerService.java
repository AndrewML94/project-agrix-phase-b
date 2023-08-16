package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class responsible for the application's service layer.
 */
@Service
public class FertilizerService {
  @Autowired
  private FertilizerRepository fertilizerRepository;

  public Fertilizer createFertilizers(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }
}
