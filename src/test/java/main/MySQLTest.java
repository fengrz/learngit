package main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import springboot.mysqldemo.entity.Deparment;
import springboot.mysqldemo.entity.Role;
import springboot.mysqldemo.entity.User;
import springboot.mysqldemo.repository.DepartmentRepository;
import springboot.mysqldemo.repository.RoleRepository;
import springboot.mysqldemo.repository.UserRepository;


import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class MySQLTest {

    private static Logger logger = LoggerFactory.getLogger(MySQLTest.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Before
    public void initData(){
        userRepository.deleteAll();
        departmentRepository.deleteAll();
        roleRepository.deleteAll();

        Deparment deparment =  new Deparment();
        deparment.setName("开发部");
        departmentRepository.save(deparment);
        Assert.notNull(deparment.getId(),"deparment id is null");

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.notNull(role.getId(),"role id is null");

        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDeparment(deparment);
        List<Role> roles = roleRepository.findAll();
        Assert.notNull(roles,"roles is null");
        user.setRoles(roles);
        userRepository.save(user);
        Assert.notNull(user.getId(),"user id is null");


    }

    @Test
    public void findPage(){
        Pageable pageable = new PageRequest(0,10,new Sort(Sort.Direction.ASC,"id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.notNull(page,"page is null");
        for (User user:page.getContent()){
            logger.info("===user=== user name:{},department name:{}, role name:{}",user.getName(),user.getDeparment(),user.getRoles().get(0).getName());
        }

    }



}
