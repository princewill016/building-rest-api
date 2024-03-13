package com.example.restapi.restapi;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session s = sf.openSession();
		Transaction trans = s.beginTransaction();

		Contact c = new Contact();
		c.setDateOfBirth(LocalDate.of(2004, 3, 21));
		c.setEmail("gift@gmail.com");
		c.setFirstName("gift");
		c.setGender('F');
		c.setLastName("Peter");
		s.save(c);
		trans.commit();

	}

}
