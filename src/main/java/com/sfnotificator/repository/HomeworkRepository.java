package com.sfnotificator.repository;

import com.sfnotificator.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {

    List<Homework> findAllByStudentName(String studentName);

//    List<Homework> findAllByStudentNameAndCheckedIsFalse(String studentName);
}
