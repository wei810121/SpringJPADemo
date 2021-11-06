package com.example.SpringJPADemo;

import com.example.SpringJPADemo.domain.Customer;
import com.example.SpringJPADemo.domain.CustomerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringJpaDemoApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void contextLoads() {
		System.out.println("test");
	}

	@Test
	public void test() throws Exception {

		// 建立10條資料
		customerRepository.save(new Customer("AAA", 10, "SYSTEM"));
		customerRepository.save(new Customer("BBB", 20, "SYSTEM"));
		customerRepository.save(new Customer("CCC", 30, "SYSTEM"));
		customerRepository.save(new Customer("DDD", 40, "SYSTEM"));
		customerRepository.save(new Customer("EEE", 50, "SYSTEM"));
		customerRepository.save(new Customer("FFF", 60, "SYSTEM"));
		customerRepository.save(new Customer("GGG", 70, "SYSTEM"));
		customerRepository.save(new Customer("HHH", 80, "SYSTEM"));
		customerRepository.save(new Customer("III", 90, "SYSTEM"));
		customerRepository.save(new Customer("JJJ", 100, "SYSTEM"));

		// 測試findAll, 查詢所有資料
		Assert.assertEquals(10, customerRepository.findAll().size());

		// 測試findByName, 查詢姓名為FFF的Customer
		Assert.assertEquals(60, customerRepository.findByName("FFF").getAge().longValue());

		// 測試queryByName, 查詢姓名為FFF的Customer
		Assert.assertEquals(60, customerRepository.queryByName("FFF").getAge().longValue());

		// 測試findByNameAndAge, 查詢姓名為FFF並且年齡為60的Customer
		Assert.assertEquals("FFF", customerRepository.findByNameAndAge("FFF", 60).get(0).getName());

		// 測試删除姓名為AAA的Customer
		customerRepository.delete(customerRepository.findByName("AAA"));

		// 測試findAll, 查詢所有資料, 驗證上方的删除是否成功
		Assert.assertEquals(9, customerRepository.findAll().size());

	}

	@Test
	public void deleteAll(){
		customerRepository.deleteAll();
		Assert.assertEquals(0,customerRepository.findAll().size());
	}

	@Test
	public void addCustomer(){
		customerRepository.save(new Customer("wei",20,"wei"));
		Assert.assertEquals(1,customerRepository.findAll().size());
	}



}
