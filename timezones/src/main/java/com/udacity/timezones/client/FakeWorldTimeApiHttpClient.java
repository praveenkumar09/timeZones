package com.udacity.timezones.client;

import com.udacity.timezones.clientInterface.WorldTimeClient;

import java.util.List;

public class FakeWorldTimeApiHttpClient implements WorldTimeClient {

    private final List<String> validTimeZones;

    public FakeWorldTimeApiHttpClient(List<String> validTimeZones) {
        this.validTimeZones = validTimeZones;
    }

    @Override
    public List<String> getValidTimeZones(String area) {
        return validTimeZones;
    }
}
