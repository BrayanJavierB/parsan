package com.registro.usuarios.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registro.usuarios.modelo.Factura;
import com.registro.usuarios.repositorio.FacturaRepositorio;

@Service
public class FacturaService implements IFacturaService {

    @Autowired
    private FacturaRepositorio repositorio;

    @Override
    public List<Factura> listar() {
        return repositorio.findAll();
    }

    @Override
    public Factura listarId(int idFactura) {
        return repositorio.findById(idFactura).orElse(null);
    }

    @Override
    public void save(Factura factura) {
        repositorio.save(factura);
    }

    @Override
    public void delete(int idFactura) {
        repositorio.deleteById(idFactura);
    }
}
