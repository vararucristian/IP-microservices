package com.microservices.moviecatalogservices;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        List<CatalogItem> catalogItems = new ArrayList<CatalogItem>();
        catalogItems.add(new CatalogItem("Harry Potter1","magic",5));
        catalogItems.add(new CatalogItem("Harry Potter2","magic",3));
        catalogItems.add(new CatalogItem("Harry Potter3","magic",5));
            return Collections.singletonList(
                    catalogItems.get(Integer.parseInt(userId)));
    }


}
