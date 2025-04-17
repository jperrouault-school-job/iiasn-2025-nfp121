package fr.formation.visitor;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import fr.formation.annotation.Component;
import fr.formation.annotation.Inject;

@Component
public class XmlVisitor {
    @Inject
    private XmlMapper mapper;

    public String visit(Object visitable) {
        try {
            return mapper.writeValueAsString(visitable);
        }

        catch (Exception e) {
            return "error json";
        }
    }
}
