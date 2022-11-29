package com.studyapp.ocp.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@Table(name="question")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, precision = 0)
	private Integer id;
	
	@Column(name="question")
	private String question;
	
	@Column(name="answer", nullable = true)
	private String answer;
	
	@Column(name="chapter")
	private Integer chapter;
	
	@Column(name="questionsnippet", nullable = true)
	private String questionSnippet;
	
	@Column(name="answersnippet", nullable = true)
	private String answerSnippet;


	public String getAnswerSnippet() {
		return answerSnippet;
	}

	public Question setAnswerSnippet(String answerSnippet) {
		this.answerSnippet = answerSnippet;
		return this;
	}

	public String getQuestionSnippet() {
		return questionSnippet;
	}

	public Question setQuestionSnippet(String questionSnippet) {
		this.questionSnippet = questionSnippet;
		return this;
	}

	public Integer getId() {
		return id;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public Question setQuestion(String question) {
		this.question = question;
		return this;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public Question setAnswer(String answer) {
		this.answer = answer;
		return this;
	}
	
	public Integer getChapter() {
		return chapter;
	}
	
	public Question setChapter(Integer chapter) {
		this.chapter = chapter;
		return this;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + ", chapter=" + chapter + "]";
	}
	
}
