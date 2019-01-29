package org.pursuit.unit_03_assessment.model;

public class Planet {

    /**
     * This class's fields should match the json objects keys in the JSON Response
     *
     * you need a field for name, number, and image with the getter of constructors
     */
    private String planets;

    public String getPlanets() {
        return planets;
    }

    public Planet(String planets) {
        this.planets = planets;
    }
}
