package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		 topicRepository.findAll().forEach(topics::add);
		 return topics;
	}
	
	public Topic getTopic(String id) {
	//	return topicList.stream().filter(t->t.getId().equals(id)).findFirst().get();
	 return	topicRepository.findById(id).orElse(null);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id,Topic topic) {
		/*
		 * System.out.println(topic.getId()); for(int i=0;i<topicList.size();i++) {
		 * Topic t= topicList.get(i); if(t.getId().equals(topic.getId())) {
		 * topicList.set(i, topic) ; return; }
		 * 
		 * }
		 */
		topicRepository.save(topic);
	
}
	
	public void delete(String id) {
		//topicList.removeIf(t->t.getId().equals(id));
		topicRepository.deleteById(id);
	}
	
	
}
