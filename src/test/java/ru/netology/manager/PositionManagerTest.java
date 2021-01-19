package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Position;
import ru.netology.repository.PositionRepository;

import static org.junit.jupiter.api.Assertions.*;

class PositionManagerTest {
    int nonexistentID = 6;
    PositionRepository repository = new PositionRepository();
    PositionManager manager = new PositionManager(repository);
    Position firstPosition = new Position(1, 2742, "LED", "MOW", 95);
    Position secondPosition = new Position(2, 1799, "LED", "MOW", 90);
    Position thirdPosition = new Position(3, 2099, "LED", "MOW", 80);
    Position fourthPosition = new Position(4, 2468, "MOW", "LED", 100);
    Position fifthPosition = new Position(5, 7307, "LED", "MUC", 435);

    @BeforeEach
    void setUp() {
        manager.add(firstPosition);
        manager.add(secondPosition);
        manager.add(thirdPosition);
        manager.add(fourthPosition);
        manager.add(fifthPosition);
    }

    @Test
    public void shouldFindAndSort() {
        Position[] expected = new Position[]{secondPosition, thirdPosition, firstPosition};
        Position[] actual = manager.searchByAirports("LED", "MOW");
        assertArrayEquals(expected, actual);
    }

    /* TODO Тесты для покрытия */

    @Test
    public void shouldFindByID() {
        Position actual = manager.findByID(5);
        assertEquals(fifthPosition, actual);
    }

    @Test
    public void shouldNotFindByID() {
        assertNull(manager.findByID(nonexistentID));
    }

    @Test
    public void shouldRemoveByID() {
        manager.removeByID(3);
        Position[] expected = new Position[]{firstPosition, secondPosition, fourthPosition, fifthPosition};
        Position[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByID() {
        manager.removeByID(nonexistentID);
        Position[] expected = new Position[]{firstPosition, secondPosition, thirdPosition, fourthPosition, fifthPosition};
        Position[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}