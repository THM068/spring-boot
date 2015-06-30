package sample.jsp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;

/**
 * Created by tm1c14 on 30/06/2015.
 */
//@Configuration
public class WebConfig {

    @Bean
    public UrlBasedViewResolver tilesViewReslover() {
        UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        String [] definitions = {
          "/WEB-INF/tiles/views/layouts.xml",
          "/WEB-INF/tiles/views/**/views.xml"
        };

        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(definitions);

        return tilesConfigurer;
    }
}
