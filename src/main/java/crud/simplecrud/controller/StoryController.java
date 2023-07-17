package crud.simplecrud.controller;

import crud.simplecrud.domain.Story;
import crud.simplecrud.service.StoryForm;
import crud.simplecrud.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/content")
public class StoryController {

    private final StoryService storyService;

    // 추가
    @GetMapping("/new")
    public String createFrom(Model model){
        model.addAttribute("modelForm", new Story());
        return "createForm";
    }

    @PostMapping("/new")
    public String create(StoryForm storyForm, RedirectAttributes redirectAttributes){

        Story story = new Story(storyForm.getName(), storyForm.getContent());

        storyService.join(story);
        redirectAttributes.addAttribute("storyId", story.getId());
        return "redirect:/content/{stroyId}";
    }

    // 리스트 출력
    @GetMapping
    public String list(Model model){
        List<Story> stories = storyService.findStory();
        model.addAttribute("stories", stories);
        return "/content";
    }


    // 업데이트
    @GetMapping("/{stroyId}/edit")
    public String editForm(@PathVariable Long storyId, Model model){
        Story story = storyService.findId(storyId);
        return "/editForm";
    }

    @PostMapping("/{storyId}/edit")
    public String edit(@PathVariable Long storyId, @ModelAttribute Story story){
        storyService.update(storyId, story);
        return "redirect:/{storyId}";
    }

    // 삭제
    @GetMapping("/{storyId}/edit")
    public String delete(@PathVariable Long storyId){
        storyService.delete(storyId);
        return "redirect:/";
    }

}
