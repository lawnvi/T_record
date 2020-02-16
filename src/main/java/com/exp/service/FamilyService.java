package com.exp.service;

import com.exp.model.pojo.Family;

public interface FamilyService {
    int addFamily(Family family);

    Family findFamilyById(int id);
}
