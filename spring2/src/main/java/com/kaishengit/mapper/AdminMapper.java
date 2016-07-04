package com.kaishengit.mapper;

import com.kaishengit.pojo.Admin;

public interface AdminMapper {
    Admin findByName(String name);
}
