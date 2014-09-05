package quoters;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class RestSecurityProperties
{
    private Properties properties = new Properties();

    @PostConstruct
    public void init() throws IOException
    {
        InputStream is = getClass().getResourceAsStream("/security/security.properties");
        properties.load(is);

    }

    public String username()
    {
        return properties.getProperty("username");
    }

    public String password()
    {
        return properties.getProperty("password");
    }
}
