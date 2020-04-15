//package tacos.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("Employee1")
//                .password("employee1_password")
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("Employee2")
//                .password("employee1_password")
//                .authorities("ROLE_USER");
//    }
//}
