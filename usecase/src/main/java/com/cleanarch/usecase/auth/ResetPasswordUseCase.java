package com.cleanarch.usecase.auth;

import com.cleanarch.usecase.auth.dto.*;
import com.cleanarch.usecase.common.dto.*;

public interface ResetPasswordUseCase {

  MessageResponseDTO resetPassword(BasePasswordResetTokenRequestDTO requestDTO);
}
