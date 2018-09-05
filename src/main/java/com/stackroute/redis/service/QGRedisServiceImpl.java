package com.stackroute.redis.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.redis.model.Question;
import com.stackroute.redis.repository.QGRedisRepository;

@Service
public class QGRedisServiceImpl implements QGRedisService{
	
	@Autowired
	private QGRedisRepository qGRedisRepository;
	
	@PostConstruct
	private void initDataBase() {
		String[] question1 = {"option1","option2", "option3", "option4"};
		qGRedisRepository.addQuestion(new Question(1, "Java", 3, "what is java", question1, "option2" ));
		qGRedisRepository.addQuestion(new Question(22, "Java", 1, "what is constructor?", question1, "option1" ));
		qGRedisRepository.addQuestion(new Question(3, "Java", 2, "what is class?", question1, "option4" ));
		qGRedisRepository.addQuestion(new Question(4, "Spring", 3, "what is spring?", question1, "option2" ));
		qGRedisRepository.addQuestion(new Question(5, "Spring", 2, "what is interface?", question1, "option3" ));
		qGRedisRepository.addQuestion(new Question(6, "Spring", 2, "what is objects?", question1, "option2" ));
		qGRedisRepository.addQuestion(new Question(7, "Spring", 1, "what is xml?", question1, "option1" ));
	}

	@Override
	public Map<Object, Object> findAllQuestions() {
		return qGRedisRepository.findAllQuestions();
	}

	@Override
	public Question addQuestion(Question question) {
		qGRedisRepository.addQuestion(question);;
		return question;
	}

	@Override
	public Question findQuestion(int id) {
		return qGRedisRepository.findQuestion(id);
	}
	
	@Override
	public Question findByTopic(int questionLevel) {
		return qGRedisRepository.findQuestionByTopic(questionLevel);
	}

	@Override
	public Question update(Question question) {
		return qGRedisRepository.update(question);
	}

	@Override
	public void delete(int id) {
		qGRedisRepository.delete(id);		
	}
}
