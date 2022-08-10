package com.ciandt.feedfront.contracts;

import com.ciandt.feedfront.exceptions.ArquivoException;
import com.ciandt.feedfront.exceptions.BusinessException;
import com.ciandt.feedfront.exceptions.IllegalArgumentExecption;

import java.util.List;

public interface Service<E> {
    List<E> listar() throws ArquivoException;
    E buscar(String id) throws ArquivoException, BusinessException;
    E salvar(E e) throws ArquivoException, BusinessException, IllegalArgumentExecption;
    E atualizar(E e) throws ArquivoException, BusinessException, IllegalArgumentExecption;
    void apagar(String id) throws ArquivoException, BusinessException;
}
