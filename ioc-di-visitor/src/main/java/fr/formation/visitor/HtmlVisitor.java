package fr.formation.visitor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.formation.annotation.Component;
import fr.formation.visitor.annotation.Html;

@Component
public class HtmlVisitor {
    public String visit(Object visitable) {
        StringBuilder sb = new StringBuilder();

        sb.append("<ul>");
        for (Map.Entry<String, String> propValue : this.findPropsValues(visitable).entrySet()) {
            sb.append("<li>");
            sb.append(propValue.getKey());
            sb.append(" -> ");
            sb.append(propValue.getValue());
            sb.append("</li>");
        }
        sb.append("</ul>");

        return sb.toString();
    }

    public String visit(List<Object> visitables) {
        StringBuilder sb = new StringBuilder();

        sb.append("<table>");

        for (int i = 0; i < visitables.size(); i++) {
            var visitable = visitables.get(i);

            if (i == 0) {
                sb.append("<thead><tr>");
                for (String key : this.findPropsValues(visitable).keySet()) {
                    sb.append("<th>");
                    sb.append(key);
                    sb.append("</th>");
                }
                sb.append("</tr></thead>");
            }

            sb.append("<tr>");
            for (String value : this.findPropsValues(visitable).values()) {
                sb.append("<td>");
                sb.append(value);
                sb.append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</table>");

        return sb.toString();
    }

    private Map<String, String> findPropsValues(Object visitable) {
        Map<String, String> propsValues = new HashMap<>();

        for (Field f : visitable.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(Html.class)) {
                try {
                    f.setAccessible(true);
                    propsValues.put(f.getName(), f.get(visitable).toString());
                }
                
                catch (Exception e) {
                    propsValues.put(f.getName(), "erreur");
                }
            }
        }

        return propsValues;
    }
}
