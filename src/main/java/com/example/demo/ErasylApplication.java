package com.example.demo;

;
import com.example.demo.services.GlobalService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErasylApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ErasylApplication.class, args);
  }

  @Override
  public void run(String... args) {
    System.out.println("HELLO!");
  }
}
