package com.example.mex1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Disabled("Disabled for GitHub Actions since no DB is configured")
class Mex1ApplicationTests {

	@Test
	void contextLoads() {
	}

}
