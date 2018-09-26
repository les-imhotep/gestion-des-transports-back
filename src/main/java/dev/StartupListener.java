package dev;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Annonce;
import dev.domain.Categorie;
import dev.domain.Collegue;
import dev.domain.ReservationCovoiturage;
import dev.domain.ReservationVehicule;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.Statut;
import dev.domain.VehiculeDeSociete;
import dev.domain.Version;
import dev.repository.AnnonceRepo;
import dev.repository.CollegueRepo;
import dev.repository.ReservationCovoiturageRepo;
import dev.repository.ReservationVehiculeRepo;
import dev.repository.VehiculeRepo;
import dev.repository.VersionRepo;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
public class StartupListener {

	private String appVersion;
	private VersionRepo versionRepo;
	private VehiculeRepo vehiculeRepo;
	private PasswordEncoder passwordEncoder;
	private CollegueRepo collegueRepo;
	private ReservationVehiculeRepo reservationVehiculeRepo;
	private AnnonceRepo annonceRepo;
	private ReservationCovoiturageRepo reservationCovoiturageRepo;

	public StartupListener(@Value("${app.version}") String appVersion, AnnonceRepo annonceRepo,
			ReservationCovoiturageRepo reservationCovoiturageRepo, ReservationVehiculeRepo reservationVehiculeRepo,
			VehiculeRepo vehiculeRepo, VersionRepo versionRepo, PasswordEncoder passwordEncoder,
			CollegueRepo collegueRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.vehiculeRepo = vehiculeRepo;
		this.reservationVehiculeRepo = reservationVehiculeRepo;
		this.annonceRepo = annonceRepo;
		this.reservationCovoiturageRepo = reservationCovoiturageRepo;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		this.versionRepo.save(new Version(appVersion));

		// Création de deux utilisateurs

		Collegue col1 = new Collegue();
		col1.setNom("Admin");
		col1.setPrenom("DEV");
		col1.setEmail("admin@dev.fr");
		col1.setMotDePasse(passwordEncoder.encode("superpass"));
		col1.setRoles(Arrays.asList(new RoleCollegue(col1, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col1, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col1);

		Collegue col2 = new Collegue();
		col2.setNom("User");
		col2.setPrenom("DEV");
		col2.setEmail("user@dev.fr");
		col2.setMotDePasse(passwordEncoder.encode("superpass"));
		col2.setRoles(Arrays.asList(new RoleCollegue(col2, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col2);

		VehiculeDeSociete vehiculeDeSociete = new VehiculeDeSociete();
		vehiculeDeSociete.setCategorie(Categorie.BERLINE);
		vehiculeDeSociete.setDisponibilite(true);
		vehiculeDeSociete.setImmatriculation("AA-666-AA");
		vehiculeDeSociete.setMarque("Peugeot");
		vehiculeDeSociete.setModele("106");
		vehiculeDeSociete.setNombreDePlace(4);
		vehiculeDeSociete.setPhoto("fghjklmù");
		vehiculeDeSociete.setStatut(Statut.HORS_SERVICE);
		this.vehiculeRepo.save(vehiculeDeSociete);

		ReservationVehicule resVehicule = new ReservationVehicule();
		resVehicule.setCollegue(col2);
		resVehicule.setVehiculeSoc(vehiculeDeSociete);
		resVehicule.setChauffeur(true);
		resVehicule.setDepart(LocalDateTime.of(2018, 9, 26, 19, 00));
		resVehicule.setArrive(LocalDateTime.of(2018, 9, 26, 23, 25));
		this.reservationVehiculeRepo.save(resVehicule);

		ReservationVehicule resVehicule2 = new ReservationVehicule();
		resVehicule2.setCollegue(col1);
		resVehicule2.setVehiculeSoc(vehiculeDeSociete);
		resVehicule2.setChauffeur(false);
		resVehicule2.setDepart(resVehicule.getDepart());
		resVehicule2.setArrive(resVehicule.getArrive());
		this.reservationVehiculeRepo.save(resVehicule2);

		Annonce annonce = new Annonce();
		annonce.setCollegue(col1);
		annonce.setHoraireDeDepart(LocalDateTime.now());
		annonce.setLieuDeDepart("Nantes");
		annonce.setLieuDeDestination("Brest");
		annonce.setNombreDeVoyageurs(6);
		annonce.setVehicule(vehiculeDeSociete);
		this.annonceRepo.save(annonce);

		ReservationCovoiturage reservationCovoiturage = new ReservationCovoiturage();
		reservationCovoiturage.setAnnonce(annonce);
		reservationCovoiturage.setCollegue(col2);
		this.reservationCovoiturageRepo.save(reservationCovoiturage);

	}

}
