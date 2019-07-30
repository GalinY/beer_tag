package Beer;

import com.beerdemo.demo.entities.Beer;
import com.beerdemo.demo.entities.BeerStyle;
import com.beerdemo.demo.entities.Brewery;
import com.beerdemo.demo.entities.OriginCountry;
import com.beerdemo.demo.repositories.BeerRepositoryImpl;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeerRepositoryImplTests {
    public static class BeerRepositoryImplTest {

        private SessionFactory sessionFactory;
        @Test
        public void getAllBeers() {
        }

        @Test
        public void getByID_Should_Return_Beer_By_Id() {
            List<Beer> beers=beer_maker();
            BeerRepositoryImpl beerRepository= Mockito.mock(BeerRepositoryImpl.class);
            Mockito.when(beerRepository.getByID(1))
                    .thenReturn(
                            beers.get(0));
            Beer result=beerRepository.getByID(1);
            Assert.assertEquals(1,result.getBeer_id());
        }

        @Test
        public void getByName_Should_Return_Beers_With_Matching_Name() {
            List<Beer> beers=beer_maker();
            BeerRepositoryImpl beerRepository= Mockito.mock(BeerRepositoryImpl.class);
            Mockito.when(beerRepository.getByName("Zagorka"))
                    .thenReturn(
                            Collections.singletonList(beers.get(0)));
            List<Beer> result=beerRepository.getByName("Zagorka");
            Assert.assertEquals("Zagorka",result.get(0).getBeer_name());
        }
        @Test
        public void sortAlphabetical_Should_Return_Sorted_By_Name() {
            List<Beer> beers=beer_maker();
            BeerRepositoryImpl beerRepository= Mockito.mock(BeerRepositoryImpl.class);
            Mockito.when(beerRepository.sortAlphabetical())
                    .thenReturn(
                            beers);
            List<Beer> result=beerRepository.sortAlphabetical();
            Assert.assertEquals(3,result.size());

        }
//////////////////TODO
        @Test
        public void filterByCountry_Should_Return_Beers_From_Country() {
            List<Beer> beers=beer_maker();
            BeerRepositoryImpl beerRepository= Mockito.mock(BeerRepositoryImpl.class);
            Mockito.when(beerRepository.filterByCountry("BG"))
                    .thenReturn(
                            beers);
            List<Beer> result=beerRepository.filterByCountry("BG");
            Assert.assertEquals(1,result.get(0).getBeer_id());
        }
///////////////TODO
        @Test
        public void sortByRating_Should_Sort_Beers_Rating() {
            List<Beer> beers=beer_maker();
            BeerRepositoryImpl beerRepository= Mockito.mock(BeerRepositoryImpl.class);
            Mockito.when(beerRepository.sortByRating())
                    .thenReturn(
                            beers);
            List<Beer> result=beerRepository.sortByRating();
            Assert.assertEquals(3,result.size());
        }

        @Test
        public void updateName_Should_Change_Beer_Name() {
            Beer beer=beer_maker().get(0);
            BeerRepositoryImpl beerRepository= Mockito.mock(BeerRepositoryImpl.class);
            Mockito.when(beerRepository.updateName(1,"Zagorka Retro"))
                    .thenReturn(beer);
            Beer result=beerRepository.updateName(1,"Zagorka Retro");
            Assert.assertEquals("Zagorka",result.getBeer_name());
        }

        @Test
        public void updateABV() {
            Beer beer=beer_maker().get(0);
            BeerRepositoryImpl beerRepository= Mockito.mock(BeerRepositoryImpl.class);
            Mockito.when(beerRepository.updateABV(1,5.6))
                    .thenReturn(beer);
            Beer result=beerRepository.updateABV(1,5.6);
            Assert.assertEquals(5.6,result.getABV(),0.0);
        }

        @Test
        public void updateCountry() {
            Beer beer=beer_maker().get(0);
            BeerRepositoryImpl beerRepository= Mockito.mock(BeerRepositoryImpl.class);
            Mockito.when(beerRepository.updateCountry(1,new OriginCountry("USA")))
                    .thenReturn(beer);
            Beer result=beerRepository.updateCountry(1,new OriginCountry("USA"));
            Assert.assertEquals("USA",result.getCountry().getName());
        }

        @Test
        public void updateDescription() {
        }

        @Test
        public void updateBrewery() {
        }

        @Test
        public void updateStyle() {
        }

        @Test
        public void create() {
        }

        @Test
        public void delete() {
        }

        @Test
        public void sortByABV() {
        }

        @Test
        public void filterByStyle() {
        }

        @Test
        public void filterByTags() {
        }

        @Test
        public void updateRating() {
        }
        private List<Beer> beer_maker() {
            List<Beer> list = new ArrayList<>();
            Beer zagorka = new Beer(1, "Zagorka", new Brewery("ZAGORKA OOD"), new OriginCountry("USA"), 5.6, "Tasty", new BeerStyle("DARK"), 0);
            Beer kamenitza = new Beer(2, "Kamenitza", new Brewery("KAMENITZA AD"), new OriginCountry("BG"), 4.5, "Neutral", new BeerStyle("WHITE"), 0);
            Beer ariana = new Beer(3, "Ariana", new Brewery("ARIANA AD"), new OriginCountry("COUNTRY"), 3.5, "Nasty", new BeerStyle("YELLOW"), 0);
            list.add(zagorka);
            list.add(kamenitza);
            list.add(ariana);
            return list;
        }
    }
}
