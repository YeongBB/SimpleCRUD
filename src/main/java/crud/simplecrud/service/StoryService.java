package crud.simplecrud.service;

import crud.simplecrud.domain.Story;
import crud.simplecrud.repository.StoryRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StoryService {

    private final StoryRepository storyRepository;

    // 저장
    @Transactional
    public Long join(Story story){
        storyRepository.save(story);
        return story.getId();
    }

    // 조회
    public List<Story> findStory(){
        return storyRepository.findAll();
    }

    // 업데이트
    @Transactional
    public void update(Long id, Story updateParam){
        Story story = findId(id);
        story.update(updateParam.getName(), updateParam.getContent());
    }

    // 삭제
    @Transactional
    public void delete(Long id){
        storyRepository.deleteById(id);
    }

    // 내 아이디 찾기
    public Story findId(Long id){
        return storyRepository.findById(id).get();
    }
}
