package com.bytebankers.contabancaria.ex;

public class ContaNaoAtiva extends RuntimeException{
    public ContaNaoAtiva(String message){
        super(message);
    }
}
