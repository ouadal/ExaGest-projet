package com.example.Exagest.repository;

import com.example.Exagest.entities.Note;
import com.example.Exagest.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long>  {
    @Query("select s from Session s orderBy s.libele ")
    List<Session> listSess();
}
