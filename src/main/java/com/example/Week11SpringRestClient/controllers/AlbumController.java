package com.example.Week11SpringRestClient.controllers;


import com.example.Week11SpringRestClient.models.Album;
import com.example.Week11SpringRestClient.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album/api/v1")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    //get all albums
    @GetMapping("/albums")
    public List<Album> getAlbums(){
        return this.albumService.getAlbums();
    }

    @GetMapping("/albums/{id}")
    public Album getAlbumById(@PathVariable Integer id){
        return this.albumService.getAlbumById(id);
    }

    @PostMapping("/albums")
    public Album addAlbum(@RequestBody Album album){
        return this.albumService.addAlbum(album);
    }

    @PutMapping("/albums/{id}")
    public Album updateAlbum(@PathVariable Integer id, @RequestBody Album album){
        return this.albumService.updateAlbum(id,album);
    }

    @DeleteMapping("/albums/{id}")
    public void deleteAlbum(@PathVariable Integer id){
        this.albumService.deleteAlbum(id);
    }

}
