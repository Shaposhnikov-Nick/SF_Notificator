package com.sfnotificator.repository;

import com.sfnotificator.entity.Homework;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HomeworkRepositoryTest {

    @Autowired
    private HomeworkRepository repository;

    @Test
    public void testHomeworkRepoFound() {
        Homework homework = new Homework();
        homework.setStudentName("Student name");
        homework.setTeacherName("Teacher name");
        homework.setSubmissionTime(LocalDate.of(2022,7,5));
        homework.setCheckTime(LocalDate.of(2022,7,7));
        homework.setChecked(true);
        repository.save(homework);

        Optional<Homework> optional = repository.findById(homework.getId());
        assertTrue(optional.isPresent());
        assertEquals("Student name", optional.get().getStudentName());
        assertEquals("Teacher name", optional.get().getTeacherName());
        assertEquals(LocalDate.of(2022,7,5), optional.get().getSubmissionTime());
        assertEquals(LocalDate.of(2022, 7,7), optional.get().getCheckTime());
        assertTrue(optional.get().isChecked());
        repository.deleteById(homework.getId());
    }
}
