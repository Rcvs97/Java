package services;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Task;

class TaskServiceTest {

	private static TaskService taskService;
	
	@BeforeAll
	static void setup() {
		taskService = TaskService.getService();
	}
	
	@Test
	void testAddTaskSuccess() {
		Task task = new Task("147852", "Brush your teeth", "Brush your teeth before and after bed");	
		assertTrue(taskService.addTask(task));
		
		Task retrievedTask = taskService.getTask(task.getId());
		
		assertTrue(retrievedTask != null);
		assertTrue(retrievedTask.getId().equals("147852"));
		assertTrue(retrievedTask.getName().equals("Brush your teeth"));
		assertTrue(retrievedTask.getDescription().equals("Brush your teeth before and after bed"));
	}
	
	@Test
	void testAddTaskSuccess2() {
			
		assertTrue(taskService.addTask("963258", "Brush your teeth", "Brush your teeth before and after bed"));
		
		Task retrievedTask = taskService.getTask("963258");
		
		assertTrue(retrievedTask != null);
		assertTrue(retrievedTask.getId().equals("963258"));
		assertTrue(retrievedTask.getName().equals("Brush your teeth"));
		assertTrue(retrievedTask.getDescription().equals("Brush your teeth before and after bed"));
	}
	
	@Test
	void testAddMultipleTaskSuccess() {
		Task task1 = new Task("789654", "Brush your teeth", "Brush your teeth before and after bed");	
		Task task2 = new Task("456321", "Do exercises", "Do morning exercises for 15 minutes");	

		assertTrue(taskService.addTask(task1));
		task1 = taskService.getTask(task1.getId());
		
		assertTrue(task1 != null);
		assertTrue(task1.getId().equals("789654"));
		assertTrue(task1.getName().equals("Brush your teeth"));
		assertTrue(task1.getDescription().equals("Brush your teeth before and after bed"));
		
		assertTrue(taskService.addTask(task2));
		task2 = taskService.getTask(task2.getId());
		
		assertTrue(task2 != null);
		assertTrue(task2.getId().equals("456321"));
		assertTrue(task2.getName().equals("Do exercises"));
		assertTrue(task2.getDescription().equals("Do morning exercises for 15 minutes"));
	}
	
	@Test
	void testAddMultipleTaskSuccess2() {
		Task task1 = new Task("121212", "Brush your teeth", "Brush your teeth before and after bed");	
		Task task2 = new Task("357869", "Do exercises", "Do morning exercises for 15 minutes");	
		
		assertTrue(taskService.addTask(task1));
		assertTrue(taskService.addTask(task2));		
		
		assertEquals(task1, taskService.getTask(task1.getId()));	
		assertEquals(task2, taskService.getTask(task2.getId()));	
	}
	
	@Test
	void testAddTaskDuplicateIdFail() {
		Task task1 = new Task("951263", "Brush your teeth", "Brush your teeth before and after bed");	
		Task task2 = new Task("951263", "Do exercises", "Do morning exercises for 15 minutes");	

		assertTrue(taskService.addTask(task1));
		assertFalse(taskService.addTask(task2));
	}
	
	@Test
	void testAddTaskDuplicateIdFail2() {
		Task task1 = new Task("111111", "Brush your teeth", "Brush your teeth before and after bed");			

		assertTrue(taskService.addTask(task1));
		assertFalse(taskService.addTask("111111", "Do exercises", "Do morning exercises for 15 minutes"));
	}
	
	
	@Test
	void testGetTaskAndUpdateSuccess() {
		Task task = new Task("333333", "Brush your teeth", "Brush your teeth before and after bed");	
		assertTrue(taskService.addTask(task));
		
		Task updatedTask = taskService.getTask(task.getId());
		updatedTask.setName("Do exercises");
		updatedTask.setDescription("Do morning exercises for 15 minutes");

		
		Task retrievedTask = taskService.getTask("333333");
		assertTrue(retrievedTask.getName().equals("Do exercises"));	
		assertTrue(retrievedTask.getDescription().equals("Do morning exercises for 15 minutes"));

	}
	
	@Test
	void testGetTaskAndUpdateSuccess2() {
	
		assertTrue(taskService.addTask("444444", "Brush your teeth", "Brush your teeth before and after bed"));
		
		assertTrue(taskService.updateTaskName("444444", "Do exercises"));	
		assertEquals("Do exercises", taskService.getTask("444444").getName());
		
		assertTrue(taskService.updateTaskDescription("444444", "Do morning exercises for 15 minutes"));	
		assertEquals("Do morning exercises for 15 minutes", taskService.getTask("444444").getDescription());
	}
	
	@Test
	void testUpdateTaskFail() {
	
		assertTrue(taskService.addTask("555555", "Brush your teeth", "Brush your teeth before and after bed"));
		
		assertFalse(taskService.updateTaskName("555551", "Do exercises"));	
		assertFalse(taskService.updateTaskName("555555", "Do exercises Do exercises Do exercises"));	
				
		assertFalse(taskService.updateTaskDescription("555555", "Do morning exercises for 15 minutes every day and never give up !"));	
		
	}
	
	@Test
	void testGetTaskAndDeleteSuccess() {
		Task task = new Task("666666", "Brush your teeth", "Brush your teeth before and after bed");	

		assertTrue(taskService.addTask(task));
		
		task = taskService.getTask(task.getId());
		assertTrue(task != null);
		
		assertTrue(taskService.deleteTask(task.getId()));
		assertTrue(taskService.getTask(task.getId()) == null);
	}
	
	@Test
	void testDeleteInvalidTaskFail() {
		String invalidTaskId = "555";

		assertFalse(taskService.deleteTask(invalidTaskId));
	}

}
