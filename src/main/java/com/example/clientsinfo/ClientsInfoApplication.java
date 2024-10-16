package com.example.clientsinfo;

import com.example.clientsinfo.entities.Client;
import com.example.clientsinfo.entities.Info;
import com.example.clientsinfo.repository.ClientRepository;
import com.example.clientsinfo.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientsInfoApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InfoRepository infoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClientsInfoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Kate
        Client kate = new Client("Kate");
        clientRepository.save(kate);

        infoRepository.save(new Info("4951234567", "phone", kate));
        infoRepository.save(new Info("9035557799", "phone", kate));
        infoRepository.save(new Info("kate@mail.ru", "email", kate));

        //Denis
        Client denis = new Client("Denis");
        clientRepository.save(denis);

        infoRepository.save(new Info("9031113355", "phone", denis));

        //Vasily
        Client vasily = new Client("Vasily");
        clientRepository.save(vasily);

        infoRepository.save(new Info("vasily@mail.ru", "email", vasily));

        //Iren
        Client iren = new Client("Iren");
        clientRepository.save(iren);

    }
}
