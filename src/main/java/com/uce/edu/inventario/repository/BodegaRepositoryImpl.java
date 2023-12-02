package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Bodega;

@Repository
public class BodegaRepositoryImpl implements IBodegaRepository {

	private static List<Bodega> base = new ArrayList<Bodega>();

	@Override
	public Bodega seleccionar(String codigo) {
		for (Bodega bodega : base) {
			if (bodega.getCodigo().equals(codigo)) {
				Bodega bod = new Bodega();
				bod.setCapacidad(bodega.getCapacidad());
				bod.setCodigo(bodega.getCodigo());
				bod.setDireccion(bodega.getDireccion());
				bod.setNombre(bodega.getNombre());
				return bod;
			}
		}
		return null;
	}

	public Bodega seleccionarEliminar(String codigo) {

		for (Bodega bodega : base) {
			if (bodega.getCodigo().equals(codigo)) {
				return bodega;
			}
		}
		return null;
	}


	@Override
	public void insertar(Bodega bodega) {
		// TODO Auto-generated method stub
		base.add(bodega);
	}

	@Override
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.eliminar(bodega.getCodigo());
		this.insertar(bodega);

	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		Bodega bodega = this.seleccionarEliminar(codigo);
		base.remove(bodega);

	}

}
