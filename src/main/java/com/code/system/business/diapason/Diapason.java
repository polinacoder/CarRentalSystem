package com.code.system.business.diapason;

import java.time.LocalDate;


public class Diapason {
    private LocalDate start;
    private LocalDate end;

    public Diapason(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
