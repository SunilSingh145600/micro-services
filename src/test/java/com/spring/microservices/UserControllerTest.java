package com.spring.microservices;

import java.util.HashSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.microservices.controllers.UserController;
import com.spring.microservices.entities.UserEntity;
import com.spring.microservices.services.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	UserEntity userEntity = new UserEntity(3, "Sunil", "Sunil@1234", 'T', new HashSet<>());

	@Test
	public void retrieveDetailsForUser() throws Exception {

		Mockito.when(userService.findUserById(Mockito.anyInt())).thenReturn(userEntity);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/services/v1/user/3")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{userId:3,userName:Sunil,password:Sunil@1234}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}

}
