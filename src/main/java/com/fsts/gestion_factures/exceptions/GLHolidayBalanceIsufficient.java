package com.fsts.gestion_factures.exceptions;

public class GLHolidayBalanceIsufficient extends Throwable {
    public GLHolidayBalanceIsufficient(String holidayBalanceInsufficient) {
        super(holidayBalanceInsufficient);
    }
}
