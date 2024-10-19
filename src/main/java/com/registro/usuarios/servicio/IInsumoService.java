package com.registro.usuarios.servicio;

import java.util.List;
import com.registro.usuarios.modelo.Insumo;

public interface IInsumoService {
    public List<Insumo> listar();
    public Insumo listarId(int idInsumo);
    public void save(Insumo insumo);
    public void delete(int idInsumo);
}