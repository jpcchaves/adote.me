package com.jpcchaves.adotar.application.service.usecases;

import com.jpcchaves.adotar.application.dto.pet.PetCharacteristicsDto;
import java.util.List;

public interface PetCharacteristicService {
  List<PetCharacteristicsDto> getAll();
}
