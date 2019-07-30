//package Beer;
//
//import com.beerdemo.demo.entities.*;
//import com.beerdemo.demo.repositories.BeerRepository;
//import com.beerdemo.demo.services.BeerService;
//import com.beerdemo.demo.services.BeerServiceImpl;
//import org.junit.Assert;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class BeerServiceImplTest {
//    @Test
//    public void getAllBeers_Should_Return_AllBeersExist() {
//        //Arrange
//        BeerRepository beerRepository = Mockito.mock(BeerRepository.class);
//        User user = new User("userName", "firstName", "lastName", "password", "email");
//
//        OriginCountry country = new OriginCountry("Bulgaria");
//
//        Brewery brewery = new Brewery(country);
//
//        BeerStyle style = new BeerStyle("Dark");
//
//
//        Mockito.when(beerRepository.getAllBeers())
//                .thenReturn(Arrays.asList(
//                        new Beer("beer", 2, 3, brewery, style, country),
//                        new Beer("beer2", 1, 2, brewery, style, country)));
//
//        BeerServiceImpl service = new BeerServiceImpl(beerRepository);
//
//        //Act
//        List<Beer> result = service.getAllBeers();
//
//        //Assert
//        Assert.assertEquals(2, result.size());
//
//    }
//
////    @Test
////    public void GetBeerByID_Should_Return_Beer() {
////        //Arrange
////        BeerRepository beerRepository = Mockito.mock(BeerRepository.class);
////        ArrayList<Beer> beers = new ArrayList<>();
////        Beer zagorka = new Beer(1, "Zagorka,", new Brewery(), new OriginCountry(), 5.6, "Tasty", new BeerStyle(), 0);
////        Beer kamenitza = new Beer(2, "Kamenitza", new Brewery(), new OriginCountry(), 4.5, "Neutral", new BeerStyle(), 0);
////        Beer ariana = new Beer(3, "Ariana,", new Brewery(), new OriginCountry(), 3.5, "Nasty", new BeerStyle(), 0);
////        beers.add(zagorka);
////        beers.add(kamenitza);
////        beers.add(ariana);
////
////        BeerService beerService = new BeerServiceImpl(beerRepository);
////
////        // Act
////        Beer result = beerService.getBeerByID(1);
////
////        // Assert
////        Assert.assertEquals(kamenitza, result);
////    }
//
//
//    @Test
//    public void getByName_Should_ReturnMatchingBeer_WhenMachExist() {
//        //Arrange
//        BeerRepository beerRepository = Mockito.mock(BeerRepository.class);
//        User user = new User("userName", "firstName", "lastName", "password", "email");
//
//        OriginCountry country = new OriginCountry("Bulgaria");
//
//        Brewery brewery = new Brewery(country);
//
//        BeerStyle style = new BeerStyle("Dark");
//
//        Mockito.when(beerRepository.getByName("beer2"))
//                .thenReturn(
//                        new Beer("beer2", 1, 2, brewery, style, country));
//
//        BeerServiceImpl service = new BeerServiceImpl(beerRepository);
//        //Act
//        List<Beer> result = Collections.singletonList(service.getByName("beer2"));
//
//        //Assert
//        Assert.assertEquals(1, result.size());
//
//    }
//    @Test
//    public void filterByCountry_Should_ReturnMatchingBeer_WhenMachExist() {
//        //Arrange
//        List<Beer> beers= beer_maker();
//
//        BeerRepository beerRepository = Mockito.mock(BeerRepository.class);
//
//        Mockito.when(beerRepository.filterByCountry("BG"))
//                .thenReturn(beers);
//
//        BeerServiceImpl service = new BeerServiceImpl(beerRepository);
//
//        //Act
//
//        List<Beer> result = service.filterByCountry("BG");
//
//        //Assert
//        Assert.assertEquals(3, result.size());
//
//    }
//
//    @Test
//    public void createBeer_Should_Call_BeerRepository_Add() {
//        //Arrange
//        BeerRepository beerRepository = Mockito.mock(BeerRepository.class);
//        BeerService service = new BeerServiceImpl(beerRepository);
//
//        //Act
//        Beer beer = beer_maker().get(0);
//        service.create(beer);
//        //Assert
//        Mockito.verify(beerRepository, Mockito.times(1)).create(beer);
//
//    }
//
//    private List<Beer> beer_maker() {
//        List<Beer> list = new ArrayList<>();
//        Beer zagorka = new Beer(1, "Zagorka,", new Brewery("ZAGORKA OOD"), new OriginCountry("USA"), 5.6, "Tasty", new BeerStyle("DARK"), 0);
//        Beer kamenitza = new Beer(2, "Kamenitza", new Brewery("KAMENITZA AD"), new OriginCountry("BG"), 4.5, "Neutral", new BeerStyle("WHITE"), 0);
//        Beer ariana = new Beer(3, "Ariana,", new Brewery("ARIANA AD"), new OriginCountry("COUNTRY"), 3.5, "Nasty", new BeerStyle("YELLOW"), 0);
//        list.add(zagorka);
//        list.add(kamenitza);
//        list.add(ariana);
//        return list;
//    }
//}
