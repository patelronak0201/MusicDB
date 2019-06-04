package com.springboot.musicdb.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.musicdb.exception.ResourceNotFoundException;
import com.springboot.musicdb.model.Artist;
import com.springboot.musicdb.repository.ArtistRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ArtistServiceTest {

	@Autowired
	private ArtistService artistService;

	@MockBean
	private ArtistRepository artistRepository;

	private Artist artist;

	@Before
	public void setUp() throws Exception {
		artist = new Artist();
		artist.setId(Long.valueOf(1));
		artist.setName("Tim");
	}

	@Test
	public void testGetAllArtists() {
		List<Artist> artists = new ArrayList();
		artists.add(artist);
		Mockito.when(artistRepository.findAll()).thenReturn(artists);

		List<Artist> resultList = artistService.getAllArtists();
		assertEquals(1, resultList.size());
		assertNotNull(resultList.get(0));
		assertEquals("Tim", resultList.get(0).getName());

	}

	@Test
	public void testFindByIds() {
		List<Artist> artists = new ArrayList();
		artists.add(artist);
		Mockito.when(artistRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(artist));

		Artist resultArtist = artistService.findById(Long.valueOf(1));
		assertNotNull(resultArtist);
		assertEquals("Tim", resultArtist.getName());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testExceptionOnFindById() {
		artistService.findById(Long.valueOf(2));
	}

	@Test
	public void testCreateArtist() {
		Mockito.when(artistRepository.save(artist)).thenReturn(artist);
		Artist resultArtist = artistService.createArtist(artist);
		assertNotNull(resultArtist);
		assertEquals(Long.valueOf(1), resultArtist.getId());
	}

	@Test
	public void testUpdateArtist() {
		Mockito.when(artistRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(artist));
		Mockito.when(artistRepository.save(artist)).thenReturn(artist);
		Artist resultArtist = artistService.updateArtist(artist, Long.valueOf(1));
		assertNotNull(resultArtist);
		assertEquals(Long.valueOf(1), resultArtist.getId());
		assertEquals("Tim", resultArtist.getName());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testExceptionOnUpdateArtist() {
		artistService.updateArtist(artist, Long.valueOf(1));
	}

	@Test
	public void testDeleteArtist() {
		Mockito.when(artistRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(artist));
		ResponseEntity<?> re = artistService.deleteArtist(Long.valueOf(1));		
		assertNotNull(re);
	}

	@Test(expected = ResourceNotFoundException.class)
	public void testExceptionOnDeleteArtist() {
		artistService.deleteArtist(Long.valueOf(1));
	}

}
