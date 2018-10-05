package dev.controller;

import java.util.Optional;

import dev.domain.Collegue;
import dev.service.CollegueService;

public class CollegueServiceMock implements CollegueService {

	@Override
	public Optional<Collegue> findCollegue(String username) {
		return Optional.empty();
	}

}
