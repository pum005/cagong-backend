package kr.ac.cnu.swacademy.cagong.controller;

import kr.ac.cnu.swacademy.cagong.service.question.QuestionService;
import kr.ac.cnu.swacademy.cagong.dto.QuestionSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question/save")
    public String questionSave(Model model) {
        model.addAttribute("saveForm", new QuestionSaveRequestDto());
        return "question/saveForm";
    }

    @GetMapping("/question/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        model.addAttribute("question", questionService.findById(id));
        return "question/updateForm";
    }
}
