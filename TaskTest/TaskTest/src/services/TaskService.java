package services;

import java.util.HashMap;
import java.util.Map;

import model.Task;

public class TaskService {
	
	 private static TaskService sevice = new TaskService();
	 private final Map<String, Task> tasks;
	
	 TaskService() {
		 this.tasks = new HashMap<String, Task>();
	 }
	 
	 //Create a singleton Task Service
	 public static TaskService getService() {
		 return sevice;
	 }
	 
	 public boolean addTask(Task task) {
		 boolean added;
		 
		 if(tasks.containsKey(task.getId())) {			
			 added = false;			 
		 } else {
			 tasks.put(task.getId(), task);
			 added = true;			
		 }
		 
		 return added;
	 }
	 
	 public boolean addTask(String idIn, String nameIn, String descriptionIn) {		
		 
		 return addTask(new Task(idIn, nameIn, descriptionIn));
	 }
	 
	 public boolean deleteTask(String taskId) {
		 
		 boolean deleted;
		 
		 if(tasks.containsKey(taskId)) {			
			 deleted = true;
			 tasks.remove(taskId);
		 } else {			
			 deleted = false;
		 }
		 return deleted;	
	 }
	 
	 public boolean updateTaskName(String idIn, String nameIn) {
		 
		 boolean updated;
		 
		 if(tasks.containsKey(idIn)) {			
			 updated = tasks.get(idIn).setName(nameIn);			 
		 } else {			
			 updated = false;
		 }
		 return updated;	
	 }
	 
	 public boolean updateTaskDescription(String idIn, String descriptionIn) {
		 
		 boolean updated;
		 
		 if(tasks.containsKey(idIn)) {			
			 updated = tasks.get(idIn).setDescription(descriptionIn);			 
		 } else {			
			 updated = false;
		 }
		 return updated;	
	 }
	 
	 public Task getTask(String idIn) {
		 return tasks.get(idIn);
	 }
}
