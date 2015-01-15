<!-- HOSSAINY Said et DIAGNE Salla -->

<?php
	class Commune {

		// nom de la commune
		private $nom;

		// code département
		private $codeDept;

		// code commune
		private $codeComm;

		// code région
		private $codeReg;

		// latitude
		private $latitude;

		// longitude
		private $longitude;

		// tncc
		private $tncc;

		// population
		private $population;

		// constructeur pour les objets de la classe Commune
		function __construct($nom,$codeDept,$codeComm,$codeReg,$latitude,$longitude,$tncc,$population) {
			$this->nom = $nom;
			$this->codeDept = $codeDept;
			$this->codeComm = $codeComm;
			$this->latitude = $latitude;
			$this->longitude = $longitude;
			$this->tncc = $tncc;
			$this->population = $population;
			$this->codeReg = $codeReg;
		}

	        // méthode qui renvoie l'article de la commune
		function getArticle($tncc) {
			$t = array('0'=>"",'1'=>"",'2'=>"Le",'3'=>"La",'4'=>"Les",'5'=>"L'",'6'=>"Aux",'7'=>"Las",'8'=>"Los");
			if ($tncc < 9) return $t[$tncc]; else return null;
		}

		// méthode qui gère l'espacement entre l'article et le nom de la commune
		function espacementArticle($tncc) {
			if ($tncc == '0' || $tncc == '1' || $tncc == '5')
				return $this->getArticle($tncc);
			else
				return $this->getArticle($tncc)." ";	
		}


		// méthode qui produit un affichage de la commune dans la liste des résultats
		function afficheResultat() {
			$coordonnees = $this->longitude.",".$this->latitude;
			$code = trim($this->codeDept.$this->codeComm);
			/* l'affichage de la commune constitue un div cliquable, l'utilisateur sera redirigé vers la page détails de cette commune
			le code insee et les coordonnees de la commune sont passées dans l'url pour pouvoir savoir sur quelle commune on a cliqué
			et afficher une carte zoomée sur cette commune */
			echo('<div class="resultat" onclick="location.href=\'details.php?code='.$code.'&coordonnees='.$coordonnees.'\';" style="font-size : 12pt; cursor : pointer; text-align : center; border-bottom : solid black;
			border-width : 1px; padding-bottom : 8%; padding-top : 8%; ">');
			echo($this->espacementArticle($this->tncc).$this->nom." (Département ".$this->codeDept.")");
			echo("<br/>Code Insee : ".$code);
			// les coordonnees sont dans une balise p, cela facilite la récupération en Javascript pour ajouter un marqueur sur la carte
			echo('<br/> Long,Lat : <p style="display : inline" name="coordonnees">'.$coordonnees.'</p>');
			echo("</div>");
		}

		// méthode qui renvoie la charnière de la commune ou du département en fonction de son tncc
		function getCharniere($tncc) {
			$t = array('0'=>"de",'1'=>"d'",'2'=>"du",'3'=>"de la",'4'=>"des",'5'=>"de l'",'6'=>"des",'7'=>"de las",'8'=>"de los");
			if ($tncc < 9) return $t[$tncc]; else return null;
		}

		// méthode qui gère l'espacement entre la charnière et le nom de la commune
		function espacementCharniere($tncc) {
			if ($tncc == '1' || $tncc == '5')
				return $this->getCharniere($tncc);
			else
				return $this->getCharniere($tncc)." ";	
		}

		// méthode qui permet d'afficher les détails complets de la commune dans la page "détails" (details.php)
		function afficheDetails() {
			include('connect.php');
			// interrogation de la base pour récupérer toutes les données concernant le département et la région de la commune
			$detailsDep = $connexion->query("SELECT * FROM departements WHERE code='".$this->codeDept."'");
			$detailsDep = $detailsDep->fetch();
			$detailsReg = $connexion->query("SELECT * FROM regions WHERE code='".$this->codeReg."'");
			$detailsReg = $detailsReg->fetch();
			$chefLieuComm = $connexion->query("SELECT nom,tncc,comm,dept FROM communes WHERE comm='".$detailsDep['cl_comm']."' AND dept='".$detailsDep['cl_dept']."'");
			$chefLieuComm = $chefLieuComm->fetch();
			$chefLieuDep = $connexion->query("SELECT nom,tncc,code FROM departements WHERE code='".$detailsReg['cl_dept']."'");
			$chefLieuDep = $chefLieuDep->fetch();
			$compl = $connexion->query("SELECT compl FROM communes WHERE dept||comm='".$this->codeDept.$this->codeComm."'");
			$compl = $compl->fetch();
			echo("La commune ".$this->espacementCharniere($this->tncc).$this->nom." (".trim($this->codeDept.$this->codeComm).")".$compl['compl']."
				se situe dans le département ".$this->espacementCharniere($detailsDep['tncc']).$detailsDep['nom'].
				" (".$detailsDep['code'].") de la région ".$detailsReg['nom']." (".$detailsReg['code'].").<br/>");
			echo("Elle comporte ".$this->population." habitants.<br/>");
			echo("La commune chef-lieu de son département est ".getArticle($chefLieuComm['tncc'])." ".$chefLieuComm['nom']." (".trim($chefLieuComm['dept'].$chefLieuComm['comm']).").<br/>");
			echo("Le département chef-lieu de sa région est ".getArticle($chefLieuDep['tncc'])." ".$chefLieuDep['nom']." (".$chefLieuDep['code'].").<br/>");
		}
	}
?>
