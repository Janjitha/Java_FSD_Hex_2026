package com.cms.controller;

import com.cms.dto.IncidentDto;
import com.cms.dto.IncidentOfficerDto;
import com.cms.dto.IncidentRespDto;
import com.cms.dto.OfficerIncidentStatRespDto;
import com.cms.enums.IncidentType;
import com.cms.exception.ResourceNotFoundException;
import com.cms.model.Incident;
import com.cms.service.IncidentService;
import jakarta.validation.Valid;
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
@RequestMapping("/api/incident")
public class IncidentController {

    private final IncidentService incidentService;

//    @GetMapping("/api/incident/all")
//    public List<Incident> getAll(){
//        return incidentService.getAll();
//}
@GetMapping("/all")
public List<Incident> getAll( ){
    return incidentService.getAll( );
}

//    @GetMapping("/api/incident/all/v2")
@GetMapping("/all/v2")
    public IncidentRespDto getAllV2(@RequestParam int page,
                                    @RequestParam int size){
        return incidentService.getAllWithPagination( page,size);
    }

//    @PostMapping("/api/incident/add")
    @PostMapping("/add")
    public void addIncident(@Valid @RequestBody IncidentDto dto){
        incidentService.addIncident(dto);
    }
//    public void addIncident(@RequestBody Incident incident){
//        incidentService.addIncident(incident);
//    }

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

//    @PostMapping("/api/incident/add/v2/{officerId}")
    @PostMapping("/add/v2/{officerId}")
    public void addIncidentWithOfficer(@Valid @RequestBody IncidentDto dto,
                                       @PathVariable int officerId){
        incidentService.addIncidentWithOfficer(dto,officerId);
    }

//    @GetMapping("/api/incident/get-one/{id}")
    @GetMapping("/get-one/{id}")
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

//    @DeleteMapping("/api/incident/delete/{id}")
    @DeleteMapping("/delete/{id}")
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

//    @PutMapping("/api/incident/update/{id}")
    @PutMapping("/update/{id}")
    public void update(@PathVariable int id,
                       @RequestBody Incident updatedIncident){
        incidentService.update(id, updatedIncident);
    }
//    @GetMapping("/api/incident/type")
    @GetMapping("/type")
    public List<Incident> getByIncidentType(@RequestParam IncidentType incidentType){
        return incidentService.getByIncidentType(incidentType);
    }
    @GetMapping("/get/officer/{officerId}")
    public List<IncidentOfficerDto> getIncidentByOfficerId(@PathVariable int officerId){
        return incidentService.getIncidentByOfficerId(officerId);
    }
    @GetMapping("/get/officer")
    public List<IncidentOfficerDto> getIncidentByOfficerUsername(@RequestParam String officerUsername){
        return incidentService.getIncidentByOfficerUsername(officerUsername);
    }

    @GetMapping("/stat/by-type")
    public OfficerIncidentStatRespDto getIncidentStatByType(){
        return incidentService.getIncidentStatByType();
    }
}

