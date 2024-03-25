package com.example.Week11SpringRestClient.services;

import com.example.Week11SpringRestClient.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class AlbumService {

    private final RestClient restClient;

    public AlbumService(){
                restClient = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    //get all albums
    public List<Album> getAlbums(){
        return restClient
                .get()
                .uri("/albums")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Album>>() {
                });
    }

    public Album getAlbumById(Integer id){
        return restClient
                .get()
                .uri("/albums/" + id)
                .retrieve()
                .body(Album.class);
    }

    public Album addAlbum(Album album){
        return restClient
                .post()
                .uri("/albums")
                .body(album)
                .retrieve()
                .body(Album.class);
    }

    public Album updateAlbum(Integer id, Album album) {
        return restClient
                .put()
                .uri("/albums/" + id)
                .body(album)
                .retrieve()
                .body(Album.class);
    }

    public void deleteAlbum(Integer id){
        restClient
                .delete()
                .uri("/albums/" + id)
                .retrieve()
                .body(Void.class);
    }
}
