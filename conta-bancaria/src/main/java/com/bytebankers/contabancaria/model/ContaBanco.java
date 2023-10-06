package com.bytebankers.contabancaria.model;
public class ContaBanco {
   
   public int numconta;
   protected String tipo;
   private String dono;
   private float saldo;
   private boolean status;

   public int getNumConta(){
    return this.numconta;
   }
   public void setNumConta(int Novonumero){
    this.numconta = Novonumero;
   }

   public String getTipo(){
    return this.tipo;
   }
   public void setTipo(String Novotipo){
    this.tipo = Novotipo;
   }

   public String getDono(){
    return this.dono;
   }
   public void setDono(String Novodono){
    this.dono = Novodono;
   }
   
   public float getSaldo(){
    return this.saldo;
   }
   public void setSaldo(float Novosaldo){
    this.saldo = Novosaldo;
   }

   public boolean getStatus(){
    return this.status;
   }
   public void setStatus(boolean Novostatus){
    this.status = Novostatus;
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