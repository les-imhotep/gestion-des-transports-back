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
		vehiculeDeSociete.setCategorie(Categorie.CITADINE);
		vehiculeDeSociete.setImmatriculation("AA-111-AA");
		vehiculeDeSociete.setMarque("Peugeot");
		vehiculeDeSociete.setModele("208");
		vehiculeDeSociete.setNombreDePlace(5);
		vehiculeDeSociete.setPhoto("https://pictures.topspeed.com/IMG/crop/201608/peugeot-208-active-d-2_1600x0w.jpg");
		vehiculeDeSociete.setStatut(Statut.EN_SERVICE);
		this.vehiculeRepo.save(vehiculeDeSociete);

		VehiculeDeSociete vehiculeDeSociete2 = new VehiculeDeSociete();
		vehiculeDeSociete2.setCategorie(Categorie.SUV);
		vehiculeDeSociete2.setImmatriculation("BB-222-BB");
		vehiculeDeSociete2.setMarque("Peugeot");
		vehiculeDeSociete2.setModele("3008");
		vehiculeDeSociete2.setNombreDePlace(5);
		vehiculeDeSociete2.setPhoto("http://www.hdcarwallpapers.com/walls/2017_peugeot_3008_gt-HD.jpg");
		vehiculeDeSociete2.setStatut(Statut.EN_SERVICE);
		this.vehiculeRepo.save(vehiculeDeSociete2);
		
		VehiculeDeSociete vehiculeDeSociete3 = new VehiculeDeSociete();
		vehiculeDeSociete3.setCategorie(Categorie.CITADINE);
		vehiculeDeSociete3.setImmatriculation("CC-333-CC");
		vehiculeDeSociete3.setMarque("Opel");
		vehiculeDeSociete3.setModele("Corsa");
		vehiculeDeSociete3.setNombreDePlace(5);
		vehiculeDeSociete3.setPhoto("https://www.cpchardware.com/wp-content/uploads/2017/05/opel_corsa_01.jpg");
		vehiculeDeSociete3.setStatut(Statut.HORS_SERVICE);
		this.vehiculeRepo.save(vehiculeDeSociete3);
		
		VehiculeDeSociete vehiculeDeSociete4 = new VehiculeDeSociete();
		vehiculeDeSociete4.setCategorie(Categorie.CITADINE);
		vehiculeDeSociete4.setImmatriculation("DD-444-DD");
		vehiculeDeSociete4.setMarque("Volkswagen");
		vehiculeDeSociete4.setModele("Passat break");
		vehiculeDeSociete4.setNombreDePlace(5);
		vehiculeDeSociete4.setPhoto("https://squir.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/v/o/volkswagen_passat_variant_r-line_2018_0000.jpg");
		vehiculeDeSociete4.setStatut(Statut.EN_SERVICE);
		this.vehiculeRepo.save(vehiculeDeSociete4);
		
		VehiculeDeSociete vehiculeDeSociete5 = new VehiculeDeSociete();
		vehiculeDeSociete5.setCategorie(Categorie.CITADINE);
		vehiculeDeSociete5.setImmatriculation("EE-555-EE");
		vehiculeDeSociete5.setMarque("Citroën");
		vehiculeDeSociete5.setModele("Space Tourer");
		vehiculeDeSociete5.setNombreDePlace(7);
		vehiculeDeSociete5.setPhoto("https://masepmadit.com/wp-content/uploads/2018/08/citroen-7-places-luxe-of-citroen-7-places-1.jpg");
		vehiculeDeSociete5.setStatut(Statut.EN_REPARATION);
		this.vehiculeRepo.save(vehiculeDeSociete5);

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
		annonce.setHoraireDeDepart(LocalDateTime.of(2118, 9, 30, 19, 00));
		annonce.setLieuDeDepart("Nantes");
		annonce.setLieuDeDestination("Brest");
		annonce.setNombreDeVoyageurs(4);
		annonce.setVehicule(vehiculeDeSociete);
		annonce.setNombreDePlacesDisponibles(annonce.getNombreDeVoyageurs() - annonce.getVehicule().getNombreDePlace());
		this.annonceRepo.save(annonce);

		Annonce annonce2 = new Annonce();
		annonce2.setCollegue(col1);
		annonce2.setHoraireDeDepart(LocalDateTime.of(2014, 9, 30, 19, 00));
		annonce2.setLieuDeDepart("Brest");
		annonce2.setLieuDeDestination("Nantes");
		annonce2.setNombreDeVoyageurs(4);
		annonce2.setVehicule(vehiculeDeSociete);
		annonce2.setNombreDePlacesDisponibles(
				annonce2.getNombreDeVoyageurs() - annonce2.getVehicule().getNombreDePlace());
		this.annonceRepo.save(annonce2);

		ReservationCovoiturage reservationCovoiturage = new ReservationCovoiturage();
		reservationCovoiturage.setAnnonce(annonce);
		reservationCovoiturage.setCollegue(col2);
		this.reservationCovoiturageRepo.save(reservationCovoiturage);
	}
}
