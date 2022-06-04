package com.muzix.backend.controller;


import com.muzix.backend.model.Favourite;
import com.muzix.backend.service.FavouriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Slf4j
@CrossOrigin
public class FavouriteController {

    @Autowired
    FavouriteService favouriteService;

    @GetMapping("/test")
    public String testBackend(){
        return "The backend with SpringBoot is running perfectly :)";
    }

    @PostMapping("/add")
    public Favourite addToFavourite(@RequestBody Favourite fav){
        return this.favouriteService.addToFavourites(fav);
    }

    @GetMapping("/get/{userId}")
    public ArrayList<Favourite> getFavourites(@PathVariable String userId){
        return this.favouriteService.getFavourites(userId);
    }

    @GetMapping("/check")
    public boolean checkFavourites(@RequestParam("albumId") String albumId, @RequestParam("userId") String userId){
        return this.favouriteService.checkFavourite(albumId, userId);
    }

}
