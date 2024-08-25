package com.example.school.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Address {

    @Id
    private Integer id;

    @NotEmpty(message = "must be not Empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;

    @NotEmpty(message = "must be not Empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;

    @NotNull(message = "must be not null")
    @Column(columnDefinition = "int not null")
    private int buildingNo;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}