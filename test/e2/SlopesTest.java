package e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertThrows;

class SlopesTest {
    char[][] map = {
            {'.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.'},
            {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
            {'.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
            {'.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'},
            {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
            {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'},
            {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
            {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.'},
            {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#'},
            {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#'}
    };

    char[][] miniMap = {
            {'.', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.'},
            {'#', '#', '.', '.', '#'},
            {'#', '#', '.', '.', '.'},
            {'.', '#', '.', '#', '.'}
    };

    char[][] nonSquareMap1 = {
            {'.'},
            {'#', '.'},
            {'.', '#', '.'}
    };
    char[][] nonSquareMap2 = {
            {'.', '#', '.'},
            {'.', '#'},
            {'#', '.'}
    };
    char[][] invalidCharacter = {
            {'.', '.', '.'},
            {'#', '#', '.'},
            {'.', '#', 'a'}
    };
    char[][] rectangularMap = {
            {'.', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.'},
            {'.', '#', '.', '#', '.'}
    };

    @Test
    public void downTheSlope() {
        assertEquals( 5, DescPend.downTheSlope(map,  1,  1));
        assertEquals(17, DescPend.downTheSlope(map,  3,  1));
        assertEquals(18, DescPend.downTheSlope(map,  5,  1));
        assertEquals(30, DescPend.downTheSlope(map,  7,  1));
        assertEquals( 4, DescPend.downTheSlope(map,  1,  2));
        assertEquals(10, DescPend.downTheSlope(map, 10, 10));

        assertEquals( 0, DescPend.downTheSlope(miniMap,  1,  1));
        assertEquals( 7, DescPend.downTheSlope(miniMap,  3,  2));
        assertEquals( 6, DescPend.downTheSlope(miniMap,  4,  3));

        assertThrows(IllegalArgumentException.class, () -> DescPend.downTheSlope(nonSquareMap1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.downTheSlope(nonSquareMap2, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.downTheSlope(invalidCharacter, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.downTheSlope(rectangularMap, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.downTheSlope(map, 11, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.downTheSlope(map, 1, 11));
        assertThrows(IllegalArgumentException.class, () -> DescPend.downTheSlope(map, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.downTheSlope(map, 1, 0));
    }

    @Test
    void jumpTheSlope() {
        assertEquals(2, DescPend.jumpTheSlope(map, 1, 1));
        assertEquals(7, DescPend.jumpTheSlope(map, 3, 1));
        assertEquals(3, DescPend.jumpTheSlope(map, 5, 1));
        assertEquals(4, DescPend.jumpTheSlope(map, 7, 1));
        assertEquals(2, DescPend.jumpTheSlope(map, 1, 2));
        assertEquals(1, DescPend.jumpTheSlope(map, 10, 10));

        assertEquals( 0, DescPend.jumpTheSlope(miniMap,  1,  1));
        assertEquals( 1, DescPend.jumpTheSlope(miniMap,  3,  2));
        assertEquals( 0, DescPend.jumpTheSlope(miniMap,  4,  3));

        assertThrows(IllegalArgumentException.class, () -> DescPend.jumpTheSlope(nonSquareMap1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.jumpTheSlope(nonSquareMap2, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.jumpTheSlope(invalidCharacter, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.jumpTheSlope(map, 11, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.jumpTheSlope(map, 1, 11));
        assertThrows(IllegalArgumentException.class, () -> DescPend.jumpTheSlope(map, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> DescPend.jumpTheSlope(map, 1, 0));
    }
}