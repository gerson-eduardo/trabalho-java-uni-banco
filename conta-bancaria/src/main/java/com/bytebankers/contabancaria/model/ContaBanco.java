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
   void status ()
        {
        System.out.println("Número da conta: " + this.numconta);
        System.out.println("Tipo de conta:" + this.tipo);
        System.out.println("Nome do titular da conta: " + this.dono);
        System.out.println("Saldo da conta: " + this.saldo);
        System.out.println("A conta está aberta? " + this.status);
    }
    void abrirConta() {
     if (this.status == false){
         System.out.println("Abra sua conta!");
     }else {
         System.out.println("Sua conta está aberta! ");
         
     }
    }
    
   
}
