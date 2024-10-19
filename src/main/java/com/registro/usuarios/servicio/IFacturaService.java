package com.registro.usuarios.servicio;

import java.util.List;
import com.registro.usuarios.modelo.Factura;

public interface IFacturaService {
    public List<Factura> listar();
    public Factura listarId(int idFactura);
    public void save(Factura factura);
    public void delete(int idFactura);
}
