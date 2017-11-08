package cn.lucode.security.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author yunfeng.lu
 * @create 2017/11/5.
 */

@RunWith(SpringRunner.class)
@SpringBootTest//(classes = Application.class)
// 测试用例 包名必须一样，如果不一样需要写指明启动类
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
//
//    @Test
//    public void whenUploadSuccess() throws Exception {
//        String result = mockMvc.perform(fileUpload("/file")
//                .file(new MockMultipartFile("file", "test.txt", "multipart/form-data", "hello upload".getBytes("UTF-8"))))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//        System.out.println(result);
//    }


    @Test
    public void whenQuerySuccess() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/user/query").
//                        param("username", "jojo").
//                        param("age", "18").
//                        param("ageTo", "60").
//                        param("xxx", "yyy").
        contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.jsonPath("$.length()")
                        .value(3));

    }

    @Test
    public void whenGetInfoSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/get/info/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                        .value("lucode"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }

    /**
     * 测试 失败的测试 用例
     *
     * @throws Exception
     */
    @Test
    public void whenGetInfoFail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/get/info/a")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
//
//    @Test
//    public void whenCreateSuccess() throws Exception {
//
//        Date date = new Date();
//        System.out.println(date.getTime());
//        String content = "{\"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
//        String reuslt = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(content))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value("1"))
//                .andReturn().getResponse().getContentAsString();
//
//        System.out.println(reuslt);
//    }
//
//    @Test
//    public void whenCreateFail() throws Exception {
//
//        Date date = new Date();
//        System.out.println(date.getTime());
//        String content = "{\"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
//        String reuslt = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(content))
////				.andExpect(status().isOk())
////				.andExpect(jsonPath("$.id").value("1"))
//                .andReturn().getResponse().getContentAsString();
//
//        System.out.println(reuslt);
//    }
//
//    @Test
//    public void whenUpdateSuccess() throws Exception {
//
//        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
//        System.out.println(date.getTime());
//        String content = "{\"id\":\"1\", \"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
//        String reuslt = mockMvc.perform(put("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(content))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value("1"))
//                .andReturn().getResponse().getContentAsString();
//
//        System.out.println(reuslt);
//    }
//
//    @Test
//    public void whenDeleteSuccess() throws Exception {
//        mockMvc.perform(delete("/user/1")
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(status().isOk());
//    }

}