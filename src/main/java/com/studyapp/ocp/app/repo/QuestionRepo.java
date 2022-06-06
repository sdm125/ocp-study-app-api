package com.studyapp.ocp.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studyapp.ocp.app.model.Question;

//  psql -d ocp connect to postgres

public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	@Query(value = "SELECT * FROM question ORDER BY id", nativeQuery = true)
	Question[] getQuestions();
	
	@Query(value = "SELECT * FROM question WHERE chapter = ?", nativeQuery = true)
	Question[] getQuestionByChapter(Integer chapter);
	
	@Query(value = "SELECT * FROM question WHERE id = ?", nativeQuery = true)
	Question getQuestionById(Integer id);
	
	@Query(value = "SELECT MAX(id) FROM question LIMIT 1", nativeQuery = true)
	Question getMaxIdQuestion();
	
	@Query(value = "SELECT DISTINCT chapter FROM question ORDER BY chapter", nativeQuery = true)
	Integer[] getChapters();

}
