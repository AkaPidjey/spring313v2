package web.spring313v2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import web.spring313v2.security.handler.LoginSuccessHandler;
import web.spring313v2.service.UserServiceImpl;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserServiceImpl userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
    }



        @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.formLogin()
                    // указываем страницу с формой логина
                    .loginPage("/login")
                    //указываем логику обработки при логине
                    .successHandler(new LoginSuccessHandler())
                    // указываем action с формы логина
                    .loginProcessingUrl("/login")
                    // Указываем параметры логина и пароля с формы логина
                    .usernameParameter("login")
                    .passwordParameter("password")
                    // даем доступ к форме логина всем
                    .permitAll();

            http.logout()
                    // разрешаем делать логаут всем
                    .permitAll()
                    // указываем URL логаута
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    // указываем URL при удачном логауте
                    .logoutSuccessUrl("/login?logout")
                    //выклчаем кроссдоменную секьюрность (на этапе обучения неважна)
                    .and().csrf().disable();

            http.authorizeRequests()
                    .antMatchers("/login").anonymous()
                    .antMatchers("/api/user").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/api/**").hasRole("ADMIN")

                    .anyRequest().authenticated();



        }
}



//
//        http.authorizeRequests()
//                .antMatchers("/login").anonymous()
//                .antMatchers("/admin/**").hasAuthority("ADMIN")
//                .antMatchers("/user").hasAnyAuthority("USER", "ADMIN")
//                .anyRequest().authenticated()
//                .and().formLogin().successHandler(new LoginSuccessHandler());









//        http
//                // делаем страницу регистрации недоступной для авторизированных пользователей
//                .authorizeRequests()
//                //страницы аутентификаци доступна всем
//                .antMatchers("/login")
//                .anonymous()
//                // защищенные URL
//                .antMatchers("/admin/**", "/admin/").access("hasAuthority('ADMIN')")
//                .antMatchers("/user", "/user/").access("hasAnyAuthority('USER','ADMIN')")
//                .anyRequest()
//                .authenticated();









//        http
//                // делаем страницу регистрации недоступной для авторизированных пользователей
//                .authorizeRequests()
//                //страницы аутентификаци доступна всем
//                .antMatchers("/api/**").hasRole("ADMIN")
//                .antMatchers("/api/getUser").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/login").anonymous();
//                // защищенные URL
//                .antMatchers("/new_user").permitAll().anyRequest().authenticated();



//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/api/**").hasRole("ADMIN")
//                .antMatchers("/api/getUser").hasAnyRole("USER", "ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/")
//                .failureUrl("/login")
//                .permitAll();



//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/users", "/users/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers(HttpMethod.PUT, "/users", "/users/**").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.POST, "/users", "/users/**").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE, "/users", "/users/**").hasAnyRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/")
//                .failureUrl("/login")
//                .permitAll();
//    }

