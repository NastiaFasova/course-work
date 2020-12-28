package ipk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(getEncoder());
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/register")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/{id}/update-speciality",
                        "/create-speciality", "{id}/delete-speciality")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/create-subject",
                        "/update-subject/{id}")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/create-teacher",
                        "/update-teacher/{id}")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/{id}/create-group",
                        "/update/{group-id}", "/update/{id}", "/{id}/create-listener",
                        "/{id}/update-listener", "/{id}/delete/{group-id}",
                        "/{id}/delete-listener/{listener-id}", "{id}/delete-lesson/{lesson-id}",
                        "{id}/create-lesson", "{id}/update-lesson",
                        "/{id}/update-lesson/{lesson-id}")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/", "/{id}/listeners",
                        "/{id}/timetable", "/subjects", "/teachers")
                .access("hasRole('ADMIN') or hasRole('LISTENER')")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .and()
                .csrf()
                .disable();
    }
}
