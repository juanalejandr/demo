package com.demo.demo.Service;

import com.demo.demo.Dto.PublicacionDto;
import com.demo.demo.Exceptions.ResourceNotFoundException;
import com.demo.demo.Models.Publicacion;
import com.demo.demo.Repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionServiceImpl implements PublicacionService{

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto) {

        Publicacion publicacion = mapearEntidad(publicacionDto);

        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);

        PublicacionDto publicacionRespuesta = mapearDto(nuevaPublicacion);
        return publicacionRespuesta;
    }

    @Override
    public List<PublicacionDto> obtenerTodasLasPublicaciones() {
        List<Publicacion> publicacions = publicacionRepository.findAll();
        return publicacions.stream().map(publicacion -> mapearDto(publicacion)).collect(Collectors.toList());
    }

    @Override
    public PublicacionDto obtenerPublicacioPorId(long id) {
        Publicacion publicacion = publicacionRepository.getReferenceById(id).orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));
    }

    @Override
    public PublicacionDto actualizarPublicacion(PublicacionDto publicacionDto, long id) {
        Publicacion publicacion = publicacionRepository.getReferenceById(id).orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));

        publicacionDto.setTitulo(publicacion.getTitulo());
        publicacionDto.setDescripcion(publicacion.getDescripcion());
        publicacionDto.setContenido(publicacion.getContenido());

        Publicacion publicacionActualizada = publicacionRepository.save(publicacion);
        return mapearDto(publicacionActualizada);
    }

    @Override
    public void eliminarPublicacion(long id) {
        Publicacion publicacion = publicacionRepository.getReferenceById(id).orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));

        publicacionRepository.delete(publicacion);
    }


    //convertimos de Entidad a Dto
    private PublicacionDto mapearDto(Publicacion publicacion){
        PublicacionDto publicacionDto = new PublicacionDto();

        PublicacionDto publicacionRespuesta = new PublicacionDto();
        publicacionDto.setId(publicacion.getId());
        publicacionDto.setTitulo(publicacion.getTitulo());
        publicacionDto.setDescripcion(publicacion.getDescripcion());
        publicacionDto.setContenido(publicacion.getContenido());

        return publicacionDto;
    }
    //convertimos de Dto a Entidad
    private Publicacion mapearEntidad(PublicacionDto publicacionDto){
        Publicacion publicacion = new Publicacion();

        publicacion.setTitulo(publicacionDto.getTitulo());
        publicacion.setDescripcion(publicacionDto.getDescripcion());
        publicacion.setContenido(publicacionDto.getContenido());

        return publicacion;
    }
}
