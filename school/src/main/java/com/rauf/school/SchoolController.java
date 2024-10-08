package com.rauf.school;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody School school) {
        service.saveSchool(school);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<School>> findAll() {

        return ResponseEntity.ok(service.findAllSchools());
    }
    @GetMapping("/getSchoolWithStudents/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findAllSchools(
            @PathVariable ("schoolId")Integer schoolId) {

        return ResponseEntity.ok(service.findSchoolWithStudents(schoolId));
    }
}
