package com.demo.demo.Service;

import com.demo.demo.Dto.PublicacionDto;

import java.util.List;

public interface PublicacionService {

    public PublicacionDto crearPublicacion(PublicacionDto publicacionDto);

    public List<PublicacionDto> obtenerTodasLasPublicaciones ();

    public PublicacionDto obtenerPublicacioPorId(long id);

    public PublicacionDto actualizarPublicacion(PublicacionDto publicacionDto, long id);

    public void eliminarPublicacion (long id);
}
