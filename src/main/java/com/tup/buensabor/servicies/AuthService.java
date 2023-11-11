package com.tup.buensabor.servicies;

import com.tup.buensabor.Auth.AuthResponse;
import com.tup.buensabor.Auth.LoginRequest;
import com.tup.buensabor.Auth.RegisterRequest;
import com.tup.buensabor.Jwt.JwtService;
import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.User;
import com.tup.buensabor.enums.Role;
import com.tup.buensabor.repositorios.ClienteRepository;
import com.tup.buensabor.repositorios.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {
    private  final UserRepository userRepository;
    private final ClienteRepository clienteRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    Date date = new Date();
    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
    public AuthResponse register(RegisterRequest request){
        User user=User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .role(Role.CLIENTE)
                .build();
        userRepository.save(user);

        Cliente cliente=Cliente.builder()
                .apellido(request.getApellido())
                .nombre(request.getNombre())
                .telefono(request.getTelefono())
                .email(request.getEmail())
                .fechaAlta(date)
                .fechaModificacion(date)
                .build();
        user.setCliente(cliente);
        clienteRepository.save(cliente);


        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
