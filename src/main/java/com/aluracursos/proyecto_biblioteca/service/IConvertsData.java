package com.aluracursos.proyecto_biblioteca.service;

public interface IConvertsData {
    // Metodo genérico para obtener los datos de la API

    <T> T getData(String json, Class<T> clase);
}
