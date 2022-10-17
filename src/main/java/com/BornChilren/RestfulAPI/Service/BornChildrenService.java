package com.BornChilren.RestfulAPI.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BornChilren.RestfulAPI.Exceptions.ChildNotFoundException;
import com.BornChilren.RestfulAPI.Links.ChildModelAssembler;
import com.BornChilren.RestfulAPI.Model.BornChildren;
import com.BornChilren.RestfulAPI.Repository.BornChildrenRepository;

@Service
public class BornChildrenService {
    
    private final BornChildrenRepository bornChildrenRepository;
    private final ChildModelAssembler childModelAssembler;
    @Autowired
    public BornChildrenService(BornChildrenRepository bornChildrenRepository, ChildModelAssembler childModelAssembler){
        this.bornChildrenRepository = bornChildrenRepository;
        this.childModelAssembler = childModelAssembler;
    }
    

    public ResponseEntity<Map<String, Object>> getAllChildren(Long registrationNumber, int page, int size) {
        try{
            List<BornChildren> children = new ArrayList<>();
            Pageable paging = PageRequest.of(page, size);
            Page<BornChildren> childPage;
            /* taking the assumption that registration number must be > 0 and non-negative */
            
            childPage = bornChildrenRepository.findAll(paging);
            children = childPage.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("data", children);
            response.put("total", childPage.getTotalElements());
            response.put("total_pages", childPage.getTotalPages());
            response.put("page", childPage.getNumber());
            response.put("per_page", childPage.getSize());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> addNewChild(BornChildren bornChildren) {
        EntityModel<BornChildren> entityModel = childModelAssembler.toModel(bornChildrenRepository.save(bornChildren));
        return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
      .body(entityModel);
    }

    public ResponseEntity<?> updateChild(BornChildren bornChildren, Long childId) {
        BornChildren updatedChild = bornChildrenRepository.findById(childId) //
      .map(infant -> {
        infant.setRegistrationNumber(bornChildren.getRegistrationNumber());
        infant.setDateOfBirth(bornChildren.getDateOfBirth());
        infant.setNameOfTheChild(bornChildren.getNameOfTheChild());
        infant.setMothersOccupation(bornChildren.getMothersOccupation());
        infant.setMothersName(bornChildren.getMothersName());
        infant.setMothersAge(bornChildren.getMothersAge());
        infant.setWeight(bornChildren.getWeight());
        infant.setGender(bornChildren.getGender());
        infant.setMaritalStatus(bornChildren.getMaritalStatus());
        infant.setPlaceOfBirth(bornChildren.getPlaceOfBirth());
        return bornChildrenRepository.save(infant);
      }) //
      .orElseGet(() -> {
        bornChildren.setRegistrationNumber(childId);
        return bornChildrenRepository.save(bornChildren);
      });

    EntityModel<BornChildren> entityModel = childModelAssembler.toModel(updatedChild);

    return ResponseEntity //
      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
      .body(entityModel);
    }
    
    public ResponseEntity<List<BornChildren>> getChildByTheirName(String nameOfTheChild) {
        List<BornChildren> nameMatches = bornChildrenRepository.findBynameOfTheChild(nameOfTheChild);
        if(nameMatches.size() > 0){
            return new ResponseEntity<List<BornChildren>>(nameMatches, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    public BornChildren findById(Long id) {
        return bornChildrenRepository.findById(id)
        .orElseThrow(() -> new ChildNotFoundException(id));
    }
}
