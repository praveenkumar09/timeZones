package com.udacity.timezones.service;

import com.udacity.timezones.client.FakeWorldTimeApiHttpClient;
import com.udacity.timezones.client.WorldTimeApiHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TimeZoneServiceTest {

    private TimeZoneService timeZoneService;

    @Mock
    WorldTimeApiHttpClient worldTimeApiHttpClient;

    @BeforeEach
    void init(){
        timeZoneService = new TimeZoneService(worldTimeApiHttpClient);
    }

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

    @Test
    void getAvailbleTimeZoneTest_withMockito(){
        List<String> validTimeZones = List.of("Bangalore","Chennai","Delhi","Hyderabad","Mumbai");
        when(worldTimeApiHttpClient.getValidTimeZones(anyString())).thenReturn(validTimeZones);
        String result = timeZoneService.getAvailableTimezoneText("India");
        assertTrue(result.contains(String.join(", ",validTimeZones)));
    }

}