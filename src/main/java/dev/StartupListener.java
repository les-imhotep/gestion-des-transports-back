package dev;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Categorie;
import dev.domain.Collegue;
import dev.domain.ReservationVehicule;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.Statut;
import dev.domain.VehiculeDeSociete;
import dev.domain.Version;
import dev.repository.CollegueRepo;
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

	public StartupListener(@Value("${app.version}") String appVersion, ReservationVehiculeRepo reservationVehiculeRepo,
			VehiculeRepo vehiculeRepo, VersionRepo versionRepo, PasswordEncoder passwordEncoder,
			CollegueRepo collegueRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.vehiculeRepo = vehiculeRepo;
		this.reservationVehiculeRepo = reservationVehiculeRepo;
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
		this.reservationVehiculeRepo.save(resVehicule);

		ReservationVehicule resVehicule2 = new ReservationVehicule();
		resVehicule2.setCollegue(col1);
		resVehicule2.setVehiculeSoc(vehiculeDeSociete);
		resVehicule2.setChauffeur(false);
		this.reservationVehiculeRepo.save(resVehicule2);

	}

}
