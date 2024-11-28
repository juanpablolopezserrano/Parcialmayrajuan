package com.ParcialMayraJuanPablo.app.entidades;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombrep;
    private Integer cantidadp;
    private Double preciop;

    @OneToMany(mappedBy = "inventario")
    private List<Factura> facturas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombrep() {
		return nombrep;
	}

	public void setNombrep(String nombrep) {
		this.nombrep = nombrep;
	}

	public Integer getCantidadp() {
		return cantidadp;
	}

	public void setCantidadp(Integer cantidadp) {
		this.cantidadp = cantidadp;
	}

	public Double getPreciop() {
		return preciop;
	}

	public void setPreciop(Double preciop) {
		this.preciop = preciop;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

    
}

