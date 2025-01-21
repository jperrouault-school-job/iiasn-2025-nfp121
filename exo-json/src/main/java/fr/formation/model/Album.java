package fr.formation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class Album {
    private int id;
    private String name;
}
