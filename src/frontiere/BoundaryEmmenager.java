package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenue villageois "+ nomVisiteur);
		StringBuilder question1 = new StringBuilder();
		question1.append("quele est votre force?");
		int force = Clavier.entrerEntier(question1.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
		
	}
	

	private void emmenagerDruide(String nomVisiteur) {
	    System.out.println("Bienvenue Druide " + nomVisiteur);

	    StringBuilder question2 = new StringBuilder();
	    question2.append("Quelle est votre force ?");
	    int force = Clavier.entrerEntier(question2.toString());

	    int potionmin, potionmax;
	    do {
	        StringBuilder question3 = new StringBuilder();
	        question3.append("Quelle est la force de potion la plus faible que vous produisez ?");
	        potionmin = Clavier.entrerEntier(question3.toString());

	        StringBuilder question4 = new StringBuilder();
	        question4.append("Quelle est la force de potion la plus forte que vous produisez ?");
	        potionmax = Clavier.entrerEntier(question4.toString());

	        if (potionmin > potionmax) {
	            System.out.println("Attention Druide " + nomVisiteur + ", vous vous êtes trompé entre min et max !");
	        }
	    } while (potionmin > potionmax);

	    controlEmmenager.ajouterDruide(nomVisiteur, force, potionmin, potionmax);
	}

}
