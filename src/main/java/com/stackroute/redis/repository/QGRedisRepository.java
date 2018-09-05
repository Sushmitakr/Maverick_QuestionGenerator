package com.stackroute.redis.repository;

import java.util.Map;

import com.stackroute.redis.model.Question;

public interface QGRedisRepository {

	/**
	 * Return all questions
	 */
	Map<Object, Object> findAllQuestions();

	/**
	 * Add key-value pair to Redis.
	 */
	void addQuestion(Question question);

	/**
	 * find a question
	 */
	Question findQuestion(int id);
	
	/**
	 * delete a question
	 * @return 
	 */
	void delete(int id);
	
	/**
	 * update a question
	 * @return 
	 */
	Question update(Question question);
	
	/**
	 * find a question by its topic
	 */
	Question findQuestionByTopic(int questionLevel);
}
