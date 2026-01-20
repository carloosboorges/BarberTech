package dev.borges.BarberTech.dto.request;

import dev.borges.BarberTech.entity.ClienteModel;

import java.time.LocalDate;

public class VendaRequest {

    private LocalDate data;
    private Double valorTotal;
    private ClienteModel cliente;

}
