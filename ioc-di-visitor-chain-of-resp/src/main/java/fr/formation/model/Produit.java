package fr.formation.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import fr.formation.visitor.annotation.Html;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Produit {
    @Html
    @JsonProperty
    private int id;
    
    @Html
    @JsonProperty
    private String nom;
    
    @Html
    @JacksonXmlProperty
    private BigDecimal prix;
}
