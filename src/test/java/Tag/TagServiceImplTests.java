package Tag;

import com.beerdemo.demo.entities.Tag;
import com.beerdemo.demo.repositories.TagRepository;
import com.beerdemo.demo.services.TagServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class TagServiceImplTests {
    @Test
    public void getAll_Should_ReturnMatchingTags_WhenMachExist(){
        //Arrange
        List<Tag> tags=new ArrayList<>();

        tags.add( new Tag("tag"));
        tags.add( new Tag("tag1"));

        TagRepository tagRepository = Mockito.mock(TagRepository.class);

        Mockito.when(tagRepository.getAllTags())
                .thenReturn(tags);

        TagServiceImpl service = new TagServiceImpl(tagRepository);

        //Act
        List<Tag> result = service.getAllTags();

        //Assert
        Assert.assertEquals(2, result.size());
    }

}
