package com.stackroute.redis.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.stackroute.redis.model.Question;

@Repository
public class QGRedisRepositoryImpl implements QGRedisRepository {
	private static final String KEY = "Question";

	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Object, Object> hashOperations;

	@Autowired
	public QGRedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void addQuestion(final Question question) {
		hashOperations.put(KEY, question.getId(), question);
	}

	@Override
	public Question findQuestion(final int id) {
		return (Question) hashOperations.get(KEY, id);
	}
	
	@Override
	public Question findQuestionByTopic(final int questionLevel) {
		return (Question) hashOperations.get(KEY, questionLevel);
	}

	@Override
	public Map<Object, Object> findAllQuestions() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void delete(int id) {
		hashOperations.delete(KEY, id);
	}

	@Override
	public Question update(Question question) {
		hashOperations.put(KEY, question.getId(), question);
		return question;
	}
}