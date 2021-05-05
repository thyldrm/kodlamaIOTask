package Services;


import Entities.User;

public interface IGamerService {

	void save(User user);
	void update(User user);
	void delete(User user);
}