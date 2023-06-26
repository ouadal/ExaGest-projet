package com.example.Exagest.repository;

import com.example.Exagest.entities.Annee;
import com.example.Exagest.entities.TypeExamen;
import com.example.Exagest.entities.TypeMat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeMatRepository extends JpaRepository<TypeMat, Long>  {
    @Query("SELECT t FROM TypeMat t ORDER BY t.libele")
    List<TypeMat> listtypeMatLib();
}
