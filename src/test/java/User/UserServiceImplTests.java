package User;

import com.beerdemo.demo.entities.User;
import com.beerdemo.demo.repositories.UserRepository;
import com.beerdemo.demo.services.UserService;
import com.beerdemo.demo.services.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

public class UserServiceImplTests {

    @Test
    public void getAllUsers_Should_ReturnMatchingUser_WhenMachExist() {
        //Arrange

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        List<User> list = new ArrayList<>();
        list.add(new User("userName", "firstName",
                "lastName", "password", "email"));
        list.add(new User("userName2", "firstName2",
                "lastName2", "password2", "email2"));

        when(userRepository.getAllUsers())
                .thenReturn(list);

        //Act
        UserService service = new UserServiceImpl(userRepository);

        List<User> result = service.getAllUsers();

        //Assert
        Assert.assertEquals(2, result.size());

    }

    @Test
    public void getByUsername_Should_ReturnMatchingUser_WhenMachExist() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        when(userRepository.getByName("userName"))
                .thenReturn(
                        Collections.singletonList(new User("userName", "firstName",
                                "lastName", "password", "email")));
        //Act
        UserService service = new UserServiceImpl(userRepository);

        List<User> result = service.getByName("userName");

        //Assert
        Assert.assertEquals("userName", result.get(0).getUsername());

    }
    @Test
    public void create_Should_Call_Repository_Create() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        //Act
        User user = new User("userName", "firstName",
                "lastName", "password","email");

        UserService service = new UserServiceImpl(userRepository);

        service.create(user);
        //Assert
        Mockito.verify(userRepository, Mockito.times(1)).create(user);

    }
    @Test
    public void delete_Should_Call_DeleteUser() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        User user = new User("userName", "firstName",
                "lastName", "password","email");
        user.setUser_id(1);

        //Act
        UserService service = new UserServiceImpl(userRepository);

         service.delete(user.getUser_id());

        //Assert
        Mockito.verify(userRepository, Mockito.times(1)).delete(1);


    }
}
