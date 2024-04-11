@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/login/**", "/login/oauth2/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2Login();
    }
}
