package com.darkgolly.task.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private String lastName;
    private String firstName;
    private String patronymic;
    private String email;
    private String phoneNumber;
}