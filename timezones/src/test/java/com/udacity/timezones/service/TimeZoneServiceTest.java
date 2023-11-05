package com.udacity.timezones.service;

import com.udacity.timezones.client.FakeWorldTimeApiHttpClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeZoneServiceTest {

    @Test
    void getAvailableTimezoneText() {
        List<String> validTimeZones = List.of("Bangalore","Chennai","Delhi","Hyderabad","Mumbai");
        FakeWorldTimeApiHttpClient fakeWorldTimeApiHttpClient = new FakeWorldTimeApiHttpClient(validTimeZones);
        TimeZoneService timeZoneService = new TimeZoneService(fakeWorldTimeApiHttpClient);
        String result = timeZoneService.getAvailableTimezoneText("India");
        System.out.println("Realm Result ====>"+result);
        String expectedResult = String.join(", ",validTimeZones);
        System.out.println("Expected Result ===>"+expectedResult);
        assertTrue(result.contains(expectedResult));
    }
}