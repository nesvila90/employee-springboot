package com.fonyou.employee.test;

public abstract class ElectrodomesticoInicial {

    public static final char CONSUMO_ENERGETICO_POR_DEFECTO = ConsumoEnergetico.CATEGORIA_F.getCategoria();
    protected static final String[] colores = {"blanco", "negro", "rojo", "azul", "gris"};
    public static final String COLOR_POR_DEFECTO = colores[0];
    public static final Double PESO_POR_DEFECTO = 5D;
    public static final Double PRECIO_BASE_POR_DEFECTO = 100000D;

    private ElectrodomesticoInicial() {
    }
}
