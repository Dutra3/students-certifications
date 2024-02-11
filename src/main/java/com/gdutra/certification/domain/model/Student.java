package com.gdutra.certification.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private UUID id;
    private String email;
    private List<CertificationStudent> certificationStudents;
}
