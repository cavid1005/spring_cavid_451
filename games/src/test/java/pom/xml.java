package pom;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // открытый эндпоинт
                        .requestMatchers("/login").permitAll()

                        // GET-эндпоинты: USER и ADMIN
                        .requestMatchers(HttpMethod.GET,
                                "/api/books",
                                "/api/books/paginated",
                                "/api/authors")
                        .hasAnyRole("USER", "ADMIN")

                        // админские эндпоинты (create/update/delete и т.д.)
                        .requestMatchers("/api/books/**").hasRole("ADMIN")
                        .requestMatchers("/api/authors/**").hasRole("ADMIN")

                        // всё остальное: только после аутентификации
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
public class xml {
}
