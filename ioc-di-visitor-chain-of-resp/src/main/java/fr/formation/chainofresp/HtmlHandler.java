package fr.formation.chainofresp;

import java.util.List;

import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;
import fr.formation.core.WebApplicationContext.WebMethod;
import fr.formation.http.HttpContentType;
import fr.formation.http.HttpResponse;
import fr.formation.visitor.HtmlVisitor;
import fr.formation.visitor.annotation.Html;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class HtmlHandler extends AbstractHandler {
    @Inject
    private HtmlVisitor visitor;

    @Override
    public HttpResponse handle(WebMethod webMethod, Object result) {
        if (webMethod.getMethod().isAnnotationPresent(Html.class)) {
            String html = "";

            log.debug("HTML est responsable !");

            if (result instanceof List listResult) {
                html = this.visitor.visit(listResult);
            }

            else {
                html = this.visitor.visit(result);
            }

            return HttpResponse.builder()
                .contentType(HttpContentType.TEXT_HTML)
                .content(html)
                .build()
            ;
        }

		return super.handle(webMethod, result);
    }
}
