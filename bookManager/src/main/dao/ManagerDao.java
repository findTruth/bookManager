package main.dao;

import main.entity.Manager;

public interface ManagerDao {
	public Manager findById(String id);
	public Manager findByName(String name);
}
