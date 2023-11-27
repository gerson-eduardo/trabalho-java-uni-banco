package com.bytebankers.contabancaria.ex;

public class ErroAoFecharConta extends RuntimeException{
    public ErroAoFecharConta(String message){
        super(message);
    }
}
