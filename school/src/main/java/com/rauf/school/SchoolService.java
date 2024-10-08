package com.rauf.school;

import com.rauf.school.School;
import com.rauf.school.SchoolRepository;
import com.rauf.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;
    public FullSchoolResponse findSchoolWithStudents(Integer schoolId){
        var school=repository.findById(schoolId).
                orElse(School.builder()
                                .name("Name not found")
                                .email("Email not found")
                                .build()
                );
        var student= client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(student)
                .build();
    };


    public void saveSchool(School school) {

        repository.save(school);
    }

    public List<School> findAllSchools() {

        return repository.findAll();
    }

}
