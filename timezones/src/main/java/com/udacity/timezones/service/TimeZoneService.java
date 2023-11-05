package com.udacity.timezones.service;

import com.udacity.timezones.clientInterface.WorldTimeClient;

public class TimeZoneService {
	private final WorldTimeClient worldTimeClient;

	public TimeZoneService(WorldTimeClient worldTimeApiRestClient) {
		this.worldTimeClient = worldTimeApiRestClient;
	}

	public String getAvailableTimezoneText(String area) {
		return String.format(
			"Available timezones in %s are %s.",
			area,
			String.join(", ", worldTimeClient.getValidTimeZones(area))
		);
	}
}
