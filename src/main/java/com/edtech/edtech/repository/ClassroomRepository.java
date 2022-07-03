package com.edtech.edtech.repository;

import com.edtech.edtech.model.document.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
    @Query(value="select *" +
            " from classroom c" +
            " where c.user_user_id = :userId and c.subject_subject_id = :subjectId limit 1", nativeQuery = true)
    Classroom findUserSubject(@Param(value = "userId") Integer userId, @Param(value = "subjectId") Integer subjectId);


    @Query(value="select *" +
            " from classroom c" +
            " where c.user_user_id = :userId", nativeQuery = true)
    Set<Classroom> findUserSubjects(@Param(value = "userId") Integer userId);

    @Query(value="select *" +
            " from classroom c" +
            " where c.subject_subject_id = :subjectId", nativeQuery = true)
    Set<Classroom> findSubjectUsers(@Param(value = "subjectId") Integer subjectId);

}
