package com.bytebankers.contabancaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
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

   public int getNumConta(){return this.numconta;}
   public void setNumConta(int novoNumero){
    this.numconta = novoNumero;
   }

   public String getTipo(){
    return this.tipo;
   }
   public void setTipo(String novoTipo){
    this.tipo = novoTipo;
   }

   public String getDono(){
    return this.dono;
   }
   public void setDono(String novoDono){
    this.dono = novoDono;
   }
   
   public float getSaldo(){
    return this.saldo;
   }
   public void setSaldo(float novoSaldo){
    this.saldo = novoSaldo;
   }

   public boolean getStatus(){
    return this.status;
   }
   public void setStatus(boolean novoStatus){
    this.status = novoStatus;
   }

    public void abrirConta() {
        if(!this.status){
            System.out.println("Abrindo conta!");
            this.status = true;
            if(this.tipo == "CC"){
                this.saldo = 50.f;
            }
            else{
                 this.saldo = 150.f;
            }
        }else{
            System.out.println("Sua conta já está aberta!");
        }
    }
    public void fechaConta() {
        if(this.status){
            System.out.println("conta ja aberta");
        }
        else if(this.saldo != 0){
            System.out.println("esvaziar saldo da conta");
        }
        else{
            System.out.println("fechando conta");
            this.status = false;
        }
    }
    
    public void depositar(float deposito){
        if(!this.status){
            System.out.println("Ative a sua conta para poder fazer um depósito dinheiro");
        }else{
            this.saldo += deposito;
            System.out.println("Dinheiro depositado: "+ this.saldo);
        } 
    }

    public void pagarMensalidade(){
       if(this.status){
           if(this.tipo == "CC"){
               this.saldo -= 12f;
           }else {
               this.saldo -= 20f;
           }
           System.out.println("Mensalidade paga. Saldo atual: " + this.saldo);
       }else {
           System.out.println("Conta precisa ser aberta para poder pagar mensalidade");
       }
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