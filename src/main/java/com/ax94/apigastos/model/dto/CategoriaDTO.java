package com.ax94.apigastos.model.dto;

import lombok.Data;

@Data
public class CategoriaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String icono;
    private String color;
}
