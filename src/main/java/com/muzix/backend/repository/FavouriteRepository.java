package com.muzix.backend.repository;

import com.muzix.backend.model.Favourite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FavouriteRepository extends MongoRepository<Favourite, String> {
    public ArrayList<Favourite> findByUserId(String username);

    public boolean existsByAlbumIdAndUserId(String albumId, String userId);
    public Favourite deleteByAlbumIdAndUserId(String albumId, String userId);
}
