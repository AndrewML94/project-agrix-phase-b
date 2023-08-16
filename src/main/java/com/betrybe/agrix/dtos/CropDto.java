package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Farm;

/**
* Java Record.
*/
public record CropDto(String name, Double plantedArea, Farm farm) {
}
