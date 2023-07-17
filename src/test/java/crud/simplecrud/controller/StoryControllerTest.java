package crud.simplecrud.controller;

import crud.simplecrud.domain.Story;
import crud.simplecrud.repository.StoryRepository;
import crud.simplecrud.service.StoryService;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StoryControllerTest {

    @Autowired
    EntityManager em;

    @Autowired
    StoryRepository storyRepository;

    @Autowired StoryService storyService;

    @Test
    void joinTest(){
        //given
        Story story = new Story("stroy1", "content1");

        //when
        Long joinId = storyService.join(story);

        //then
        Story findStory = storyService.findId(story.getId());
        Story id = storyService.findId(joinId);
        assertThat(findStory).isEqualTo(id);
    }

    @Test
    void update(){
        //given
        Story story = new Story("stroy1", "content1");
        Long joinId = storyService.join(story);

        //when
        storyService.update(joinId,new Story("updateStory","updateContent"));

        //then
        Story st = storyService.findId(joinId);
        assertThat(st.getName()).isEqualTo("updateStory");
        assertThat(st.getContent()).isEqualTo("updateContent");
    }

    @Test
    void delete(){
        //given
        Story story = new Story("stroy1", "content1");
        Long joinId = storyService.join(story);

        //when
        storyService.delete(joinId);

        //then
        List<Story> list = storyService.findStory();
        assertThat(list.size()).isEqualTo(0);

    }

}