package com.jojoidu.book.springwithaws.web;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	@DisplayName("hello가 리턴된다.")
	void hello() throws Exception {
		String hello = "hello";

		mvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string(hello));
	}

	@Test
	@DisplayName("helloDto가 리턴된다.")
	void helloDto() throws Exception {
		String name = "hello";
		int amount = 1000;

		mvc.perform(
			get("/hello/dto")
				.param("name", name)
				.param("amount", String.valueOf(amount)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value(name))
			.andExpect(jsonPath("$.amount").value(amount));
	}

}