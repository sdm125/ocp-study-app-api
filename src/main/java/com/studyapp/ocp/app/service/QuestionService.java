package com.studyapp.ocp.app.service;

import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyapp.ocp.app.model.Question;
import com.studyapp.ocp.app.model.Response;
import com.studyapp.ocp.app.model.Status;
import com.studyapp.ocp.app.repo.QuestionRepo;

@Service
public class QuestionService {
	
	private Logger logger;

	@Autowired
	private QuestionRepo questionRepo;
	
	public Response<Question[]> getQuestions() {
		Response<Question[]> res = new Response<>();
		
		try {
			Question[] questions = questionRepo.getQuestions();	
			res.setData(questions).setStatus(Status.SUCCESS);
		} catch (Exception e) {
			logger.error(e.toString());
			res.setStatus(Status.ERROR).setErrorMessage(e.toString());
		}

		return res;
	}
	
	public Response<Question[]> getQuestionByChapter(Integer chapter) {
		Response<Question[]> res = new Response<>();
		
		try {
			Question[] questions = questionRepo.getQuestionByChapter(chapter);
			res.setData(questions).setStatus(Status.SUCCESS);
		} catch(Exception e) {
			logger.error(e.toString());
			res.setStatus(Status.ERROR).setErrorMessage(e.toString());
		}
		
		return res;
	}
	
	public Response<Question> getQuestionById(Integer id) {
		Response<Question> res = new Response<>();
		
		try {
			Question question = questionRepo.getQuestionById(id);
			res.setData(question).setStatus(Status.SUCCESS);
		} catch(Exception e) {
			logger.error(e.toString());
			res.setStatus(Status.ERROR).setErrorMessage(e.toString());
		}

		return res;
	}

	public Response<Question> addQuestion(Question question) {
		Response<Question> res = new Response<>();
		
		try {
			Question addedQuestion = questionRepo.save(question);
			questionRepo.flush();
			res.setData(addedQuestion).setStatus(Status.SUCCESS);
		} catch(Exception e) {
			logger.error(e.toString());
			res.setStatus(Status.ERROR).setErrorMessage(e.toString());
		}
		
		return res;
	}
	
	public Response<Question[]> updateQuestion(Question updatedQuestion) {
		Response<Question[]> res = new Response();
		
		try {
			Optional<Question> question = questionRepo.findById(updatedQuestion.getId());
			question.ifPresent(q -> {
				q.setAnswer(updatedQuestion.getAnswer())
					.setAnswerSnippet(updatedQuestion.getAnswerSnippet())
					.setQuestion(updatedQuestion.getQuestion())
					.setQuestionSnippet(updatedQuestion.getQuestionSnippet())
					.setChapter(updatedQuestion.getChapter());
				
				questionRepo.saveAndFlush(q);
				res.setData(questionRepo.getQuestions()).setStatus(Status.SUCCESS);
			});
			
		} catch(Exception e) {
			res.setStatus(Status.ERROR).setErrorMessage(e.toString());
		}
		
		return res;
	}
	
	public Response<Question> deleteQuestionById(Integer id) {
		Response<Question> res = new Response<>();
		
		try {
			Question deletedQuestion = questionRepo.getQuestionById(id);
			questionRepo.delete(deletedQuestion);
			res.setData(deletedQuestion).setStatus(Status.SUCCESS);
		} catch(Exception e) {
			logger.error(e.toString());
			res.setStatus(Status.ERROR).setErrorMessage(e.toString());
		}
		
		return res;
	}
	
	public Response<Integer[]> getChapters() {
		Response<Integer[]> res = new Response<>();
		
		try {
			Integer[] chapters = questionRepo.getChapters();
			res.setData(chapters).setStatus(Status.SUCCESS);
		} catch(Exception e) {
			logger.error(e.toString());
			res.setStatus(Status.ERROR).setErrorMessage(e.toString());
		}
		
		return res;
	}
}
