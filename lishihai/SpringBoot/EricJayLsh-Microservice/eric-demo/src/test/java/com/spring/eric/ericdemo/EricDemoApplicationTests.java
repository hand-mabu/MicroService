package com.spring.eric.ericdemo;

import com.spring.eric.ericdemo.controller.EricDemo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EricDemoApplicationTests {


    private MockMvc mockMvc;

    @Before
    public void befor(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(new EricDemo()).build();
    }

    @Test
    public void contextLoads() {
        RequestBuilder requestBuilder = get("/EricJayLsh/demo1");
        try {
            mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string("I WANT TO SEE SPRINGBOOT"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
