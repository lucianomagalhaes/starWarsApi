package com.b2wdigital.desafio.model;

import java.net.URI;
import java.util.Date;
import java.util.List;


public class PlanetaSwapi {

	private String gravity;
	private String terrain;
	private Date created;
	private List<Object> residents = null;
	private String surface_water;
    private Date edited;
    private List<Object> films = null;
    private String climate;
    private String name;
    private String diameter;
    private String population;
    private String rotation_period;
    private URI url;
    private String orbital_period;

    public PlanetaSwapi() {}

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Object> getResidents() {
        return residents;
    }

    public void setResidents(List<Object> residents) {
        this.residents = residents;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }

    public Date getEdited() {
        return edited;
    }

    public void setEdited(Date edited) {
        this.edited = edited;
    }

    public List<Object> getFilms() {
        return films;
    }

    public void setFilms(List<Object> films) {
        this.films = films;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }
}
