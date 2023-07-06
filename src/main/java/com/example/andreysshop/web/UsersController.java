package com.example.andreysshop.web;

import com.example.andreysshop.model.binding.UserLoginBindingModel;
import com.example.andreysshop.model.binding.UserRegisterBindingModel;
import com.example.andreysshop.model.service.UserServiceModel;
import com.example.andreysshop.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String LoginConfirm(@Valid @ModelAttribute("userLoginBindingModel")
                                   UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult , RedirectAttributes redirectAttributes,
                               HttpSession httpSession){

        if(bindingResult.hasErrors()){
            return "redirect:login";
        }

        UserServiceModel user = this.userService.findByUsername(userLoginBindingModel.getUsername());

        if(user == null || !user.getPassword().equals(userLoginBindingModel.getPassword())){
            redirectAttributes.addFlashAttribute("notFound" , true);

            //todo redirect att

            return "redirect:login";
        }

        httpSession.setAttribute("user", user);

        return "redirect:/";

    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel")UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())){
            return "redirect:register";
        }

        boolean isRegister = userService.register(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:login";

    }





}
