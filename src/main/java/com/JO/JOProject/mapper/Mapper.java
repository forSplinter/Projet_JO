package com.JO.JOProject.mapper;

import com.JO.JOProject.domain.entity.AthleteEntity;

public interface Mapper<A,B> {
    B mapTo(A a);
    A mapFrom(B b);
    
}
