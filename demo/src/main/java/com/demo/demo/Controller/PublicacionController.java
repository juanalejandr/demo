package com.demo.demo.Controller;

import com.demo.demo.Dto.PublicacionDto;
import com.demo.demo.Service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

   @PostMapping
    public ResponseEntity<PublicacionDto> guardarPublicacion(@RequestBody PublicacionDto publicacionDto){
    return new ResponseEntity<>(publicacionService.crearPublicacion(publicacionDto), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<PublicacionDto> listarPublicaciones(){
       return publicacionService.obtenerTodasLasPublicaciones();
    }

    @GetMapping ("{/id}")
    public ResponseEntity<PublicacionDto> obtenerPublicacionPorId (@PathVariable(name = "id") long id){
       return ResponseEntity.ok(publicacionService.obtenerPublicacioPorId(id));
    }

    @PutMapping ("{/id}")
    public ResponseEntity<PublicacionDto> actualizarPublicacion (@RequestBody PublicacionDto publicacionDto, @PathVariable(name = "id") long id){
       PublicacionDto publicacionrespuesta = publicacionService.actualizarPublicacion(publicacionDto, id);
       return new ResponseEntity<>(publicacionrespuesta,HttpStatus.OK);
    }

    @DeleteMapping ("{/id}")
    public ResponseEntity<String> eliminarpublicacion(@PathVariable(name = "id") long id){
       publicacionService.eliminarPublicacion(id);
       return new ResponseEntity<>("Publicacion eliminada", HttpStatus.OK);
   }
}
