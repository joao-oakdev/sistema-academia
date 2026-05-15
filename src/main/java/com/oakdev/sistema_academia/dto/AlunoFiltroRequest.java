package com.oakdev.sistema_academia.dto;

public record AlunoFiltroRequest (
        String nome,
        String email,
        String celular,
        String cidade,
        String estado
){

}
