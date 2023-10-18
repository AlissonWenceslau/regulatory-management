package com.alissw.regulatory.entities.enums;

public enum Shift {

	MORNING(1, "Manhã"),
	AFTERNOON(2, "Tarde"),
	NIGHT(3, "Noite"),
	COMMERCIAL(4, "Comercial");
	
	private String description;
	private int value;
	
	private Shift(int value, String description) {
		this.value = value;
		this.description = description;
	}


	public String getDescription() {
		return description;
	}

	public int getValue() {
		return value;
	}
	
	public static Shift toEnum(Integer value) {
		if(value == null) {
			return null;
		}
		
		for(Shift s : Shift.values()) {
			if(value.equals(s.getValue())) {
				return s;
			}
		}
		throw new IllegalArgumentException("Id not found: " + value);
	}
}
