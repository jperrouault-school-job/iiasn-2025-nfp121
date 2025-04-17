package fr.formation.visitor;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;

@Component
public class JsonVisitor {
    @Inject
    private ObjectMapper mapper;

    public String visit(Object visitable) {
        try {
            return mapper.writeValueAsString(visitable);
        }

        catch (Exception e) {
            return "error json";
        }
    }
}
