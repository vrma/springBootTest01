package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Empleado;

public interface IEmpleadoService {
	public List<Empleado> getEmpleados();
	public void save(Empleado empleado);
}
