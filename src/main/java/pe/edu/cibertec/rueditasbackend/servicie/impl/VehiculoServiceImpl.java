package pe.edu.cibertec.rueditasbackend.servicie.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import pe.edu.cibertec.rueditasbackend.dto.VehiculoRequest;
import pe.edu.cibertec.rueditasbackend.servicie.impl.interfaces.VehiculoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public String[] buscarVehiculo(VehiculoRequest request) throws IOException {

            String[] datosVehiculos = null;
            Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");
            try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(";");
                    if (request.placa().equals(datos[1])) {
                        datosVehiculos = new String[5];
                        datosVehiculos[0] = datos[2];
                        datosVehiculos[1] = datos[3];
                        datosVehiculos[2] = datos[4];
                        datosVehiculos[3] = datos[5];
                        datosVehiculos[4] = datos[6];
                        break;
                    }
                }
            } catch (IOException e) {
                datosVehiculos = null;
                throw new IOException(e);
            }
            return datosVehiculos;
        }

    }
