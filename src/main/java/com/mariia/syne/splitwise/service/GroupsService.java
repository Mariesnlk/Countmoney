package com.mariia.syne.splitwise.service;

import com.mariia.syne.splitwise.model.Groups;
import com.mariia.syne.splitwise.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupsService {

    @Autowired
    private GroupsRepository groupsRepository;


    public List<Groups> getAllGroups() {

        List<Groups> groupsList = new ArrayList<>();
        groupsRepository.findAll().forEach(groupsList::add);
        return groupsList;
    }

    public Groups getGroup(Integer id) {
        return groupsRepository.findById(id).orElse(null);
    }

    public void addGroup(Groups group) {

        groupsRepository.save(group);
    }

    public void updateGroup(Groups groups, Integer id) {

        groupsRepository.save(groups);
    }

    public void deleteGroup(Integer id) {
        groupsRepository.deleteById(id);
    }
}
