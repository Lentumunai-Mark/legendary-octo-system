package com.BornChilren.RestfulAPI.Links;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.BornChilren.RestfulAPI.Controller.BornChildrenController;
import com.BornChilren.RestfulAPI.Model.BornChildren;
@Component
public class ChildModelAssembler implements RepresentationModelAssembler<BornChildren, EntityModel<BornChildren>>{
    @Override
    public EntityModel<BornChildren> toModel(BornChildren newBorn){
        return EntityModel.of(newBorn, //
        linkTo(methodOn(BornChildrenController.class).one(newBorn.getRegistrationNumber())).withSelfRel());
        
    }
}
