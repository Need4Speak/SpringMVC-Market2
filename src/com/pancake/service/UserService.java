package com.pancake.service;

import com.pancake.entity.User;

public interface UserService {
	User getByName(String userName);
}
