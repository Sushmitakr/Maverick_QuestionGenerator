package com.stackroute.redis.service;

import java.util.Map;

import com.stackroute.redis.model.Question;

public interface QGRedisService {
	
	/**
     * Return all questions
     */
    Map<Object, Object> findAllQuestions();

    /**
     * Add key-value pair to Redis.
     */
    Question addQuestion(Question question);
    
    /**
     * find a question
     */
    Question findQuestion(int id);
    
    /**
     * delete a question
     */
    void delete(int id);
    
    /**
     * update a question 
     */
    Question update(Question question);
    
    /**
     * update a question 
     */
    Question findByTopic(int questionLevel);

}
