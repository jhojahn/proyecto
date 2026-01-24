package com.example.proyecto.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import
        org.springframework.security.config.annotation.authentication.configuration
                .AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws
            Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                                // Rutas públicas (accesibles sin login)
                                .requestMatchers("/", "/index", "/registro",
                                        "/login").permitAll()
                                .requestMatchers("/css/**", "/js/**",
                                        "/images/**").permitAll()
                                .requestMatchers("/h2-console/**").permitAll() //Solo para desarrollo
                                // Rutas del panel admin (requieren autenticación)
                                .requestMatchers("/admin/**").hasAnyRole("USER",
                                        "ADMIN")
                                // Cualquier otra ruta requiere autenticación
                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                                .loginPage("/login") // Página de login personalizada
                                .loginProcessingUrl("/login") // URL que procesa el login
                                .defaultSuccessUrl("/admin", true) // Redirige aquí tras login exitoso
                                .failureUrl("/login?error=true") // Redirige aquí si falla
                                .permitAll()
                )
                .logout(logout -> logout
                                .logoutUrl("/logout") // URL para hacerlogout
                                .logoutSuccessUrl("/login?logout=true") //Redirige tras logout
                                .permitAll()
                )
                .csrf(csrf -> csrf
                                .ignoringRequestMatchers("/h2-console/**") //Deshabilitar CSRF para H2
                )
                .headers(headers -> headers
                                .frameOptions(frame -> frame.sameOrigin()) //Permitir H2 console en iframe
                );
        return http.build();
    }
}
