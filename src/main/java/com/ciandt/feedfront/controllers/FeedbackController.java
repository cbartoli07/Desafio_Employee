package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.exceptions.ArquivoException;
import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.models.Feedback;

import java.util.List;

public class FeedbackController {
    Service<Feedback> service;

    List<Feedback> listar() throws ArquivoException{
        return null;
    }
    Feedback buscar(String id) throws ArquivoException, BusinessException{
        return null;
    }
    Feedback salvar(Feedback f) throws ArquivoException, BusinessException, IllegalArgumentException{
        return null;
    }
    Feedback atualizar(Feedback f) throws ArquivoException, BusinessException, IllegalArgumentException{
        return null;
    }
    void apagar(String id) throws ArquivoException, BusinessException{}
}
