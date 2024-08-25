package com.example.school.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;


    @NotEmpty(message = "Area cannot be null or empty")
    private String area;

    @NotEmpty(message = "Street cannot be null or empty")
    private String street;

    @NotNull(message = "Building No cannot be null or empty")
    private int buildingNo;


}