package fr.formation.chainofresp;

import fr.formation.core.WebApplicationContext.WebMethod;
import fr.formation.http.HttpResponse;

public abstract class AbstractHandler {
    protected AbstractHandler next = null;

	public HttpResponse handle(WebMethod webMethod, Object result) {
		if (this.next != null) {
			return this.next.handle(webMethod, result);
		}

		return null;
	}
	
	public AbstractHandler chain(AbstractHandler hdlr) {
		this.next = hdlr;

		return hdlr;
	}
}
