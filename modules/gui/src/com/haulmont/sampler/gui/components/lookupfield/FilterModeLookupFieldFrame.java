package com.haulmont.sampler.gui.components.lookupfield;

import com.haulmont.cuba.gui.components.AbstractFrame;
import com.haulmont.cuba.gui.components.LookupField;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FilterModeLookupFieldFrame extends AbstractFrame {
    @Inject
    private LookupField containsFilterLookup;
    @Inject
    private LookupField noFilterLookup;
    @Inject
    private LookupField startsWithFilterLookup;

    @Override
    public void init(Map<String, Object> params) {
        List<String> list = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
        noFilterLookup.setOptionsList(list);
        startsWithFilterLookup.setOptionsList(list);
        containsFilterLookup.setOptionsList(list);
    }
}