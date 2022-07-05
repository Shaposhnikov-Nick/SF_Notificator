package com.sfnotificator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HomeworkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testWhenGetAllHomework() throws Exception {
        mockMvc.perform(get("/api/homework"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void  testWhenGetHomeworkById() throws Exception {
        mockMvc.perform(get("/api/homework/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getHomeworkByStudentName() {
    }

    @Test
    void addHomework() {
    }

    @Test
    void updateHomework() {
    }

    @Test
    void deleteHomework() {
    }
}