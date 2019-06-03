package com.springboot.musicdb.service;



import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.musicdb.entity.Artist;
import com.springboot.musicdb.repository.ArtistRepository;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest

public class ArtistServiceTest {

	@Autowired
	private ArtistService artistService;

	@MockBean
	private ArtistRepository artistRepository;

	@Test
	public void getAllArtistsTest() {
		List<Artist> artists = new ArrayList();
		Artist artist = new Artist();
		artist.setId(Long.valueOf(1));
		artist.setName("Time");
		artists.add(artist);
		
		Mockito.when(artistRepository.findAll()).thenReturn(artists);
		//assertThat(artistService.getAllArtists()).iseq
		
		//artistService.getAllArtists();
		//assertEquals(1, resultList.size());
	}

	
}
