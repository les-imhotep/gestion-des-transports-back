package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.controller.vm.ErrorCode;
import dev.controller.vm.ErrorVM;
import dev.exceptions.HoraireException;
import dev.exceptions.NbDePlaceException;

@ControllerAdvice
public class ServiceExceptionController {

	@ExceptionHandler(NbDePlaceException.class)
	public ResponseEntity<?> nbDePlaceException() {
		return ResponseEntity.badRequest()
				.body(new ErrorVM(ErrorCode.NB_PLACE_INVALID, "Le nombre de places disponibles est supérieur au nombre de places du véhicule !"));
	}
	
	@ExceptionHandler(HoraireException.class)
	public ResponseEntity<?> horaireException() {
		return ResponseEntity.badRequest()
				.body(new ErrorVM(ErrorCode.HORAIRE_INVALID, "La date de l'annonce est antérieure à la date du jour !"));
	}

}
