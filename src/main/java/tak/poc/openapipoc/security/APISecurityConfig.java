package tak.poc.openapipoc.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import tak.poc.openapipoc.ApplicationConstant;

@EnableWebSecurity
public class APISecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthicationTokenFilter filter = new AuthicationTokenFilter();
        filter.setAuthenticationManager(new GASAuthenticationManager());

        http.addFilter(filter);

        http.antMatcher(ApplicationConstant.CONTEXT_PATH_ANY)
                .csrf()
                    .disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .addFilter(filter)
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated();
    }

}
