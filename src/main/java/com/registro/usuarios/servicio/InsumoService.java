package com.registro.usuarios.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registro.usuarios.modelo.Insumo;
import com.registro.usuarios.repositorio.InsumoRepositorio;

@Service
public class InsumoService implements IInsumoService {

    @Autowired
    private InsumoRepositorio repositorio;

    @Override
    public List<Insumo> listar() {
        return repositorio.findAll();
    }

    @Override
    public Insumo listarId(int idInsumo) {
        return repositorio.findById(idInsumo).orElse(null);
    }

    @Override
    public void save(Insumo insumo) {
        repositorio.save(insumo);
    }

    @Override
    public void delete(int idInsumo) {
        repositorio.deleteById(idInsumo);
    }
}