package OriginCountryServiceImplTests;

import com.beerdemo.demo.entities.OriginCountry;
import com.beerdemo.demo.repositories.OriginCountryRepository;
import com.beerdemo.demo.services.OriginCountryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class OriginCountryServiceImplTests {
    @Test
    public void getAllCountries_Should_ReturnMatchingCountrys_WhenMachExist(){
        List<OriginCountry> countries=new ArrayList<>();

        countries.add(new OriginCountry("country"));
        countries.add(new OriginCountry("country1"));

        OriginCountryRepository countryRepository = Mockito.mock(OriginCountryRepository.class);

        Mockito.when(countryRepository.getAllCountries())
                .thenReturn(countries);

        OriginCountryServiceImpl service = new OriginCountryServiceImpl(countryRepository);

        //Act
        List<OriginCountry> result = service.getAllCountries();

        //Assert
        Assert.assertEquals(2, result.size());

    }
}
