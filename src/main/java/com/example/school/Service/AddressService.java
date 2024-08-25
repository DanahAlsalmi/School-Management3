package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.DTO.AddressDTO;
import com.example.school.Model.Teacher;
import com.example.school.Model.Address;
import com.example.school.Repository.TeacherRepository;
import com.example.school.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    //Get
    public List<Address> getAddress() {
        return addressRepository.findAll();
    }

    //Add
    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherByid(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("Teacher Not Found");
        }

        Address address1 = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNo(), teacher);
        addressRepository.save(address1);


    }
    //Update
    public void updateAddress(AddressDTO addressDTO) {
            Address address1 = addressRepository.findAddressByid(addressDTO.getTeacher_id());
        if (address1 == null) {
            throw new ApiException("Teacher Not Found");
        }
        address1.setArea(addressDTO.getArea());
        address1.setStreet(addressDTO.getStreet());
        address1.setBuildingNo(addressDTO.getBuildingNo());
        addressRepository.save(address1);
    }

    //Delete
    public void deleteAddress(Integer id) {
        Teacher address = teacherRepository.findTeacherByid(id);
        if (address == null) {
            throw new ApiException("Address Not Found");
        }
        teacherRepository.delete(address);
    }
    //Details
    public Teacher getTeacherDetails(Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherByid(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher Not Found");
        }
        return teacher;
    }

}