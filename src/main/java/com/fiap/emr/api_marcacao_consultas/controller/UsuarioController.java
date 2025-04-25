package com.fiap.emr.api_marcacao_consultas.controller;

import com.fiap.emr.api_marcacao_consultas.model.Usuario;
import com.fiap.emr.api_marcacao_consultas.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final JwtTokenProvider jwtTokenProvider;

    public UsuarioController(UsuarioService usuarioService, JwtTokenProvider jwtTokenProvider){
        this.usuarioService = usuarioService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try{
            Usuario usuario = usuarioService.autenticar(loginRequest.getEmail(), loginRequest.getSenha());
            String token = jwtTokenProvider.gerarToken(usuario.getEmail());
            return ResponseEntity.ok().body(Map.of("token", token));
        } catch(RuntimeException e){
            return ResponseEntity.status(httpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}
