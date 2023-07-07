package com.example.andreysshop.web;

import com.example.andreysshop.model.binding.ItemAddBindingModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @GetMapping("/add")
    public String add(){
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("itemAddBindingModel")
                             ItemAddBindingModel itemAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            return "redirect:add";
        }
        //todo save in DB

        return "redirect:/";

    }
}
