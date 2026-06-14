package com.tfg.servicio_api.dto;

public enum TipoAtributo {
    /*
    *  En esta enumeración se definen los tipos de atributos que puede tener una categoría en base al prompt activo de esta.
    *  Se describe a continuación las características que puede tener cada tipo
    * */
    // Campo de texto rellenable
    STRING,

    // Campo numérico
    NUMBER,

    // Desplegable con opción TRUE/FALSE
    BOOLEAN,

    // El atributo es una lista de strings, y permitimos buscar una cadena de texto en cada uno de los strings de la lista
    ARRAY_STRING,

    // Este tipo se usa cuando queremos un desplegable con varias opciones de tipo cadena
    DESPLEGABLE_STRINGS
}
