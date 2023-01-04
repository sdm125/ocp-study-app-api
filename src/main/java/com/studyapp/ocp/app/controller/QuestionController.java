package com.studyapp.ocp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.studyapp.ocp.app.service.QuestionService;
import com.studyapp.ocp.app.model.Response;
import com.studyapp.ocp.app.model.Question;
import com.studyapp.ocp.app.model.Status;

@RestController
public class QuestionController {
	
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/question", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Response<Question>> getQuestionById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(questionService.getQuestionById(id));
	}
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Response<Question[]>> getQuestions() {
		return ResponseEntity.ok().body(questionService.getQuestions());
	}
	
	@RequestMapping(value = "/questions/chapter/{chapter}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Response<Question[]>> getQuestion(@PathVariable Integer chapter) {
		return ResponseEntity.ok().body(questionService.getQuestionByChapter(chapter));
	}
	
	@RequestMapping(value = "/question", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Response<Question>> addQuestion(@RequestBody Question question) {
		if (question != null && question.getQuestion() != null && question.getChapter() != null) {
			return ResponseEntity.ok().body(questionService.addQuestion(question));	
		}
		var errorRes = new Response<Question>().setStatus(Status.ERROR);
		return ResponseEntity.badRequest().body(errorRes);
	}
	
	@RequestMapping(value = "/question/id/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Response<Question>> deleteQuestion(@PathVariable Integer id) {
		return ResponseEntity.ok().body(questionService.deleteQuestionById(id));
	}
	
	@RequestMapping(value = "/question", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Response<Question>> updateQuestion(@RequestBody Question question) {
		return ResponseEntity.ok().body(questionService.updateQuestion(question));
	}
	
	@RequestMapping(value = "/chapters", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Response<Integer[]>> getChatpers() {
		return ResponseEntity.ok().body(questionService.getChapters());
	}
	
}
