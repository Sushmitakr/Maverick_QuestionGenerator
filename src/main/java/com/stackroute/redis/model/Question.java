package com.stackroute.redis.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Question implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @NotNull(message = "id cannot be null")
    @Id
    private int id;
    @NotNull(message = "id cannot be null")
    private String topicName;
    @NotNull(message = "provide the level of the question")
    private int questionLevel;
    @NotNull(message = "question cannot be null")
    private String question;
    @NotNull(message = "provide 4 options to your ans")
    private String[] options;
    @NotNull(message = "you need to provide correct answer")
    private String correctAnswer;    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	public int getQuestionLevel() {
		return questionLevel;
	}

	public void setQuestionLevel(int questionLevel) {
		this.questionLevel = questionLevel;
	}
	
	public Question() {
		
	}
	
	public Question(int id,String topicName,int questionLevel, String question, String[] options, String correctAnswer){
        this.id=id;
        this.topicName=topicName;
        this.question=question;
        this.questionLevel=questionLevel;
        this.options=options;
        this.correctAnswer=correctAnswer;
        this.topicName=topicName;
    }
}
