package id.ac.ui.cs.advprog.eshop.service;

public interface UpdateService<T> {
    void update(String entityId, T entity);
}