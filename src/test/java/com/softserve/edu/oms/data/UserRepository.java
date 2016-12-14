package com.softserve.edu.oms.data;

import java.util.List;

public final class UserRepository {

	private static volatile UserRepository instance = null;

	private UserRepository() {
	}

	public static UserRepository get() {
		if (instance == null) {
			synchronized (UserRepository.class) {
				if (instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}
	
//	public IUser adminUser() {
//		return new User("iva", "ivanka", "horoshko", "qwerty",
//				"mail@gmail.com", "West", "Administrator");
//	}
	
	public IUser adminUser() {
        return new User("noneiva", "noneivanka", "nonehoroshko", "qwerty",
                "mail@gmail.com", "West", "Administrator");
    }
    

	public IUser customerUser() {
		return new User("login1", "firstName1", "lastName1", "qwerty",
				"mail@gmail.com", "East", "Customer");
	}

	public IUser invalidUser() {
		return new User("abcdqwd", "abcd123", "abcd123", "abcd1",
				"abcd@gmail.com", "East", "Administrator");
	}

	public IUser badMemoryUser() {
		return new User("BadMemoryUser", "Neo", "Matrix", "paSSworD",
				"hello@gmail.com", "East", "Supervisor");
	}
	
	public IUser someUser() {
        return new User("roman", "rrd", "rrd", "1234",
                "rdd@g.com", "West", "Administrator");
    }
    
    
    public IUser newUser() {
        return new User("andriy", "rrd", "rrd", "1234",
                "rdd@g.com", "West", "Administrator");
    }

	public List<IUser> getUsersFromCsvFile() {
		return new UserUtils().getAllUsers();
	}

	public List<IUser> getUsersFromExcelFile() {
		return new UserUtils("/users.xlsx", new ExcelUtils()).getAllUsers();
	}

	public List<IUser> getUsersFromDB() {
		return new UserUtils("/", new DBUtils()).getAllUsers();
	}



}