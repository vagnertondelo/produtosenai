package com.api.produto.auth.controller;

import com.api.produto.auth.dto.ForgotPasswordRequestDto;
import com.api.produto.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword
            (@RequestBody @Valid ForgotPasswordRequestDto forgotPasswordRequestDto) {
        try {
            authService.forgotPassword(forgotPasswordRequestDto);
            return ResponseEntity.ok("E-mail enviado com sucesso!");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body("Erro: "+ e.getMessage());
        }
    }

}
