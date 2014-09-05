package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;


@Configuration
public class SecurityConfiguration extends GlobalAuthenticationConfigurerAdapter
{
    @Autowired
    @Qualifier("restSecurityProperties")
    RestSecurityProperties properties;

    @Override
    public void init(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser(properties.username())
                .password(properties.password())
                .roles("USER");
    }
}
