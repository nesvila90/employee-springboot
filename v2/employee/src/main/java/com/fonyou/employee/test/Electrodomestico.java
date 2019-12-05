package com.fonyou.employee.test;

import java.util.stream.Stream;

/**
 * The type Electrodomestico.
 */
public class Electrodomestico {

    private Double precioBase;
    private String color;
    private char consumoEnergetico;
    private Double peso;

    /**
     * Instantiates a new Electrodomestico.
     */
    public Electrodomestico() {
        this.precioBase = ElectrodomesticoInicial.PRECIO_BASE_POR_DEFECTO;
        this.color = ElectrodomesticoInicial.COLOR_POR_DEFECTO;
        this.consumoEnergetico = ElectrodomesticoInicial.CONSUMO_ENERGETICO_POR_DEFECTO;
        this.peso = ElectrodomesticoInicial.PESO_POR_DEFECTO;
    }

    /**
     * Instantiates a new Electrodomestico.
     *
     * @param precioBase the precio base
     * @param peso       the peso
     */
    public Electrodomestico(Double precioBase, Double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.consumoEnergetico = ElectrodomesticoInicial.CONSUMO_ENERGETICO_POR_DEFECTO;
        this.color = ElectrodomesticoInicial.COLOR_POR_DEFECTO;
    }

    /**
     * Instantiates a new Electrodomestico.
     *
     * @param precioBase        the precio base
     * @param color             the color
     * @param consumoEnergetico the consumo energetico
     * @param peso              the peso
     */
    public Electrodomestico(Double precioBase, String color, char consumoEnergetico, Double peso) {
        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    /**
     * Gets precio base.
     *
     * @return the precio base
     */
    public Double getPrecioBase() {
        return precioBase;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Gets consumo energetico.
     *
     * @return the consumo energetico
     */
    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    /**
     * Gets peso.
     *
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * Precio final double.
     *
     * @return the double
     */
    public Double precioFinal() {
        ConsumoEnergetico consumoEnergeticoPorCategoria = getConsumoPorCategoria(getConsumoEnergetico());
        return getPrecioBase() + consumoEnergeticoPorCategoria.getPrecio() + calcularPrecioSegunPeso(getPeso());
    }

    private final char comprobarConsumoEnergetico(char letra) {
        return Stream.of(ConsumoEnergetico.values()).map(ConsumoEnergetico::getCategoria)
                .filter(color -> color == letra)
                .findAny()
                .orElse(ElectrodomesticoInicial.CONSUMO_ENERGETICO_POR_DEFECTO);
    }

    private final String comprobarColor(String color) {
        return Stream.of(ElectrodomesticoInicial.colores)
                .filter(valor -> valor.equalsIgnoreCase(color))
                .findAny()
                .orElse(ElectrodomesticoInicial.COLOR_POR_DEFECTO);
    }

    private Double calcularPrecioSegunPeso(Double peso) {

        Double precioSegunPeso = 0D;

        if (peso >= RangoPeso.RANGO_0_19.getPesoInicial() && peso <= RangoPeso.RANGO_0_19.getPesoFinal()) {
            precioSegunPeso = RangoPeso.RANGO_0_19.getPrecioRango();
        } else if (peso >= RangoPeso.RANGO_20_49.getPesoInicial() && peso <= RangoPeso.RANGO_20_49.getPesoFinal()) {
            precioSegunPeso = RangoPeso.RANGO_20_49.getPrecioRango();
        } else if (peso >= RangoPeso.RANGO_50_79.getPesoInicial() && peso <= RangoPeso.RANGO_50_79.getPesoFinal()) {
            precioSegunPeso = RangoPeso.RANGO_50_79.getPrecioRango();
        } else if (peso >= RangoPeso.RANGO_MAYOR_80.getPesoInicial()) {
            precioSegunPeso = RangoPeso.RANGO_MAYOR_80.getPrecioRango();
        }
        return precioSegunPeso;

    }

    /**
     * @param categoria
     * @return
     */
    private ConsumoEnergetico getConsumoPorCategoria(char categoria) {
        return Stream.of(ConsumoEnergetico.values())
                .filter(cat -> cat.getCategoria() == categoria)
                .findAny()
                .orElse(ConsumoEnergetico.CATEGORIA_F);
    }
}
