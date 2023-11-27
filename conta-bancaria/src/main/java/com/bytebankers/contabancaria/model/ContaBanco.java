package com.bytebankers.contabancaria.model;

import com.bytebankers.contabancaria.ex.ContaJaAtiva;
import com.bytebankers.contabancaria.ex.ContaNaoAtiva;
import com.bytebankers.contabancaria.ex.ErroAoFecharConta;
import com.bytebankers.contabancaria.ex.ValorTransacionalInvalido;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class ContaBanco {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public int numconta;
   protected String tipo;
   private String dono;
   private float saldo;
   private boolean status;

   public ContaBanco(String dono, String tipo){
       this.dono = dono;
       this.tipo = tipo;
   }

    public void abrirConta() {
        if(this.status) {
            throw new ContaJaAtiva("Conta não está ativa!");
        }
        this.status = true;
        if(this.tipo == "CC"){
                this.saldo = 50.f;
        }
        else{
            this.saldo = 150.f;
        }
    }
    public void fechaConta() {
       if(!this.status || saldo != 0f){
           throw new ErroAoFecharConta("Erro ao fechar a conta");
       }
        this.status = false;
    }
    
    public void depositar(float deposito){
        if(!this.status){
            throw new ContaNaoAtiva("Conta precisa ser ativada");
        }else if(deposito <= 0){
            throw new ValorTransacionalInvalido("Valor menor ou igual a 0");
        }
        this.saldo += deposito;
    }

    public void sacar(float saque){
        if(!this.status){
            throw new ContaNaoAtiva("Conta precisa ser ativada");
        }else if(saque <= 0){
            throw new ValorTransacionalInvalido("Valor menor ou igual a 0");
        }else if(this.saldo - saque < 0){
            throw new ValorTransacionalInvalido("Valor do saque é maior que o valor do saldo");
        }
        this.saldo -= saque;
    }

    public void pagarMensalidade(float mensalidade){
       if(!this.status) {
           throw new ContaNaoAtiva("Conta precisa ser ativada");
       }else if(mensalidade <= 0) {
           throw new ValorTransacionalInvalido("Valor menor ou igual a 0");
       }

       float mensalidadeTotal;
       if(this.tipo.equals("CC")){
           mensalidadeTotal = mensalidade + 12f;
       }else {
           mensalidadeTotal = mensalidade +20f;
       }

       if(this.saldo - mensalidadeTotal < 0) {
           throw new ValorTransacionalInvalido("Valor da transação excedeu o saldo");
       }
       this.saldo -= mensalidadeTotal;
    }

    @Override
    public String toString() {
        return  "Número da conta: " + this.numconta + "\n" +
                "Tipo de conta: " + this.tipo + "\n" +
                "Nome do titular da conta: " + this.dono + "\n" +
                "Saldo da conta: " + this.saldo + "\n" +
                "A conta está aberta? " + this.status;
    }
}