package fr.formation.chainofresp;

import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;
import fr.formation.chainofresp.annotation.Json;
import fr.formation.core.WebApplicationContext.WebMethod;
import fr.formation.http.HttpContentType;
import fr.formation.http.HttpResponse;
import fr.formation.visitor.JsonVisitor;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JsonHandler extends AbstractHandler {
    @Inject
    private JsonVisitor visitor;

    @Override
    public HttpResponse handle(WebMethod webMethod, Object result) {
        if (webMethod.getMethod().isAnnotationPresent(Json.class)) {
            log.debug("JSON est responsable !");

            return HttpResponse.builder()
                .contentType(HttpContentType.APPLICATION_JSON)
                .content(this.visitor.visit(result))
                .build()
            ;
        }

		return super.handle(webMethod, result);
    }
}
