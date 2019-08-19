package ru.skwardlow.example.springdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.skwardlow.example.springdata.interfaces.UserRepository;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
@EnableJpaRepositories
@SpringBootApplication
public class WebServerDataApplication {

	private static final Logger log = LoggerFactory.getLogger(WebServerDataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebServerDataApplication.class, args);
	}

/*	@Bean
	public CommandLineRunner commandLineRunner(UserRepository crudRepository){
		return (args) ->{
			ServerSocket sc = new ServerSocket(3228);
			log.info(" Server is running");
			while (true) {
				Socket socket = sc.accept();
				new Thread(()->{
					log.info("thread "+Thread.currentThread().toString()+ "is started");
                    try {
                        InputStream is = socket.getInputStream();
                        Scanner in = new Scanner(is);
                        String fullReq = in.nextLine().split(" ")[1];
                        String[] req = fullReq.split("/");
                        for(String buf:req){
                            System.out.println(buf);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                });
			}






		};
	}*/


}
