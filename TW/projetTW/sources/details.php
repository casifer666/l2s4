<!-- HOSSAINY Said et DIAGNE Salla -->

<?php
	session_start();
?>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8"/>
		<link rel="stylesheet" type="text/css" href="details.css"/>
		<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
		<script type="text/javascript" src="index.js"></script>
		<link rel="icon" type="image/png" href="images/cityfinder.png"/>
		<?php include('titreDetails.php'); ?>
	</head>

	<body onload="afficherCarte(); zoom(); messageFavori();">
		<div id="main">
			<div id="details">
				<?php include('detailsCommune.php'); ?>
				<div id="favoriser" onclick="gereFavori();"></div>
				<div id="retour" onclick="window.location.href='<?php if (($_SESSION['page'] != 1) || isset($_GET['debut']))
				echo($_SESSION['url']); else echo($_SESSION['url']."&debut=non"); ?>'"> Retour à l'accueil </div>
			</div>
			<div id="macarte"></div>
		</div>
	</body>
</html>
