/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.hernan.demo.api;

import cl.hernan.demo.modelo.Tarea;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

//http://localhost:8080/api
public class ApiBasica {
    //http://localhost:8080/api/hola
    @GetMapping("/hola")
    public String hola(){
        return "Hola Spring Boot";
    }
    
    @GetMapping("/holanombre/{nombre}")
    public String hola(@PathVariable String nombre){
        return "Hola " + nombre + " Bienvenido a Spring Boot";
    }
    @GetMapping("/tarea")
    public Tarea tarea(){
        return new Tarea("T-01", "Comprar Pan", "Alta");
    }
    
    @GetMapping("/tareas")
    public List<Tarea> tareas(){
        List<Tarea> tareas = new ArrayList<>(); 
        tareas.add(new Tarea("T-01", "tarea #1", "Alta"));
        tareas.add(new Tarea("T-02", "tarea #2", "Alta"));
        tareas.add(new Tarea("T-03", "tarea #3", "Alta"));
        tareas.add(new Tarea("T-04", "tarea #4", "Alta"));
        
        
        return tareas;
    }
    
    @GetMapping("/tareas/{id}")
    public Tarea tareas(@PathVariable String id){
        List<Tarea> tareas = new ArrayList<>(); 
        tareas.add(new Tarea("T-01", "tarea #1", "Alta"));
        tareas.add(new Tarea("T-02", "tarea #2", "Alta"));
        tareas.add(new Tarea("T-03", "tarea #3", "Alta"));
        tareas.add(new Tarea("T-04", "tarea #4", "Alta"));
        
        for (Tarea tarea : tareas) {
            if (tarea.getId().equals(id)) {
                return tarea;
            }
        }
        
        return null;
    }
    
}
