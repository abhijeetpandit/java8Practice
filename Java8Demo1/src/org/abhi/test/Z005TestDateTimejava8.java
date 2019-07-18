package org.abhi.test;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Z005TestDateTimejava8 {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		System.out.println(offsetDateTime.toString()); // 2013-05-15T10:10:37.257+05:30

		offsetDateTime = OffsetDateTime.now(ZoneId.of("+05:30"));
		System.out.println(offsetDateTime.toString()); // 2013-05-15T10:10:37.258+05:30

		offsetDateTime = OffsetDateTime.now(ZoneId.of("-06:30"));
		System.out.println(offsetDateTime.toString()); // 2013-05-14T22:10:37.258-06:30

		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(zonedDateTime.toString()); // 2013-05-15T06:45:45.290+02:00[Europe/Paris]
		
		System.out.println("-----------------------------------");
		
		Instant instant = Instant.now();
		System.out.println(instant.toString());                                 //2013-05-15T05:20:08.145Z
		System.out.println(instant.plus(Duration.ofMillis(5000)).toString());   //2013-05-15T05:20:13.145Z
		System.out.println(instant.minus(Duration.ofMillis(5000)).toString());  //2013-05-15T05:20:03.145Z
		System.out.println(instant.minusSeconds(10).toString());                //2013-05-15T05:19:58.145Z
	
		
		System.out.println("-----------------------------------");
		Duration duration = Duration.ofMillis(5000);
		System.out.println(duration.toString());     //PT5S
		 
		duration = Duration.ofSeconds(60);
		System.out.println(duration.toString());     //PT1M
		 
		duration = Duration.ofMinutes(10);
		System.out.println(duration.toString());     //PT10M
		 
		duration = Duration.ofHours(2);
		System.out.println(duration.toString());     //PT2H
		 
		duration = Duration.between(Instant.now(), Instant.now().plus(Duration.ofMinutes(10)));
		System.out.println(duration.toString());  //PT10M
	}
}
