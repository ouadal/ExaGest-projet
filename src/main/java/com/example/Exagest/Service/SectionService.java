package com.example.Exagest.Service;

import com.example.Exagest.entities.Section;

import java.util.List;

public interface SectionService {
   Section addsection(Section section);
   Section editsection(Long id, Section section);
    String deletesection(Long id);
    List<Section> listsection();
}
