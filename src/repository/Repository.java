package src.repository;

import src.exception.DuplicateIdException;
import src.exception.NotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T> {
    protected List<T> items;

    public Repository() {
        this.items = new ArrayList<>();
    }

    public abstract String getId(T item);

    public void add(T item) throws DuplicateIdException {
        String id = getId(item);
        for (T existingItem : items) {
            if (getId(existingItem).equals(id)) {
                throw new DuplicateIdException("ID đã tồn tại: " + id);
            }
        }
        items.add(item);
    }

    public void update(T item) throws NotFoundException {
        String id = getId(item);
        for (int i = 0; i < items.size(); i++) {
            if (getId(items.get(i)).equals(id)) {
                items.set(i, item);
                return;
            }
        }
        throw new NotFoundException("Không tìm thấy item với ID: " + id);
    }

    public void delete(String id) throws NotFoundException {
        for (int i = 0; i < items.size(); i++) {
            if (getId(items.get(i)).equals(id)) {
                items.remove(i);
                return;
            }
        }
        throw new NotFoundException("Không tìm thấy item với ID: " + id);
    }

    public List<T> findAll() {
        return new ArrayList<>(items);
    }

    public T findById(String id) throws NotFoundException {
        for (T item : items) {
            if (getId(item).equals(id)) {
                return item;
            }
        }
        throw new NotFoundException("Không tìm thấy item với ID: " + id);
    }
}
