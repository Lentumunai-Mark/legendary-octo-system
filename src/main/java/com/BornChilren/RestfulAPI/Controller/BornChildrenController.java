package com.BornChilren.RestfulAPI.Controller;

import java.util.List;
import java.util.Map;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.BornChilren.RestfulAPI.Model.BornChildren;
import com.BornChilren.RestfulAPI.Service.BornChildrenService;

@RestController
@RequestMapping(path = "api/v1/BornChildren")
public class BornChildrenController {
    BornChildrenService bornChildrenService;
    public BornChildrenController(BornChildrenService bornChildrenService){
        this.bornChildrenService = bornChildrenService;
    }
    @GetMapping("/allchildren")
    public ResponseEntity<Map<String, Object>> getAllChildren(
        @RequestParam(required = false) Long registrationNumber,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "3") int size
    ){
        return bornChildrenService.getAllChildren(registrationNumber, page, size);
    }
    
    @GetMapping(path = "/search")
    public ResponseEntity<List<BornChildren>> getChildByName(@RequestParam String name){
        return bornChildrenService.getChildByTheirName(name);
    }
    @GetMapping("/newbornchildren/{id}")
    public BornChildren one(@PathVariable Long id) {
    return bornChildrenService.findById(id);
  }
    @PostMapping(path = "/addchild")
    public ResponseEntity<?> registerNewBornChild(@RequestBody BornChildren bornChildren){
        return bornChildrenService.addNewChild(bornChildren);
    }

    @PutMapping(path = "/editchild/{childId}")
    public ResponseEntity<?> updateChildDetails(@RequestBody BornChildren bornChildren, @PathVariable Long childId){
        return bornChildrenService.updateChild(bornChildren, childId);
    }
}
