package sample.jsp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.web.ServerProperties;

/**
 * Created by tm1c14 on 26/06/2015.
 */
@Configuration
public class ServerPropertiesConfig {

    @Bean
    public ServerProperties serverProperties() {
        return new ServerCustomization();
    }
}
