package com.example.carsmicroservices;

import com.example.carsowners.CarOwner;

import java.util.List;

public class CarsInfo {
    private String carManufacturer;
    private String carModel;
    private int carYearOfFabrication;
    private int carPrice;
    private CarOwner carOwners;
    private int nrOfKilometers;
    private String carSerie;

    public CarsInfo(String carManufacturer, String carModel, int carYearOfFabrication, int carPrice, CarOwner carOwners, int nrOfKilometers) {
        this.carManufacturer = carManufacturer;
        this.carModel = carModel;
        this.carYearOfFabrication = carYearOfFabrication;
        this.carPrice = carPrice;
        this.carOwners = carOwners;
        this.nrOfKilometers = nrOfKilometers;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarYearOfFabrication() {
        return carYearOfFabrication;
    }

    public void setCarYearOfFabrication(int carYearOfFabrication) {
        this.carYearOfFabrication = carYearOfFabrication;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public CarOwner getCarOwners() {
        return carOwners;
    }

    public void setCarOwners(CarOwner carOwners) {
        this.carOwners = carOwners;
    }

    public int getNrOfKilometers() {
        return nrOfKilometers;
    }

    public void setNrOfKilometers(int nrOfKilometers) {
        this.nrOfKilometers = nrOfKilometers;
    }
}
