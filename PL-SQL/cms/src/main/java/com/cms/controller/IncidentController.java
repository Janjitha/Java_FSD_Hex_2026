package com.cms.controller;

import com.cms.exception.ResourceNotFoundException;
import com.cms.model.Incident;
import com.cms.service.IncidentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * In controller if you are creating REST APIs
 * then add
 * @RestController annotation which is a combo of
 * @Controller & @ResponseBody
 * But if you are using this controller to load java UI(jsp or Thymeleaf)
 * then use only @Controller
 * */
@RestController
@AllArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;

    @GetMapping("/api/incident/all")
    public List<Incident> getAll(){
        return incidentService.getAll();
    }

    @PostMapping("/api/incident/add")
    public void addIncident(@RequestBody Incident incident){
        incidentService.addIncident(incident);
    }

//    @GetMapping("/api/incident/get-one/{id}")
//    public ResponseEntity<Object> getById(@PathVariable int id){ //<-- path variable
//        try {
//            Incident incident = incidentService.getById(id);
//            return ResponseEntity
//                    .ok(incident);
//        }
//        catch(ResourceNotFoundException e){
//            // build the response
//            return ResponseEntity
//                    .badRequest()
//                    .body(e.getMessage());
//        }
//    }

    @GetMapping("/api/incident/get-one/{id}")
    public ResponseEntity<Incident> getById(@PathVariable int id){ //<-- path variable
        return ResponseEntity
                .ok(incidentService.getById(id));
    }

//    @DeleteMapping("/api/incident/delete/{id}")
//    public ResponseEntity<Object> deleteById(@PathVariable int id){
//        try {
//            incidentService.deleteById(id);
//            return ResponseEntity.ok().build();
//        }
//        catch(ResourceNotFoundException e){
//            return ResponseEntity
//                    .badRequest()
//                    .body(e.getMessage());
//        }
//    }

    @DeleteMapping("/api/incident/delete/{id}")
    public void deleteById(@PathVariable int id){
        incidentService.deleteById(id);
    }


//    @PutMapping("/api/incident/update/{id}")
//    public ResponseEntity<Object> update(@PathVariable int id,
//                                         @RequestBody Incident updatedIncident){
//        try {
//            incidentService.update(id, updatedIncident);
//            return ResponseEntity
//                    .ok()
//                    .build();
//
//        }
//        catch(ResourceNotFoundException e){
//            return ResponseEntity
//                    .badRequest()
//                    .body(e.getMessage());
//        }
//    }

    @PutMapping("/api/incident/update/{id}")
    public void update(@PathVariable int id,
                       @RequestBody Incident updatedIncident){
        incidentService.update(id, updatedIncident);
    }
}

