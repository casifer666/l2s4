<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
<meta charset="UTF-8" />

<?php
	require_once('Livre.class.php');

	function imageLivres($tab_livres) {
		$table = "<table>";
		foreach($tab_livres as $livre) {
			$table .= ($livre -> imageTR());
		}
		$table .= "</table>";
		return $table;
	}
?>