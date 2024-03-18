package com.pruebaMarshall.marshall.Servicio.Validaciones;

import java.util.LinkedHashMap;
import java.util.List;

public interface MapaAgregar {
    List<LinkedHashMap<String, Object>> agregarMapa(List<String> lista, List<String> listaDos);
    List<LinkedHashMap<String, Object>> agregarMapa(List<String>lista, List<String> listaDos, List<String> listaTres);
}
