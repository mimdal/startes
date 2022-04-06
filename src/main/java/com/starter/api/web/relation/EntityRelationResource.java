package com.starter.api.web.relation;

import com.starter.service.relation.EntityRelationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relations")
public class EntityRelationResource {

    private EntityRelationService service;

    public EntityRelationResource(EntityRelationService service) {
        this.service = service;
    }

    @GetMapping("/persist-entities")
    public ResponseEntity<String> persist() {
        return ResponseEntity.ok(service.persist());
    }

}
