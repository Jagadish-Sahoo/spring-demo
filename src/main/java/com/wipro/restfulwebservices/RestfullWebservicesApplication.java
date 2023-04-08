package com.wipro.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.restfulwebservices.Resufulwebservicewithangular.model.User;
import com.wipro.restfulwebservices.repository.UserRepository;

@SpringBootApplication
public class RestfullWebservicesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RestfullWebservicesApplication.class, args);
	}
	@Autowired
    private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		this.userRepository.save(new User("vinayak", "pillai", "vinayak@gmail.com"));
//        this.userRepository.save(new User("Stephen", "beven", "Stephen@gmail.com"));
//        this.userRepository.save(new User("John", "Kenady", "John@gmail.com"));
//        this.userRepository.save(new User("Robert", "Disoza", "Robert@gmail.com"));
//        this.userRepository.save(new User("Sunil", "Saxena", "Sunil@gmail.com"));
//        this.userRepository.save(new User("Raghav", "Pande", "Raghav@gmail.com"));    
//        this.userRepository.save(new User("Anupama","kuruba", "anupama@gmail.com"));
	}

}
