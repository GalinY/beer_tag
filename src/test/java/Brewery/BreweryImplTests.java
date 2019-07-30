package Brewery;

import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;
import com.beerdemo.demo.repositories.BreweryRepository;
import com.beerdemo.demo.services.BreweryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
 
public class BreweryImplTests {
    @Test
    public void getAll_Should_ReturnMatchingBrewerys_WhenMachExist() {
        List<Brewery> breweries = new ArrayList<>();

        breweries.add(new Brewery("brewery", new OriginCountry("country")));
        breweries.add(new Brewery("brewery1", new OriginCountry("country")));

        BreweryRepository breweryMockRepository = Mockito.mock(BreweryRepository.class);

        Mockito.when(breweryMockRepository.getAllBrewery())
                .thenReturn(breweries);

        BreweryServiceImpl service = new BreweryServiceImpl(breweryMockRepository);

        //Act
        List<Brewery> result = service.getAllBrewery();

        //Assert
        Assert.assertEquals(2, result.size());

    }
}
