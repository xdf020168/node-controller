package io.metersphere.api.jmeter.utils;

import lombok.Data;

import java.util.List;

@Data
public class ElementCondition {
    private boolean include;
    private boolean typeVerification;
    private boolean arrayVerification;
    List<Condition> conditions;

    public ElementCondition() {

    }

    public ElementCondition(boolean include, boolean typeVerification, boolean arrayVerification, List<Condition> conditions) {
        this.include = include;
        this.typeVerification = typeVerification;
        this.arrayVerification = arrayVerification;
        this.conditions = conditions;
    }
}