package ie.atu.oop_project_user.DataLoader;

import ie.atu.oop_project_user.Model.User;
import ie.atu.oop_project_user.Repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(UserRepo userRepo) {
        return args -> {
            if (userRepo.count() > 0) {
                return;
            }

            User user1 = new User();
            user1.setUsername("Seth");
            user1.setPassword("1234");
            userRepo.save(user1);

            User user2 = new User();
            user2.setUsername("John");
            user2.setPassword("6967");
            userRepo.save(user2);

            User user3 = new User();
            user3.setUsername("Marry");
            user3.setPassword("6677");
            userRepo.save(user3);

            System.out.println("Dummy user data loaded.");
        };
    }
}
