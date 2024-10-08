package com.rauf.school;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private String lastname;
    private String firstname;
    private String email;
}
