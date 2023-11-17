package com.bytebankers.contabancaria.ex;

public class TipoInvalidoDeContaException extends RuntimeException{
    public TipoInvalidoDeContaException(String message){
        super(message);
    }
}
