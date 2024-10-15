package com.bruno.sistema_vendas.controllers;

import com.bruno.sistema_vendas.models.StateModel;
import com.bruno.sistema_vendas.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StateController {
    @Autowired
    private StateRepository stateRepository;

    @GetMapping("/cadastrarEstado")
    public ModelAndView cadastrar(StateModel stateModel){
        ModelAndView mv = new ModelAndView("/administrativo/estados/cadastro");
        mv.addObject("estado", stateModel);

        return mv;
    }


}