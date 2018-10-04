package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.controller.vm.ErrorCode;
import dev.controller.vm.ErrorVM;
import dev.exceptions.HoraireException;
import dev.exceptions.NbDePlaceException;

/**
 * @author diginamic09
 * 
 * Controller qui va attraper toutes nos exceptions
 *
 */
@ControllerAdvice
public class ServiceExceptionController {

	/**
	 * Catch et envoie du message d'erreur si le nombre de place disponible n'est pas valide
	 * 
	 * @return
	 */
	@ExceptionHandler(NbDePlaceException.class)
	public ResponseEntity<?> nbDePlaceException() {
		return ResponseEntity.badRequest()
				.body(new ErrorVM(ErrorCode.NB_PLACE_INVALID, "Le nombre de places disponibles est supérieur au nombre de places du véhicule !"));
	}
	
	/**
	 * Catch et envoie du message d'erreur si l'horaire n'est pas valide
	 * 
	 * @return
	 */
	@ExceptionHandler(HoraireException.class)
	public ResponseEntity<?> horaireException() {
		return ResponseEntity.badRequest()
				.body(new ErrorVM(ErrorCode.HORAIRE_INVALID, "La date de l'annonce est antérieure à la date du jour !"));
	}

}
