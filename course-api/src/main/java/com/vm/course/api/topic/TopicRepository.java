package com.vm.course.api.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{
//or use JpaRepository<Topic, String>
}
