package app;

import app.auth.abstracts.AuthService;
import app.auth.abstracts.VerifyService;
import app.auth.concretes.EmailVerifier;
import app.auth.concretes.GoogleAuth;
import app.business.service.UserService;
import app.business.serviceImpl.UserManager;
import app.dao.abstracts.UserDao;
import app.dao.concretes.UserDaoImpl;
import app.entities.User;

public class App {

	public static void main(String[] args) {

		User user1 = new User("Taha", "Y�ld�r�m", "info@yildirim.com", "1234556");

		AuthService authService = new GoogleAuth();

		UserDao userDao = new UserDaoImpl();
		
		VerifyService verifyService = new EmailVerifier(); 
		
		UserService userService = new UserManager(userDao, authService, verifyService); //kullan�c� i�lemleri
		
		userService.register(user1);

		userService.login("info@yildirim.com","123456");
		
		System.err.println("Hata Senaryolar�");
		
		System.out.println("-------Hatal� Email Format�------");
		User user2 = new User("Halit", "Beyaz", "infobeyaz.com", "456789");
		userService.register(user2);
		
		System.out.println("-------Hatal� isim------");
		User user3 = new User("A", "Kaplan", "ali@kaplan.com", "5623231");
		userService.register(user3);
		
		System.out.println("-------Email Ba�kas� Taraf�ndan Kullan�l�yorsa------");
		User user4 = new User("Hasan", "Metin", "info@yildirim.com", "5132548");
		userService.register(user4);
		
		System.out.println("\n--Sisteme Kay�tl� Kullan�c�lar--");
		for(User user : userService.getUsers()) {
			System.out.println(user.getFirstName() + " " + user.getLastName());
		}
		
	}

}
