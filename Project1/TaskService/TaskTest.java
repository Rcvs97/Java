package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TaskTest {

	@Test
	void testCreateTaskSuccess() {
		Task task = new Task("147852", "Brush your teeth", "Brush your teeth before and after bed");	
		
		assertTrue(task != null);
		assertTrue(task.getId().equals("147852"));
		assertTrue(task.getName().equals("Brush your teeth"));
		assertTrue(task.getDescription().equals("Brush your teeth before and after bed"));
	}
	
	@Test
	void testCreateTaskTaskIdFails() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("14785236900", "Brush your teeth", "Brush your teeth before and after bed");	
		    });	
	}
	
	@Test
	void testCreateTaskTaskIdFails2() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Brush your teeth", "Brush your teeth before and after bed");	
		    });	
	}
	
	@Test
	void testCreateTaskTaskNameFails() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Task("147852", "Brush your teeth often than you think", "Brush your teeth before and after bed");
		    });	
	}
	
	@Test
	void testCreateTaskTaskNameFails2() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Task("147852", null, "Brush your teeth before and after bed");
		    });	
	}
	
	@Test
	void testCreateTaskTaskDescriptionFails() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Task("147852", "Brush your teeth", "Brush your teeth before you go to bed and after you get up daily");
		    });	
	}
	
	@Test
	void testCreateTaskTaskDescriptionFails2() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> {
			  new Task("147852", "Brush your teeth", null);
		    });	
	}
	
	@Test
	void testSetter() {
		Task task = new Task("147852", "Brush your teeth", "Brush your teeth before and after bed");	
		
		assertTrue(task.getId().equals("147852"));
		
		task.setName("Do exercises");		
		assertTrue(task.getName().equals("Do exercises"));
		
		task.setDescription("Do morning exercises for 15 minutes");		
		assertTrue(task.getDescription().equals("Do morning exercises for 15 minutes"));
	}
	
	@Test
	void testSetterFail() {
		Task task = new Task("147852", "Brush your teeth", "Brush your teeth before and after bed");			
		
		assertFalse(task.setName("Do exercises alot in the morning"));			
		assertTrue(task.getName().equals("Brush your teeth"));
		
		assertFalse(task.setDescription("Do morning exercises for 15 minutes every day and never give up !"));					
		assertTrue(task.getDescription().equals("Brush your teeth before and after bed"));
	}
	
}
