package com.fonyou.employee.test;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VentaElectrodomestico {

    public static void main(String[] args) {

        Electrodomestico electrodomestico = new Electrodomestico();
        Electrodomestico electrodomesticoPesadoCategoria = new Electrodomestico(190000D, 81D);
        Electrodomestico electrodomesticoPersonalizado = new Electrodomestico(190000D, "ROJO", 'A', 50D);

        Lavadora lavadora = new Lavadora();
        Lavadora lavadoraPrecioPesoPersonalizado = new Lavadora(190000D, 81D);
        Lavadora lavadoraPersonalizado = new Lavadora(590000D, "ROJO", 'A', 81D, 50D);

        Televisor televisor = new Televisor();
        Televisor televisorPesadoCategoria = new Televisor(550000D, 31D);
        Televisor televisorPersonalizado = new Televisor(190000D, "ROJO", 'A', 81D, 50D, true);

        List<Electrodomestico> electrodomesticos = new ArrayList<>(10);
        electrodomesticos.add(electrodomestico);
        electrodomesticos.add(electrodomesticoPesadoCategoria);
        electrodomesticos.add(electrodomesticoPersonalizado);
        electrodomesticos.add(lavadora);
        electrodomesticos.add(lavadoraPrecioPesoPersonalizado);
        electrodomesticos.add(lavadoraPersonalizado);
        electrodomesticos.add(televisor);
        electrodomesticos.add(televisorPesadoCategoria);
        electrodomesticos.add(televisorPersonalizado);

        Map<String, DoubleSummaryStatistics> valuesResult = electrodomesticos.stream()
                .collect(Collectors.groupingBy(e -> e.getClass().getSimpleName(),
                        Collectors.summarizingDouble(Electrodomestico::precioFinal)));

        List<Double> summaryResult = valuesResult.entrySet().stream()
                .peek(c -> System.out.println("Key: " + c.getKey() + " Value: " + c.getValue().getSum()))
                .map(m -> m.getValue().getSum())
                .collect(Collectors.toList());

        System.out.println(summaryResult.stream().reduce(Double::sum).get());

        Double finalPrice = electrodomesticos.stream().map(Electrodomestico::precioFinal)
                .peek(System.out::println)
                .reduce(Double::sum)
                .orElse(0D);
        System.out.println(finalPrice);
    }

}
