package sample.jsp.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;

/**
 * Created by tm1c14 on 26/06/2015.
 */
public class ServerCustomization  extends ServerProperties {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        super.customize(container);
        ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/jsp/404.jsp");
        container.addErrorPages(error404);

        ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/jsp/500.jsp");
        container.addErrorPages(error500);

        ErrorPage error405 = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED,"/jsp/error.jsp");
        container.addErrorPages(error405);
        container.addErrorPages(new ErrorPage("/jsp/error.jsp"));

    }
}
