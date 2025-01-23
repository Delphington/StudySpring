package dev.delphington.securityApp.config;

import dev.delphington.securityApp.servies.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    //свою форму
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Сюда поппадает http - зарпрос
        //Конфигурирус сам Spring Security
        //Конфигурируем авторизацию

        http.
                authorizeRequests()
                .antMatchers("/auth/login", "/auth/registration", "/error").permitAll() //Эти странички доступны всем
                .anyRequest().authenticated().and()
                .formLogin().
                loginPage("/auth/login") // Какую страничку хотим показать
                .loginProcessingUrl("/process_login") // куда будут отправленны данные
                .defaultSuccessUrl("/hello") //Хотим куда перенаправил, после успешной аутентификации
                .failureUrl("/auth/login?error") //перевод на страницу, если аутентификация неуспешна
                .and()
                .logout()  //При переходе на эту строничку будет Logout
                .logoutUrl("/logout")  // будет удаляться из сессии и стираться cookies
                .logoutSuccessUrl("/auth/login");
    }


    //Настраиваем аутентификацию
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personDetailsService).passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}