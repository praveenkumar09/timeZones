package com.udacity.timezones.clientInterface;

import java.util.List;

public interface WorldTimeClient {
    public List<String> getValidTimeZones(String area);
}
