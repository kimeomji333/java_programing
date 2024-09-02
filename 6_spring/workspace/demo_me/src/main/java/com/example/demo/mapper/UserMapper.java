package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.UserDTO;

@Mapper
public interface UserMapper {
	int insertUser(UserDTO dto);
	int updateUser(UserDTO dto);
	int deleteUser(String userid);
	UserDTO getUserByUserid(String userid);
}
