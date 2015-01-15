<?php
	class Livre {
	
		private $titre;
		private $auteurs;
		private $editeur;

		function __construct($titre,$auteurs,$editeur = "") {
			$this -> titre = $titre;
			$this -> editeur = $editeur;
			if (is_array($auteurs)) {
				$this -> auteurs = $auteurs;
			}
			else {
				if (is_string($auteurs)) {
					$this -> auteurs = array($auteurs);
				}
				else {
					throw new exception("Type d'auteur incorrect");
				}
			}
		}

		public function imageTR() {
			$ligne = "<tr>";
			$ligne .= "<td>".implode(',',$this->auteurs)."</td>";
			$ligne .= "<td>".($this->titre)."</td>";
			$ligne .= "</tr>";
			return $ligne;
		}

	}
?>