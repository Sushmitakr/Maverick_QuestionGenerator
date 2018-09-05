package com.stackroute.redis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.redis.model.Question;
import com.stackroute.redis.service.QGRedisService;

@RequestMapping("/api/v1/question-generator")
@RestController
public class QGRedisController {

	@Autowired
	private QGRedisService qGRedisService;
	
	@RequestMapping(value = "/question", method = RequestMethod.POST)
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		Question newQuestion = qGRedisService.addQuestion(question);
		return new ResponseEntity<Question>(newQuestion, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public ResponseEntity<Map<Object, Object>> getAllQuestions(Question question){
		Map<Object, Object> allQuestions = qGRedisService.findAllQuestions();	
		return new ResponseEntity<Map<Object, Object>>(allQuestions, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/questiontopic/{questionLevel}", method = RequestMethod.GET)
	public ResponseEntity<Question> findByTopic(@PathVariable(value = "questionLevel") int questionLevel) {
		Question questionByTopic = qGRedisService.findByTopic(questionLevel);
		return new ResponseEntity<Question>(questionByTopic, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
	public ResponseEntity<Question> findById(@PathVariable(value = "id") int id) {
		Question foundQuestion = qGRedisService.findQuestion(id);
		return new ResponseEntity<Question>(foundQuestion, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/question/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Question> deleteById(@PathVariable(value = "id") int id) {
		qGRedisService.delete(id);
		return new ResponseEntity<Question>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/question/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Question> updateById(@PathVariable(value = "id") int id, @RequestBody Question question) {
		Question updatedQuestion = qGRedisService.update(question);
		return new ResponseEntity<Question>(updatedQuestion, HttpStatus.OK);
	}	
}