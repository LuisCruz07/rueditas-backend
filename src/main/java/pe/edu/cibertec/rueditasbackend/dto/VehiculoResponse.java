package pe.edu.cibertec.rueditasbackend.dto;

public record VehiculoResponse(String codigo,
                              String mensaje,
                              String autoMarca,
                              String autoModelo,
                              String autoNroAsientos,
                              String autoPrecio,
                              String autoColor) {
}
