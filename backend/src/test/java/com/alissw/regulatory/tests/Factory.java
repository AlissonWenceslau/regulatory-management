package com.alissw.regulatory.tests;

import com.alissw.regulatory.entities.Category;

public class Factory {

	public static Category category() {
		return new Category(1L, "NR11");
	}
}
