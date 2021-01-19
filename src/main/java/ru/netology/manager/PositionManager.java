package ru.netology.manager;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Position;
import ru.netology.repository.PositionRepository;

import java.util.Arrays;

public class PositionManager {
    PositionRepository repository;

    public PositionManager(PositionRepository repository) {
        this.repository = repository;
    }

    public void add(Position item) {
        repository.save(item);
    }

    public Position[] searchByAirports(String from, String to) {
        Position[] result = new Position[0];
        for (Position item : repository.findAll()) {
            if (item.matches(from, to)) {
                Position[] tmp = new Position[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
            Arrays.sort(result);
        }
        return result;
    }

    public Position[] getAll() {
        return repository.findAll();
    }

    public Position findByID(int id) {
        return repository.findByID(id);
    }

    public void removeByID(int id) {
        try {
            repository.removeByID(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}