package main.java.Restaurant_Ordering_System.service;

import java.util.List;
import java.util.stream.Collectors;

import main.java.Restaurant_Ordering_System.dao.MenuDAO;
import main.java.Restaurant_Ordering_System.model.MenuItem;

public class Restaurant {

    private final MenuDAO menuDao = ServiceFactory.getMenuDAO();

    public List<MenuItem> getMenu() {
        return menuDao.findAll();
    }

    public MenuItem getItemById(int id) {
        return menuDao.findById(id).orElse(null);
    }

    public List<MenuItem> getMenuByCategory(String category) {
        return getMenu().stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }
}
