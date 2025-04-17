package fr.formation.chainofresp;

import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;
import fr.formation.chainofresp.annotation.Xml;
import fr.formation.core.WebApplicationContext.WebMethod;
import fr.formation.http.HttpContentType;
import fr.formation.http.HttpResponse;
import fr.formation.visitor.XmlVisitor;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class XmlHandler extends AbstractHandler {
    @Inject
    private XmlVisitor visitor;

    @Override
    public HttpResponse handle(WebMethod webMethod, Object result) {
        if (webMethod.getMethod().isAnnotationPresent(Xml.class)) {
            log.debug("XML est responsable !");

            return HttpResponse.builder()
                .contentType(HttpContentType.TEXT_HTML)
                .content(this.visitor.visit(result))
                .build()
            ;
        }

		return super.handle(webMethod, result);
    }
}
