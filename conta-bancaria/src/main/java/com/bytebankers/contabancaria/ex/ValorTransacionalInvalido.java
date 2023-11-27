package com.bytebankers.contabancaria.ex;

public class ValorTransacionalInvalido extends RuntimeException{
    public ValorTransacionalInvalido(String message){
        super(message);
    }
}
