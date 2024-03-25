package com.example.Week11SpringRestClient.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album {

    private int id;
    private int userId;
    private String title;

}
