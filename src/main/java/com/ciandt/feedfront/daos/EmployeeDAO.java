package com.ciandt.feedfront.daos;

import com.ciandt.feedfront.contracts.DAO;
import com.ciandt.feedfront.exceptions.EntidadeNaoSerializavelException;

import java.io.IOException;
import java.util.List;

public class EmployeeDAO implements DAO {

    @Override
    public boolean tipoImplementaSerializable() {
        return false;
    }

    @Override
    public List listar() throws IOException, EntidadeNaoSerializavelException, EntidadeNaoSerializavelException {
        return null;
    }

    @Override
    public Object buscar(String id) throws IOException, EntidadeNaoSerializavelException {
        return null;
    }

    @Override
    public Object salvar(Object o) throws IOException, EntidadeNaoSerializavelException {
        return null;
    }

    @Override
    public boolean apagar(String id) throws IOException, EntidadeNaoSerializavelException {
        return false;
    }
}
