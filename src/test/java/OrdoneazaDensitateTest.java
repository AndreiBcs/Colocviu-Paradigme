import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Test
public void testDensitate(){
    long nrLoc = 212131;
    long suprafata = 0;
    double densitate = (double) nrLoc / suprafata;

    assertThrows(ArithmeticException.class, ()->densitate.div(10,0));
}

void main() {
}