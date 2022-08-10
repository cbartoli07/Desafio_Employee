package com.ciandt.feedfront.services;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.exceptions.ArquivoException;
import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.exceptions.IllegalArgumentExecption;
import com.ciandt.feedfront.models.Employee;

import java.util.List;

public class EmployeeService implements Service {
    DAO<Employee> dao;

    @Override
    public List listar() throws ArquivoException {
        return null;
    }

    @Override
    public Object buscar(String id) throws ArquivoException, BusinessException {
        return null;
    }

    @Override
    public Object salvar(Object o) throws ArquivoException, BusinessException, IllegalArgumentExecption {
        return null;
    }

    @Override
    public Object atualizar(Object o) throws ArquivoException, BusinessException, IllegalArgumentExecption {
        return null;
    }

    @Override
    public void apagar(String id) throws ArquivoException, BusinessException {

    }
}
