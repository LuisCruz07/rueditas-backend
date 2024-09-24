package pe.edu.cibertec.rueditasbackend.servicie.impl.interfaces;

import pe.edu.cibertec.rueditasbackend.dto.VehiculoRequest;

import java.io.IOException;

public interface VehiculoService {
    String[] buscarVehiculo(VehiculoRequest request) throws IOException;
}
