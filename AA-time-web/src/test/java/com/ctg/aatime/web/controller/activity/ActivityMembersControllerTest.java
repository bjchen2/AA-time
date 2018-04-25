package com.ctg.aatime.web.controller.activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created By Cx On 2018/4/25 22:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
public class ActivityMembersControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void quitEvent() {

    }

    @Test
    public void findFree() {
       try{
           String responseString = mvc.perform(MockMvcRequestBuilders.get("/activityMember/freeTime")    //请求的url,请求的方法是get
                   .contentType(MediaType.APPLICATION_FORM_URLENCODED)//数据的格式
                   .param("uid","2").param("eventId","6")         //添加参数
           ).andExpect(MockMvcResultMatchers.status().isOk())    //返回的状态是200
                   .andDo(print())         //打印出请求和相应的内容
                   .andReturn().getResponse().getContentAsString();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}