package main.biz;

import main.entity.Manager;

public interface ManagerBiz {
	public Manager findByName(String name);
	public Manager findById(String id);
}
