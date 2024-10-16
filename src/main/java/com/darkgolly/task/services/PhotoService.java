package com.darkgolly.task.services;

import com.darkgolly.task.entities.PhotoDTO;
import com.darkgolly.task.entities.User;
import com.darkgolly.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private UserRepository userRepository;

    public PhotoDTO getPhotoById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return mapToPhotoDTO(user);
    }

    public PhotoDTO updatePhoto(Long id, PhotoDTO photoDTO) {
        User user = userRepository.findById(id).orElseThrow();
        user.setPhoto(photoDTO.getPhoto());
        User updatedUser = userRepository.save(user);
        return mapToPhotoDTO(updatedUser);
    }

    private PhotoDTO mapToPhotoDTO(User user) {
        return PhotoDTO.builder()
                .photo(user.getPhoto())
                .build();
    }

    public void deletePhoto(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setPhoto(null);
        userRepository.save(user);
    }

    public List<PhotoDTO> getAllPhotos() {
        List<User> users = userRepository.findAll();
        List<PhotoDTO> photos = new ArrayList<>();

        for (User user : users) {
            photos.add(mapToPhotoDTO(user));
        }
        return photos;
    }
}
