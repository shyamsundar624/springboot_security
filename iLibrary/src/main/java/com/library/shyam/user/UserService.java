package com.library.shyam.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.shyam.exception.UserAlreadyExistsException;
import com.library.shyam.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public User add(User user) {
		Optional<User> theUser = userRepository.findByEmail(user.getEmail());
		if (theUser.isPresent()) {
			throw new UserAlreadyExistsException("A User With " + user.getEmail() + " already Exists");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public List<UserRecord> getAlluser() {
		// TODO Auto-generated method stub
		return userRepository.findAll().stream()
				.map(user -> new UserRecord(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail()))
				.collect(Collectors.toList());
	}

	@Override
	public void delete(String email) {
		userRepository.deleteByEmail(email);
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User Not Found"));
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
