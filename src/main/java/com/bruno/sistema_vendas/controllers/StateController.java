package com.bruno.sistema_vendas.controllers;

import com.bruno.sistema_vendas.models.StateModel;
import com.bruno.sistema_vendas.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class StateController {
    @Autowired
    private StateRepository stateRepository;

    @GetMapping("/cadastrarEstado")
    public ModelAndView cadastrar(StateModel state){
        ModelAndView mv = new ModelAndView("/administrativo/estados/cadastro");
        mv.addObject("estado", state);

        return mv;
    }

    @PostMapping("/salvarEstado")
    public ModelAndView salvar(StateModel state, BindingResult result){
        if(result.hasErrors()){
            return cadastrar(state);
        }

        stateRepository.saveAndFlush(state);
        return cadastrar(new StateModel());
    }

    @GetMapping("/listarEstado")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("administrativo/estados/lista");
        mv.addObject("listaEstados", stateRepository.findAll());

        return mv;
    }

    @GetMapping("/editarEstado/{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        Optional<StateModel> state = stateRepository.findById(id);

        return cadastrar(state.get());
    }

    @GetMapping("/removerEstado/{id}")
    public ModelAndView remover(@PathVariable("id") Long id){
        Optional<StateModel> state = stateRepository.findById(id);

        stateRepository.delete(state.get());

        return listar();
    }
}
