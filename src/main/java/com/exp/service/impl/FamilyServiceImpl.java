package com.exp.service.impl;

import com.exp.mapper.FamilyMapper;
import com.exp.model.pojo.Family;
import com.exp.model.pojo.TLog;
import com.exp.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return familyMapper.findFamilyById(id);
    }

    @Override
    public Family loginFamily(Family family) {
        return familyMapper.loginFamily(family);
    }

    @Override
    public Family findFamilyByAccount(String account) {
        return familyMapper.findFamilyByAccount(account);
    }

}
