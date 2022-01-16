package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.IEmpleadoDao;
import com.capgemini.entities.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	private IEmpleadoDao empleadoDao;
	

	@Override
	public List<Empleado> getEmpleados() {
		// TODO Auto-generated method stub
		return empleadoDao.findAll();
	}

	@Override
	public void save(Empleado empleado) {
		// TODO Auto-generated method stub
		empleadoDao.save(empleado);
	}

}
