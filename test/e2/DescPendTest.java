package e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DescPendTest {

    private final char[][] matriz = {
            {'.','.','#','#','.','.','.','.','.','.','.'},
            {'#','.','.','.','#','.','.','.','#','.','.'},
            {'.','#','.','.','.','.','#','.','.','#','.'},
            {'.','.','#','.','#','.','.','.','#','.','#'},
            {'.','#','.','.','.','#','#','.','.','#','.'},
            {'.','.','#','.','#','#','.','.','.','.','.'},
            {'.','#','.','#','.','#','.','.','.','.','#'},
            {'.','#','.','.','.','.','.','.','.','.','#'},
            {'#','.','#','#','.','.','.','#','.','.','.'},
            {'#','.','.','.','#','#','.','.','.','.','#'},
            {'.','#','.','.','#','.','.','.','#','.','#'}
    };

    @Test
    public void testDownTheSlope_basic() {
        int result = DescPend.downTheSlope(matriz, 1, 1);
        assertEquals(5, result, "downTheSlope con right=1, down=1 debe contar 5 árboles");
    }

    @Test
    public void testJumpTheSlope_basic() {
        int result = DescPend.jumpTheSlope(matriz, 3, 1);
        assertEquals(7, result, "jumpTheSlope con right=3, down=1 debe contar 7 árboles");
    }

    @Test
    public void testDownTheSlope_differentStep() {
        int result = DescPend.downTheSlope(matriz, 1, 2);
        assertEquals(10, result, "downTheSlope con right=1, down=2 debe contar 10 árboles");
    }

    @Test
    public void testJumpTheSlope_differentStep() {
        int result = DescPend.jumpTheSlope(matriz, 1, 2);
        assertEquals(5, result, "jumpTheSlope con right=1, down=2 debe contar 5 árboles");
    }

    @Test
    public void testInvalidMatrix() {
        char[][] badMatrix = {
                {'.', '#'},
                {'#', 'x'} // carácter inválido
        };
        assertThrows(IllegalArgumentException.class, () -> {
            DescPend.downTheSlope(badMatrix, 1, 1);
        });
    }

    @Test
    public void testInvalidStep() {
        assertThrows(IllegalArgumentException.class, () -> {
            DescPend.downTheSlope(matriz, 11, 1); // right >= número de columnas
        });

        assertThrows(IllegalArgumentException.class, () -> {
            DescPend.jumpTheSlope(matriz, 3, 11); // down >= número de filas
        });
    }
}

