<!-- HOSSAINY Said et DIAGNE Salla -->

<?php
	session_start();
?>

<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<link rel="stylesheet" type="text/css" href="index.css"/>
		<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
		<title> City Finder ou comment vous situer en France en un clic ! </title>
		<script type="text/javascript" src="index.js"></script>
		<link rel="icon" type="image/png" href="images/cityfinder.png"/>
	</head>

	<body onload="afficherCarte()">
		<span id="favoris" class="openbig"> <div id="titrefav"> Favoris <img src="images/favicon.png"> </div>
			<div id="contenu"> <?php include('affichageFavoris.php'); ?> </div>
		</span>
		<table id="main">
			<tr id="ban">
				<td id="logo"> <h1> <img src="images/1.png" onclick="location.href='index.php'"> </h1> </td>
				<td id="rr">
					<form id="recherche_rapide" action="index.php?page=1" method="post">
						<input type="text" name="nom" size="80" placeholder="Rechercher une commune" required="required"/>
						<button type="submit" name="search" value="rechercher"></button>
					</form>
				</td>	
			</tr>
			<tr>
				<td id="ra">
					<div id="onglets">
						<div onclick="afficherRecherche()" id="onglet_rech">recherche</div>
						<div onclick="afficherResultats()" id="onglet_res">résultats</div>
					</div>
					<div id="page_onglet">
						<span id="alert" style="color : red"></span>
						<div id="recherche">
							<script> afficherRecherche(); </script>
							<div>
								<form id="recherche_avancee" action="index.php?page=1" method="post">
									<fieldset>
										<label name="Commune" style="margin-right : 33%;"> Commune </label><br/>
										<input type="text" name="commune" size="20" placeholder="Ex : Bordeaux"/><br/>
										<label name="Commune" style="margin-right : 30%"> Code Insee </label><br/> 
										<input type="text" name="code" size="20" maxlength="5" pattern="[0-9A-Z]+" placeholder="Ex : 33063"/><br/>
										<label name="Commune" style="margin-right : 24%"> Département </label><br/> 
										<input type="text" name="departement" size="20" maxlength="3" pattern="[0-9A-Z]+" placeholder="Ex : 33"/><br/>
										<label name="Commune" style="margin-right : 40%"> Région </label><br/>
										<input type="text" name="region" size="20" pattern="[0-9A-Z]+" placeholder="Ex : 72"/><br/>
										<label name="Commune" style="margin-right : 4%"> Population minimale </label><br/> 
										<input type="text" name="pop_min" size="20" maxlength="10" pattern="[0-9]+" placeholder="Ex : 0"/><br/>
										<label name="Commune" style="margin-right : 2.5%"> Population maximale </label><br/> 
										<input type="text" name="pop_max" size="20" maxlength="10" pattern="[0-9]+" placeholder="Ex : 3000000"/><br/><br/>
										<button type="submit" name="search" value="rechercher">Rechercher</button>
										<button type="reset" name="delete" value="effacer">Effacer</button>
									</fieldset>
								</form>
							</div>
						</div>
						<div id="resultats">
							<?php include('rechercheRapide.php'); include('rechercheAvancee.php'); ?>
						</div>
					</div>
					<div id="pagination"> <?php include('pagination.php'); ?> </div>
				</td>
				<td id="carte">
					<div id="macarte"></div>
				</td>
			</tr>
		</table>
	</body>
</html>
