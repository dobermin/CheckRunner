package ru.mail.dobermin.service;

import ru.mail.dobermin.utils.Utils;

public class CheckDecorator implements Check {
    private final Check check;
    private final CheckDecorator checkDecorator;

    public CheckDecorator(CheckDecorator checkDecorator, Check check) {
        this.check = check;
        this.checkDecorator = checkDecorator;
    }

    public CheckDecorator() {
        this.check = null;
        this.checkDecorator = null;
    }

    @Override
    public double getTotal() {
        try {
            return Utils.format(checkDecorator.getTotal() + check.getTotal());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public double getDiscount() {
        try {
            return Utils.format(checkDecorator.getDiscount() + check.getDiscount());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String output() {
        try {
            return checkDecorator.output() + check.output();
        } catch (Exception e) {
            return "";
        }
    }
}
