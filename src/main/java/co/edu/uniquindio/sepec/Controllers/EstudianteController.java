package co.edu.uniquindio.sepec.Controllers;

import co.edu.uniquindio.sepec.Entities.Estudiante;
import co.edu.uniquindio.sepec.Services.EstudianteService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/crear")
    public ResponseEntity<?> createEstudiante(@RequestBody Estudiante estudiante){
        try {
            if(estudianteService.createEstudiante(estudiante)) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante creado correctamente");
            }
            else {
                JSONObject objetoJson = new JSONObject();
                objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
                objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
                objetoJson.put("Mensaje", "No es posible registrar el Estudiante, puede que ya exista uno con el mismo nombre");
                String jsonString = objetoJson.toString();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
            }
        }catch (Exception e) {
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
            objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
            objetoJson.put("Mensaje", "Ocurrio un problema");
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getEstudiantesPromedio() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    estudianteService.getAllEstudiantesPuntaje());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo error", HttpStatus.NOT_FOUND.value());
            objetoJson.put("Descripción error", HttpStatus.NOT_FOUND);
            objetoJson.put("Mensaje", "No existen registros en la BD");
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

    @GetMapping("/test/{codigo}")
    public ResponseEntity<?> getResultadoTest(@PathVariable Integer codigo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    estudianteService.getResultadosTest(codigo));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo error", HttpStatus.NOT_FOUND.value());
            objetoJson.put("Descripción error", HttpStatus.NOT_FOUND);
            objetoJson.put("Mensaje", "No existen registros en la BD");
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

}
