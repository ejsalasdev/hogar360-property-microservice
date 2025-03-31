package com.powerup.propertymicroservice.infrastructure.endpoints.rest;

import com.powerup.propertymicroservice.application.dto.request.SaveDepartmentRequest;
import com.powerup.propertymicroservice.application.dto.response.SaveDepartmentResponse;
import com.powerup.propertymicroservice.application.handler.DepartmentHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {
    
    private final DepartmentHandler departmentHandler;
    
    /*@PostMapping
    public ResponseEntity<SaveDepartmentResponse> save(@RequestBody SaveDepartmentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentHandler.save(request));
    }*/
}
