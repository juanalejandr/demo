package com.demo.demo.Exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String nombredelRecurso;
    private String nombredelCampo;
    private long valorDelCammpo;

    public ResourceNotFoundException(String nombredelRecurso, String nombredelCampo, long valorDelCammpo) {
        super(String.format("%s No encontrado: %S : '%S' ", nombredelCampo,nombredelRecurso, valorDelCammpo));
        this.nombredelRecurso = nombredelRecurso;
        this.nombredelCampo = nombredelCampo;
        this.valorDelCammpo = valorDelCammpo;
    }
}
