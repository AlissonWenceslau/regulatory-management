package com.alissw.regulatory.services;

import static org.mockito.Mockito.doThrow;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.alissw.regulatory.dto.CategoryDTO;
import com.alissw.regulatory.entities.Category;
import com.alissw.regulatory.repositories.CategoryRepository;
import com.alissw.regulatory.services.exceptions.DatabaseException;
import com.alissw.regulatory.services.exceptions.ResourceNotFoundException;
import com.alissw.regulatory.tests.Factory;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTests {

	@InjectMocks
	private CategoryService service;
	@Mock
	private CategoryRepository repository;
	
	private Long existingId;
	private Long nonExistingId;
	private Long dependentId;
	private Category category;
	private List<Category> list;
	
	@BeforeEach
	void setup() {
		existingId = 1L;
		nonExistingId = 200L;
		dependentId = 3L;
		category = Factory.category();
		list = List.of(category);
		
		Mockito.when(repository.findAll()).thenReturn(list);
		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(category));
		Mockito.when(repository.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);
		Mockito.when(repository.existsById(dependentId)).thenReturn(true);
		
		doThrow(ResourceNotFoundException.class).when(repository).deleteById(nonExistingId);
		doThrow(DataIntegrityViolationException.class).when(repository).deleteById(dependentId);
	}
	
	@Test
	public void findAllShouldReturnLisOfCategory() {
		List<CategoryDTO> list = service.findAll();
		
		Assertions.assertNotNull(list);
	}
	
	@Test
	public void findByIdShouldReturnCategoryWhenExistsId() {
		CategoryDTO categoryDTO = service.findById(existingId);
		
		Assertions.assertNotNull(categoryDTO);
	}
	
	@Test
	public void findByIdThrowResourceNotFoundExceptionWhenNonExistsId() {
		Assertions.assertThrows(ResourceNotFoundException.class, ()->{
			service.findById(nonExistingId);
		});
	}
	
	@Test
	public void deleteThrowResourceNotFoundExceptionWhenNonExistsId() {
		Assertions.assertThrows(ResourceNotFoundException.class, ()->{
			service.delete(nonExistingId);
		});
	}
	
	@Test
	public void deleteThrowDataIntegrityViolationExceptionWhenIdDependent() {
		Assertions.assertThrows(DatabaseException.class, ()->{
			service.delete(dependentId);
		});
	}
}
