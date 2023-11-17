package com.bytebankers.contabancaria.service;

import com.bytebankers.contabancaria.ex.ContaNaoEncontradaException;
import com.bytebankers.contabancaria.ex.TipoInvalidoDeContaException;
import com.bytebankers.contabancaria.model.ContaBanco;
import com.bytebankers.contabancaria.repository.ContaBancoReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class ContaBancoService {

    @Autowired
    private ContaBancoReporitory reporitory;

    public ContaBanco criarConta(String nome, String tipo){
        if(!tipo.equals("CC")   && !tipo.equals("CP")){
            throw new TipoInvalidoDeContaException("Tipo de conta inválido");
        }
        ContaBanco conta = new ContaBanco(nome, tipo);
        conta.abrirConta();
        return reporitory.save(conta);
    }

    public ContaBanco entrarNaConta(int id, String nome){
        Optional<ContaBanco> conta = reporitory.findByNumcontaAndDono(id, nome);
        if(conta.isEmpty()){
            throw new ContaNaoEncontradaException("Conta não encontrada");
        }
        return conta.get();
    }

    public ContaBanco salvarAlteracoes(ContaBanco contaBanco){
        Optional<ContaBanco> conta = reporitory.findByNumconta(contaBanco.numconta);
        if(conta.isEmpty()){
            throw new ContaNaoEncontradaException("Conta não encontrada");
        }
        return reporitory.save(contaBanco);
    }
}
