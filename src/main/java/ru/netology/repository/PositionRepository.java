package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Position;

public class PositionRepository {
    Position[] positions = new Position[0];

    public void save(Position item) {
        int length = positions.length + 1;
        Position[] tmp = new Position[length];
        System.arraycopy(positions, 0, tmp, 0, positions.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        positions = tmp;
    }

    public Position[] findAll() {
        return positions;
    }

    public Position findByID(int id) {
        for (Position item : positions) {
            if (item.id() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeByID(int id) throws NotFoundException {
        if (findByID(id) != null) {
            int length = positions.length - 1;
            Position[] tmp = new Position[length];
            int index = 0;
            for (Position item : positions) {
                if (item.id() != id) {
                    tmp[index] = item;
                    index++;
                }
                positions = tmp;
            }
        } else {
            throw new NotFoundException("Element with ID " + id + " not found");
        }
    }
}