package com.vm.course.api.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.vm.course.api.topic.Topic;

@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String description;
	@ManyToOne
	private Topic topic;
	
	public Course() {
		
	}
	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public Course(String id, String name, String description,String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
