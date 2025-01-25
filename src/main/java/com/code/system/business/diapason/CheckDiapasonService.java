package com.code.system.business.diapason;

import java.util.List;

public class CheckDiapasonService {

    public boolean checkFreeDiapason(Diapason dC, List<Diapason> bookedDiapasons) {
        for(Diapason d : bookedDiapasons) {
            //                 до                                  после
            if(!d.getStart().isBefore(dC.getStart()) && !d.getEnd().isAfter(dC.getEnd())) {
                System.out.println("Транспорт свободен");
                return true;
            } else if (dC.getEnd().isAfter(d.getStart()) && dC.getEnd().isBefore(d.getEnd())) {
                System.out.println("На часть из дат транспорт уже забронирован");
                return false;
            } else if (dC.getStart().isBefore(d.getEnd()) && d.getStart().isBefore(dC.getStart())) {
                System.out.println("На часть из дат транспорт уже забронирован 2");
                return false;
            }
        }
        return true;
    }
}
