package com.example.school.Controller;

import com.example.school.DTO.AddressDTO;
import com.example.school.Model.Teacher;
import com.example.school.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity getAddress() {
        return ResponseEntity.status(200).body(addressService.getAddress());
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO profile) {
        addressService.addAddress(profile);
        return ResponseEntity.status(200).body("Address added successfully");

    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO profile) {
        addressService.updateAddress(profile);
        return ResponseEntity.status(200).body("Address updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Address deleted successfully");
    }
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer teacherId) {
        Teacher teacher = addressService.getTeacherDetails(teacherId);
        return ResponseEntity.status(200).body(teacher);
    }
}