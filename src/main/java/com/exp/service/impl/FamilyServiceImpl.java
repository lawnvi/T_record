package com.exp.service.impl;

import com.exp.mapper.FamilyMapper;
import com.exp.model.pojo.Family;
import com.exp.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    FamilyMapper familyMapper;

    @Override
    public int addFamily(Family family) {
        return familyMapper.addFamily(family);
    }

    @Override
    public Family findFamilyById(int id) {
        Family family = familyMapper.findFamilyById(id);
        return family;
    }
}
