package com.betrybe.agrix.dtos;

/**
* Java Record.
*/
public record CropResponseDto(Integer id, String name, Double plantedArea, Integer farmId) { 
}
