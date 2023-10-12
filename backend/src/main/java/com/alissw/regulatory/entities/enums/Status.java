package com.alissw.regulatory.entities.enums;

public enum Status {
	UP(1,"Em dia"),
	DOWN(2, "Vencido");
	
	private int value;
	private String description;
	
	private Status(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	public static Status toEnum(Integer value) {
		
		if(value == null) {
			return null;
		}
		
		for(Status s : Status.values()) {
			if(value.equals(s.getValue())){
				return s;
			}
		}
		throw new IllegalArgumentException("Id not found: " + value);
	}
}
