package com.darkgolly.task.services;

import com.darkgolly.task.entities.ContactDTO;
import com.darkgolly.task.entities.User;
import com.darkgolly.task.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    private UserRepository userRepository;

    public List<ContactDTO> getAllContacts() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToContactDTO).collect(Collectors.toList());
    }

    public ContactDTO getContactById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return mapToContactDTO(user);
    }

    public ContactDTO updateContact(Long id, ContactDTO contactDTO) {
        User user = userRepository.findById(id).orElseThrow();
        user.setLastName(contactDTO.getLastName());
        user.setFirstName(contactDTO.getFirstName());
        user.setPatronymic(contactDTO.getPatronymic());
        user.setEmail(contactDTO.getEmail());
        user.setPhoneNumber(contactDTO.getPhoneNumber());
        User updatedUser = userRepository.save(user);
        return mapToContactDTO(updatedUser);
    }
    public void deleteContact(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setLastName(null);
        user.setFirstName(null);
        user.setPatronymic(null);
        user.setEmail(null);
        user.setPhoneNumber(null);
        userRepository.save(user);
    }
    private ContactDTO mapToContactDTO(User user) {
        return ContactDTO.builder()
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .patronymic(user.getPatronymic())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
