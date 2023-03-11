package com.Api.start;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StartApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ApplicationContext applicationContext;

	@BeforeEach
	void printApplicationContext() {
		Arrays.stream(applicationContext.getBeanDefinitionNames())
				.map(name -> applicationContext.getBean(name).getClass().getName())
				.sorted()
				.forEach(System.out::println);
	}

	@Test
	public void testGetUser() throws Exception {
		mockMvc.perform(get("/users/2"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testGetUsers() throws Exception {
		mockMvc.perform(get("/users"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testAddUser() throws Exception {
		mockMvc.perform(post("/users").content("{\n" +
				"    \"login\": \"TestUser1\",\n" +
				"    \"password\": \"TestUser1\",\n" +
				"    \"email\": \"TestUser1@mail.com\",\n" +
				"    \"name\": \"TestUser1\",\n" +
				"    \"address\": \"Минск, ул. Алибегова\",\n" +
				"    \"role\": \"user\"\n" +
				"}").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testRemoveUser() throws Exception {
		ResultActions resultActions = mockMvc.perform(delete("users/dasdas"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testGetProduct() throws Exception {
		mockMvc.perform(get("/products/casio-mrp-700-1avef"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testGetCategory() throws Exception {
		mockMvc.perform(get("/category"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testGetCategoryByAlis() throws Exception {
		mockMvc.perform(get("/category/men"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testRemoveCategoryByID() throws Exception {
		ResultActions resultActions = mockMvc.perform(delete("category/15"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@Test
	public void testAddCategory() throws Exception {
		mockMvc.perform(post("/category").content("{\n" +
				"        \"title\": \"Новый title\",\n" +
				"        \"alias\": \"Новый title\",\n" +
				"        \"parent_id\": 1,\n" +
				"        \"keywords\": \"Новый title\",\n" +
				"        \"description\": \"Новый title\"\n" +
				"    }").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}

	@SpringBootTest
	@TestPropertySource(locations = "classpath:test.properties")
	@Retention(RetentionPolicy.RUNTIME)
	@interface MockMvcTest {}
}
