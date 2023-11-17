package com.bytebankers.contabancaria.ex;

public class ContaNaoEncontradaException extends RuntimeException{
    public ContaNaoEncontradaException(String message){
        super(message);
    }
}
