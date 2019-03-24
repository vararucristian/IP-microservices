package com.example.carsmicroservices;

import com.example.carsowners.CarOwner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarsResources {
    List<CarsInfo> carsInfos=new ArrayList<CarsInfo>();
    @RequestMapping("/info/{carId}")
    public void add(){
        this.carsInfos.add(new CarsInfo("Audi","A7",2008,10000,
                new CarOwner("Alex","Hab","Germany"),260000));

        this.carsInfos.add(new CarsInfo("Bmw","M3",2010,8000,
                new CarOwner("Alex","Hab2","Germany"),280000));

        this.carsInfos.add(new CarsInfo("Renault","Symbol",2016,13000,
                new CarOwner("Alex","Hab5","France"),140000));

    }
    public List<String> getCarInfo(@PathVariable("carId") String carId){
        this.add();
        List<String> carInfo=new ArrayList<String>();
        carInfo.add("Model: "+carsInfos.get(Integer.parseInt(carId)).getCarModel());
        carInfo.add("Manufacturer: "+carsInfos.get(Integer.parseInt(carId)).getCarManufacturer());
        carInfo.add("Year of fabrication: "+String.valueOf(carsInfos.get(Integer.parseInt(carId)).getCarYearOfFabrication()));
        carInfo.add("Number of kilometers: "+String.valueOf(carsInfos.get(Integer.parseInt(carId)).getNrOfKilometers()));
        carInfo.add("Price: "+ String.valueOf(carsInfos.get(Integer.parseInt(carId)).getCarPrice()));
        return carInfo;
    }
    @RequestMapping("/owner/{carId}")
    public CarOwner getCarOwner(@PathVariable("carId") String carId){
        this.add();
        return carsInfos.get(Integer.parseInt(carId)).getCarOwners();
    }

    @RequestMapping("/price/{carId}")
    public ResponseEntity<String> getPrice(@PathVariable("carId") String carId){
        this.add();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("quantity", String.valueOf(carsInfos.get(Integer.parseInt(carId)).getCarPrice()));
       return new RestTemplate().getForEntity(
                "http://localhost:8100/currency-converter/from/EUR/to/RON/quantity/{quantity}", String.class,
               uriVariables);

    }
}
