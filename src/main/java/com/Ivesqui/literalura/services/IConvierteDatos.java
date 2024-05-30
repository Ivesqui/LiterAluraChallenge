package com.Ivesqui.literalura.services;

public interface IConvierteDatos {

    <T> T convertidora(String json, Class<T> clase);

}
