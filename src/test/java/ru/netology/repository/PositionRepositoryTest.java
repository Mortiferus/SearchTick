package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PositionRepositoryTest {

    @Test
    void shouldCatchException() {
        PositionRepository r = new PositionRepository();
        assertThrows(NotFoundException.class, () -> r.removeByID(6));
    }
}