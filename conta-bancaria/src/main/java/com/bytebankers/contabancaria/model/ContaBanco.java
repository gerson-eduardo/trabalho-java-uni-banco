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
    this.status = Novostatus;https://github.com/Eduard0-GE/trabalho-java-uni-banco/pull/3/conflict?name=conta-bancaria%252Fsrc%252Fmain%252Fjava%252Fcom%252Fbytebankers%252Fcontabancaria%252Fmodel%252FContaBanco.java&ancestor_oid=a94d074612f053c67553299b02fbe01c92de4c27&base_oid=b97f58a32c1f7a0a3e3cffec50c6271fb495a0bc&head_oid=a062253dbbdc5dc8fe20b360115e74037455c00f
   }
   void status ()
        {
        System.out.println("Número da conta: " + this.numconta);
        System.out.println("Tipo de conta:" + this.tipo);
        System.out.println("Nome do titular da conta: " + this.dono);
        System.out.println("Saldo da conta: " + this.saldo);
        System.out.println("A conta está aberta? " + this.status);
    }
    public void abrirConta() {
        if(this.status == false){
            System.out.println("Abrindo conta!");
            this.status = true;
            if(this.tipo == "CC"){
                this.saldo = 50.f;
            }
            else{
                 this.saldo = 150.f;
            }
        }else{
            System.out.println("Sua conta já está aberta! ");
        }
    } 
    
    public void depositar(float deposito){
        if(this.status == false){
            System.out.println("Voce nao pode depositar dinheiro, ative sua conta!");
        }else{
            this.saldo += deposito;
            System.out.println("");   
        } 
    }
}