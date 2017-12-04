package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PeopleControllerTest {
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void shouldReturnMaleProfiles(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?gender=male", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(13);
	}
	
	@Test
	public void shouldReturnFemaleProfiles(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?gender=female", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(22);
	}
	
	@Test
	public void shouldReturnProfilesWithPicture(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?hasPicture=true", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(31);
	}

	@Test
	public void shouldReturnProfilesWithoutPicture(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?hasPicture=false", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(4);
	}
	
	@Test
	public void shouldReturnFemaleProfilesWithoutPicture(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?gender=female&hasPicture=false", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(4);
	}
	
	@Test
	public void shouldReturnFemaleProfilesWithPicture(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?gender=female&hasPicture=true", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(18);
	}
	
	@Test
	public void shouldReturnAllProfiles(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(35);
	}
	
	@Test
	public void shouldReturnProfilesOlderThan30(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?age=30", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(16);
	}
	
	@Test
	public void shouldReturnInactiveProfiles(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?active=false", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(16);
	}
	
	@Test
	public void shouldReturnActiveProfiles(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?active=true", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(19);
	}
	
	@Test
	public void shouldReturnProfilesWithBrownEyes(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?eyeColor=brown", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(13);
	}
	
	@Test
	public void shouldReturnSingleProfilesWithMatchingComboAll(){
		ResponseEntity<PagedResult> response = testRestTemplate.getForEntity("/api/people?active=true&gender=female&hasPicture=true&eyeColor=brown&age=29", PagedResult.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getTotalElements()).isEqualTo(1);
	}
}
