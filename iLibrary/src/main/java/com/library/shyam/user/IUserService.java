package com.library.shyam.user;

import java.util.List;

public interface IUserService {

	User add(User user);

	List<UserRecord> getAlluser();

	void delete(String email);

	User getUser(String email);

	User update(User user);
}
