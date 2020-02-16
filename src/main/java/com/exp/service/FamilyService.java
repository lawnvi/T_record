package com.exp.service;

import com.exp.model.pojo.Family;
import com.exp.model.pojo.TLog;

import java.util.List;

public interface FamilyService {
    int addFamily(Family family);

    Family findFamilyById(int id);

    Family loginFamily(Family family);

    Family findFamilyByAccount(String account);
}
