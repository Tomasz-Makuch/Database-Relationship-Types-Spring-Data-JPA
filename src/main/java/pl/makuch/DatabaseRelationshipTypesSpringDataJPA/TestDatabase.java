package pl.makuch.DatabaseRelationshipTypesSpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.makuch.DatabaseRelationshipTypesSpringDataJPA.model.Address;
import pl.makuch.DatabaseRelationshipTypesSpringDataJPA.model.Post;
import pl.makuch.DatabaseRelationshipTypesSpringDataJPA.model.User;
import pl.makuch.DatabaseRelationshipTypesSpringDataJPA.repository.AddressRepo;
import pl.makuch.DatabaseRelationshipTypesSpringDataJPA.repository.PostRepo;
import pl.makuch.DatabaseRelationshipTypesSpringDataJPA.repository.UserRepo;

import java.util.List;
import java.util.Optional;

@Component
public class TestDatabase {

    private UserRepo userRepo;
    private AddressRepo addressRepo;
    private PostRepo postRepo;

    @Autowired
    public TestDatabase(UserRepo userRepo, AddressRepo addressRepo, PostRepo postRepo) {
        this.userRepo = userRepo;
        this.addressRepo = addressRepo;
        this.postRepo = postRepo;
    }

    public void testOneToOne() {

        Address address1 = new Address("Warsaw", "Poland");
        Address address2 = new Address("Berlin", "Germany");
        Address address3 = new Address("Oslo", "Norway");

        User user1 = new User("Tomasz", "tomasz123@o2.pl");
        User user2 = new User("Jack", "jask-genetic@rr.de");
        User user3 = new User("Bill", "bill-norweg@plx.eu");

        user1.setAddress(address1);
        user2.setAddress(address3);
        user3.setAddress(address2);

        Post post1 = new Post("Hello everybody");
        Post post2 = new Post("Hi, how are you? ");
        Post post3 = new Post("OK  !!!");
        Post post4 = new Post("Who you are?");

        post1.setPostUser(user1);
        post2.setPostUser(user2);
        post3.setPostUser(user1);
        post4.setPostUser(user3);


        userRepo.save(user1);
        userRepo.save(user2);
        userRepo.save(user3);

        postRepo.save(post1);
        postRepo.save(post2);
        postRepo.save(post3);
        postRepo.save(post4);
    }

    public void printDB() {
        // display user from DB
        System.out.println("=========== USER ==================");
        List<User> allUsers = userRepo.findAll();
        for (User user : allUsers) {
            System.out.println(user);
        }

        // display address from DB
        System.out.println("=========== ADDRESS ==================");
        List<Address> allAddress = addressRepo.findAll();
        for (Address address : allAddress) {
            System.out.println(address);
        }

        // display posts from DB
        System.out.println("=========== POST ==================");
        List<Post> allPosts = postRepo.findAll();
        for (Post post : allPosts) {
            System.out.println(post);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runTest() {
        testOneToOne();
        printDB();
    }
}
