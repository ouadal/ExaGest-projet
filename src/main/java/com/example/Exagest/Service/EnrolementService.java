package com.example.Exagest.Service;

import com.example.Exagest.entities.Enrolement;

import java.util.List;

public interface EnrolementService {
    Enrolement addenrolement(Enrolement enrolement);
    Enrolement editenrolement( Long id,Enrolement enrolement);
    String deleteenrolement(Long id);
    List<Enrolement> listenrolement();
}
