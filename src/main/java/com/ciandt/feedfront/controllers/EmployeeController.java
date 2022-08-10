package com.ciandt.feedfront.controllers;

import com.ciandt.feedfront.contracts.Service;
import com.ciandt.feedfront.exceptions.ArquivoException;
import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.exceptions.IllegalArgumentExecption;
import com.ciandt.feedfront.models.Employee;

import java.util.List;

public class EmployeeController {
    Service<Employee> service;

    List<Employee> listar() throws ArquivoException{ return null; }
    Employee buscar(String id) throws ArquivoException, BusinessException{ return null; }
    Employee salvar(Employee e) throws ArquivoException, BusinessException, IllegalArgumentExecption{ return null; }
    Employee atualizar(Employee e) throws ArquivoException, BusinessException, IllegalArgumentExecption{ return null; }
    void apagar(String id) throws ArquivoException, BusinessException{}
}
