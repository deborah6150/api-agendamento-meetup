package com.womakerscode.microservicemeetup.agendamentomeetup.controller;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.womakerscode.microservicemeetup.agendamentomeetup.service.RegistrationService;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = {RegistrationController.class})
@AutoConfigureMockMvc
public class RegistrationControllerTest {

	@Autowired
	private RegistrationController registrationController;
	
	@MockBean
	private RegistrationService registrationService;
	
//	@Test
//    public void deleteRegistrationTest() throws Exception {
//        when(this.registrationService.deleteRegistration((Long) any())).thenReturn("42");
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/registration/{id}", 123L);
//        MockMvcBuilders.standaloneSetup(this.registrationController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
//                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("42")));
//    }
}
