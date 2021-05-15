package com.mariia.syne.splitwise.controller.rest;

import com.mariia.syne.splitwise.model.Groups;
import com.mariia.syne.splitwise.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("groups")
public class GroupsRestController {
            /*
    GET     /groups
    GET     /groups/1
    POST    /groups
    PUT     /groups/1
    DELETE  /groups/1
    */

    @Autowired
    private GroupsService groupsService;

    @GetMapping
    public List<Groups> getAllGroups() {

        return groupsService.getAllGroups();
    }

    @GetMapping("/{id}")
    public Groups getGroup(@PathVariable Integer id) {

        return groupsService.getGroup(id);
    }

    @PostMapping
    public void addGroup(@RequestBody Groups groups) {

        groupsService.addGroup(groups);
    }

    @PutMapping("/{id}")
    public void updateGroup(@RequestBody Groups group, @PathVariable Integer id) {

        groupsService.updateGroup(group, id);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Integer id) {

        groupsService.deleteGroup(id);
    }
}
