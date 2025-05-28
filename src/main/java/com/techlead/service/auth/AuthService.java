package com.techlead.service.auth;

import com.techlead.dto.request.auth.LoginDTO;
import com.techlead.dto.request.auth.RegisterDTO;

public interface AuthService {
    String login(LoginDTO loginDTO);
    void register(RegisterDTO registerDTO);
}
