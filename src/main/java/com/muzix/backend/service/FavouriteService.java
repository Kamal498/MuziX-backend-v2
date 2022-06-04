package com.muzix.backend.service;

import com.muzix.backend.model.Favourite;
import com.muzix.backend.repository.FavouriteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class FavouriteService {

    @Autowired
    FavouriteRepository repository;


    public ArrayList<Favourite> getFavourites(String userId){
        return repository.findByUserId(userId);
    }

    public Favourite addToFavourites(Favourite f){
        if(checkFavourite(f.getAlbumId(), f.getUserId()))
            log.info("true");
        else log.info("false");
        if(!checkFavourite(f.getAlbumId(), f.getUserId())){
            return repository.save(f);
        }else{
            repository.deleteByAlbumIdAndUserId(f.getAlbumId(), f.getUserId());
            return f;
        }
    }

    public boolean checkFavourite(String albumId, String userId){
        return this.repository.existsByAlbumIdAndUserId(albumId, userId);
    }
}
