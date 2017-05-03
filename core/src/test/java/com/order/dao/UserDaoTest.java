//package com.order.dao;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//
//import com.order.model.User;
//
//public class UserDaoTest {
//
//    UserDao userDao;
//    private EmbeddedDatabase db;
//
//    @Before
//    public void setUp() {
//        //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
//    	db = new EmbeddedDatabaseBuilder()
//    		.setType(EmbeddedDatabaseType.H2)
//    		.addScript("db/create-db.sql")
//    		.addScript("db/insert-data.sql")
//    		.build();
//    }
//
//    @Test
//    public void testFindByname() {
//    	NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
//    	UserDaoImpl userDao = new UserDaoImpl();
//    	userDao.setNamedParameterJdbcTemplate(template);
//
//    	User user = userDao.findByName("order");
//
//    	Assert.assertNotNull(user);
//    	Assert.assertEquals(1, user.getId().intValue());
//    	Assert.assertEquals("order", user.getName());
//    	Assert.assertEquals("order@gmail.com", user.getEmail());
//
//    }
//
//    @After
//    public void tearDown() {
//        db.shutdown();
//    }
//
//}