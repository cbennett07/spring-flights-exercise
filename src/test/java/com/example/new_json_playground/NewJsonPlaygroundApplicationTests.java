package com.example.new_json_playground;

import com.example.new_json_playground.JSONResponseController;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NewJsonPlaygroundApplicationTests{

	@Autowired
	MockMvc mvc;

	@Nested
	class flightTests{
		@Test
		public void endPoint1() throws Exception {
			mvc.perform(get("/flights/flight")
							.accept(MediaType.APPLICATION_JSON)
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().string (
							"{\"departs\":\"2017-04-21 19:34\",\"tickets\":[{\"passenger\":{\"firstName\":\"Jose\",\"lastName\":\"Padilla\"},\"price\":200}]}"));

		}
		@Test
		public void endPoint2() throws Exception {
			mvc.perform(get("/flights")
							.accept(MediaType.APPLICATION_JSON)
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().string (
							"[{\"departs\":\"2017-04-21 19:34\",\"tickets\":[{\"passenger\":{\"firstName\":\"Jose\",\"lastName\":\"Padilla\"},\"price\":200}]},{\"departs\":\"2017-04-21 19:34\",\"tickets\":[{\"passenger\":{\"firstName\":\"Carlos\",\"lastName\":\"Molinares\"},\"price\":300}]}]"));

		}
		@Test
		public void endPoint3noLastName() throws Exception {
			mvc.perform(get("/flights/flight")
							.accept(MediaType.APPLICATION_JSON)
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().string (
							"{\"departs\":\"2017-04-21 19:34\",\"tickets\":[{\"passenger\":{\"firstName\":\"Jose\"},\"price\":200}]}"));

		}
	}
}

