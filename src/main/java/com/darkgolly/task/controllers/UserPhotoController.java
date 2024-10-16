package com.darkgolly.task.controllers;

import com.darkgolly.task.entities.PhotoDTO;
import com.darkgolly.task.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/photos")
public class UserPhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/{id}")
    public ResponseEntity<PhotoDTO> getPhotoById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(photoService.getPhotoById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhotoDTO> updatePhoto(@PathVariable("id") Long id, @RequestBody PhotoDTO photoDTO) {
        return new ResponseEntity<>(photoService.updatePhoto(id, photoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable("id") Long id) {
        photoService.deletePhoto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
