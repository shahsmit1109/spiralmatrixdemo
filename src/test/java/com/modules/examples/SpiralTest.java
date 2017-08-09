package com.modules.examples;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.modules.examples.controller.SpiralController;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppInitializer.class)
@WebIntegrationTest
public class SpiralTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private SpiralController spiralController;
	
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.standaloneSetup(spiralController).build();
	}

	@Test
	public void testSpiralPath() throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/getMatrix").param("rows", "2").param("columns", "2").param("matrixValues", "1 2 3 4")).andDo(print()).andReturn();
		String content = mvcResult.getResponse().getContentAsString();
		//List<Integer> response = spiralController.spiralMatrix(2, 2, "1 2 3 4");
		assertEquals("[1,2,4,3]",content);
	}

}
