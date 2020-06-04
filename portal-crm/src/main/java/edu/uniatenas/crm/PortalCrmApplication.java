package edu.uniatenas.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.uniatenas.crm.usuario.entity.Role;

@SpringBootApplication
public class PortalCrmApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortalCrmApplication.class, args);
	}
}