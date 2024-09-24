package pe.edu.cibertec.rueditasbackend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.rueditasbackend.dto.VehiculoRequest;
import pe.edu.cibertec.rueditasbackend.dto.VehiculoResponse;
import pe.edu.cibertec.rueditasbackend.servicie.impl.interfaces.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")

    public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping
    public VehiculoResponse buscarVehiculo(@RequestBody VehiculoRequest request) {
        System.out.println("request = " + request);
        try {
            String[] datosVehiculos = vehiculoService.buscarVehiculo(request);
            if (datosVehiculos == null) {
                return new VehiculoResponse(
                        "01",
                        "Error: Auto no encontrado", "", "", "", "", "");
            }
            return new VehiculoResponse(
                    "00",
                    "",
                    datosVehiculos[0],
                    datosVehiculos[1],
                    datosVehiculos[2],
                    datosVehiculos[3],
                    datosVehiculos[4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new VehiculoResponse(
                    "99", "Error: Ocurrió un problema", "", "", "", "", "");
        }
    }
}