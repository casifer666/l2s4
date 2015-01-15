package naval;

import naval.*;


 public class Mer{
   //Constructeur
   public Mer(int x , int y  ){
     this.plateau = new Case[x][y];
        for (int i=0 ; i< x ; i++){
           for (int j =0 ; j<y ; j++){
              this.plateau[i][j]= new Case();
                                  }
               }
    }
	//Attribut
	private Case[][] plateau;

	public Case[][] getPlateau() {
		return this.plateau;
	}

	/** retourne touche si le bateau est touchee , dans l'eau si l'attaqueur a rate le bateau , et coule si il touche le bateau
	*@return touche si le bateau est touchee , dans l'eau si l'attaqueur a rate le bateau , et coule si il touche le bateau
	*/
	public 	Reponse vise (Position p){
		Case laCase = this.plateau [p.getX()][p.getY()];
			if (laCase.aEteVisee()){
				return Reponse.DANS_LEAU;
			}
			else{
 				laCase.vise();
    					if (laCase.getBateau() != null){
        					 laCase.getBateau().touche();
           							if (laCase.getBateau().estCoule()){
             							    return Reponse.COULE;
                                              			}
          							else {
              							    return Reponse.TOUCHE;
                						}
                                   	}
     					else {
        					return Reponse.DANS_LEAU;
          				}
     			}

	}
	/**renvoie la case de la position p
	*@param la position p 
	*@return la case de la position p
	*/
	public Case renvoieCase(Position p){
	
	      return this.plateau[p.getX()][p.getY()];
	}

	/** affiche le plateau ligne par ligne, case par case en
	* proposant un affichage differenie pour le defenseur et
	* l’attaquant. Le parametre defenseur determine l’affichage
	* a realiser.
	* @param defenseur true si l’affichage est pour le defenseur,
	* false si il est pour l’attaquant.
	*/
	public void affichage(boolean defenseur) {
            
                
     		for (int i=0; i<this.plateau.length; i++){
          		for (int j=0;j<this.plateau[i].length;j++){
         			 System.out.print(this.plateau[i][j].getCaractere(defenseur)+" ");
         	 }
         		 System.out.println();
     			}
	}

	/** pose le bateau b a partir de la position p dans la direction d.
	* Le nombre de case occupee est bien sur determine par la longueur
	* du bateau.
	* @param b le bateau a poser
	* @param p la position de la premiere case ou l’on pose le bateau
	* @param d la direction dans laquelle on pose b a partir de p
	* @exception IllegalStateException si on ne peut poser b a
	* partir de p dans la direction d parce que b sortirait du plateau
	* ou parce qu’un autre bateau occupe deja une des cases.
	*/


   public void poseBateau(Bateau b,Position p,Direction d) throws IllegalStateException {

    // on regarde SANS LE FAIRE si l'on peut poser le bateau : sans sortir du plateau et sans rencontrer une case non vide
    try {
        int taille = b.taille();
        Position p1 = p;
        for (int i=0;i<taille;i++){
           if( this.plateau[p1.getX()][p1.getY()].getBateau() != null){
                  throw new IllegalStateException();


        }
       p1 = d.positionSuivante(p1);
        }
    }
    catch(ArrayIndexOutOfBoundsException e ){

        throw new IllegalStateException();
    }

    int taille = b.taille();
        Position p1 = p;
        for (int i=0;i<taille;i++){
            this.plateau[p1.getX()][p1.getY()].setBateau(b);
            p1 = d.positionSuivante(p1);
        }
    }










}
