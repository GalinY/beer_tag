package BeerStyle;

import com.beerdemo.demo.entities.BeerStyle;
import com.beerdemo.demo.repositories.BeerStyleRepository;
import com.beerdemo.demo.services.BeerStyleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class BeerStyleServiceImplTests {
    @Test
    public void getAllStyles_Should_ReturnMatchingStyles_WhenMachExist(){
        List<BeerStyle> styles=new ArrayList<>();

        styles.add(new BeerStyle("style"));
        styles.add(new BeerStyle("style1"));

        BeerStyleRepository styleRepository = Mockito.mock(BeerStyleRepository.class);

        Mockito.when(styleRepository.getAllStyles())
                .thenReturn(styles);

        BeerStyleServiceImpl service = new BeerStyleServiceImpl(styleRepository);

        //Act
        List<BeerStyle> result = service.getAllStyles();

        //Assert
        Assert.assertEquals(2, result.size());

    }
}
