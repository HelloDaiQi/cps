package com.daiqi.test;

import com.daiqi.entity.Feedback;
import com.daiqi.entity.User;
import com.daiqi.extend.CertificationUserExtends;
import com.daiqi.extend.ProjectExtends;
import com.daiqi.extend.UserExtends;
import com.daiqi.mapper.CertificationUserExtendsMapper;
import com.daiqi.mapper.ProjectExtendsMapper;
import com.daiqi.mapper.UserExtendsMapper;
import com.daiqi.mapper.UserMapper;
import com.daiqi.service.UserService;
import com.daiqi.vo.DataSearch;
import com.github.pagehelper.PageInfo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class MysqlTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExtendsMapper userExtendsMapper;

    @Autowired
    private CertificationUserExtendsMapper certificationUserExtendsMapper;

    @Autowired
    private ProjectExtendsMapper projectExtendsMapper;

    @Autowired
    private UserService userService;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        //System.out.println("BeforeClass");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //System.out.println("AfterClass");
    }

    @Before
    public void setUp() throws Exception {
        //System.out.println("Before");
    }

    @After
    public void tearDown() throws Exception {
        //System.out.println("After");
    }

    @org.junit.Test
    public void testMapper() throws Exception{
        System.out.println("hello");
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getNickname());
    }

    @org.junit.Test
    public void testCertificationUserExtendsMapper() throws Exception{
        System.out.println("hello");
        List<CertificationUserExtends> certificationUserExtendsList = certificationUserExtendsMapper.selectNew();

        System.out.println(certificationUserExtendsList.get(0).getUserExtends().getNickname());
    }

    @org.junit.Test
    public void testProjectExtendsMapper() throws Exception{
        System.out.println("hello");
        List<ProjectExtends> projectExtendsList = projectExtendsMapper.selectNew();

        System.out.println(projectExtendsList.get(0).getUserExtends().getNickname());
    }

    @org.junit.Test
    public void testJsonFormat() throws Exception{
        Feedback feedback = new Feedback();
        feedback.setFeedbacktime(new Date());
        System.out.println(feedback.getFeedbacktime().toString());
    }

    @org.junit.Test
    public void testUserExtendsMapper() throws Exception{
        List<UserExtends> userExtendsList = userExtendsMapper.selectNew();
        System.out.println(userExtendsList.get(0).getNickname());
        Map<String,Object> map = new HashMap<>();
        //map.put("nickname","test");
        map.put("school",1);
        List<UserExtends> userExtendsList1 = userExtendsMapper.selectByExample(map);
        System.out.println(userExtendsList1.size());

    }

    @org.junit.Test
    public void testUserService() throws Exception{
        DataSearch dataSearch = new DataSearch();
        PageInfo page = userService.findByPage(dataSearch);
        List<User> list = page.getList();
        System.out.println(list.get(0).getNickname());
    }
}
