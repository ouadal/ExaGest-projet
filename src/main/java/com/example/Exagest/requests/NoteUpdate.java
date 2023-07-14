package com.example.Exagest.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class NoteUpdate {
    private Long id;

    private float noteExam;
}
