package com.jpcchaves.adotar.application.service.usecases;

import com.jpcchaves.adotar.application.dto.state.StateDto;
import java.util.List;

public interface StateService {
  List<StateDto> getAll();

  StateDto getByNameOrUf(String nameOrUf);
}
