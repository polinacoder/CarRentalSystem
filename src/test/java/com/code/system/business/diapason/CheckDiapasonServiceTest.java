package com.code.system.business.diapason;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckDiapasonServiceTest {

    private final CheckDiapasonService checkDiapasonService = new CheckDiapasonService();

    @Test
    @DisplayName("Диапозон с 8 по 10 не пересекается и не входит в другие диапазоны")
    void checkFreeDiapason_diapasonFree() {
        //given
        Diapason diapason = new Diapason(LocalDate.of(2025, 1, 8), LocalDate.of(2025, 1, 10));

        //when
        boolean result = checkDiapasonService.checkFreeDiapason(diapason, bookedDiapasons());

        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("Диапозон с 11 по 16 пересекается с диапозоном с 15 по 20")
    void checkFreeDiapason_diapasonBooked() {
        //given
        Diapason diapason = new Diapason(LocalDate.of(2025, 1, 11), LocalDate.of(2025, 1, 16));

        //when
        boolean result = checkDiapasonService.checkFreeDiapason(diapason, bookedDiapasons());

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("Диапозон с 3 по 6 пересекается с диапозоном с 1 по 5")
    void checkFreeDiapason_diapasonBooked_2() {
        //given
        Diapason diapason = new Diapason(LocalDate.of(2025, 1, 3), LocalDate.of(2025, 1, 6));

        //when
        boolean result = checkDiapasonService.checkFreeDiapason(diapason, bookedDiapasons());

        //then
        assertFalse(result);
    }

    @Test
    @DisplayName("Диапозон с 16 по 17 входит в диапозон с 15 по 20")
    void checkFreeDiapason_diapasonBooked_3() {
        //given
        Diapason diapason = new Diapason(LocalDate.of(2025, 1, 16), LocalDate.of(2025, 1, 17));

        //when
        boolean result = checkDiapasonService.checkFreeDiapason(diapason, bookedDiapasons());

        //then
        assertFalse(result);
    }

    public List<Diapason> bookedDiapasons() {
        List<Diapason> bookedDiapasons = new ArrayList<>();
        bookedDiapasons.add(new Diapason(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5)));
        bookedDiapasons.add(new Diapason(LocalDate.of(2025, 1, 6), LocalDate.of(2025, 1, 7)));
        bookedDiapasons.add(new Diapason(LocalDate.of(2025, 1, 15), LocalDate.of(2025, 1, 20)));
        return bookedDiapasons;
    }
}