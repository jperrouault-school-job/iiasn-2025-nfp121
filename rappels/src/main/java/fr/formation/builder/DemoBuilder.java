package fr.formation.builder;

import lombok.Builder;

@Builder
public class DemoBuilder {
    private String d1;
    private String d2;
    private String d3;
    private String d4;
    private String d5;

    // public static DemoBuilderBuilder builder() {
    //     return new DemoBuilderBuilder();
    // }

    // public static class DemoBuilderBuilder {
    //     public DemoBuilderBuilder d1(String d1) {
    //         return this;
    //     }

    //     public DemoBuilderBuilder d2(String d2) {
    //         return this;
    //     }
    // }
}
