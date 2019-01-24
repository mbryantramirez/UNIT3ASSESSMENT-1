package org.pursuit.unit_03_assessment.model;

import java.util.List;

public class PlanetResponse {
    private List<Planet> planets;

    public PlanetResponse(List<Planet> planets) {
        this.planets = planets;
    }

    public List<Planet> getPlanets() {
        return planets;
    }
}
