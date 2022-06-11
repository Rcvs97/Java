package model;

public class Task {
	
	private String id;
	private String name;
	private String description;
	
	private final int ID_LENGTH = 10;
	private final int NAME_LENGTH = 20;
	private final int DESCRIPTION_LENGTH = 50;
	
	public Task(String idIn, String nameIn, String descriptionIn) {
		check(idIn,ID_LENGTH);
		check(nameIn,NAME_LENGTH);
		check(descriptionIn,DESCRIPTION_LENGTH);
		id = idIn;
		name = nameIn;
		description = descriptionIn;
	}
	
	public boolean setName(String nameIn) {				
		boolean valid = isValid(nameIn,NAME_LENGTH);
		
		if(valid) {
			name = nameIn;
		}
		return valid;
	}
	
	public boolean setDescription(String descriptionIn) {
		boolean valid = isValid(descriptionIn,DESCRIPTION_LENGTH);
		
		if(valid) {
			description = descriptionIn;
		}
		return valid;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	private void check(String item, int length) {
		if(!isValid(item,length))
			throw new IllegalArgumentException("Invalid input");
	}
	
	private boolean isValid(String item, int length) {
		return item!=null && item.length() <= length;
	}
}

