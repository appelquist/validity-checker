package com.company;

import java.util.List;

public interface IValidityCheck {
    public boolean check(String personnummer);
    public String getValidityCheckMessage();
}
