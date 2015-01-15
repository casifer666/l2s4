package naval;


public class Bateau{
	//ATTRIBUT
	private int longueur;
	private int pointVie ;
	//CONSTRUCTEUR
	public Bateau ( int longueur ){
       		this.pointVie = longueur ;
       		this.longueur = longueur ;
	}
	/**retourne la longueur intiale du bateau
	*@return la longueur du bateau
	*
	*/
	public int taille(){
	  return this.longueur;
	}
	/**indique si le bateau est coule ou pas
	*@return vrai  si le bateau est coule , faux sinon
	*/
	 public boolean estCoule () {
 		 if (this.pointVie == 0 ){
  			 return true;
  		 }
  		 else
  		{
  			return false ;
  		}
 	}
	/** enleve des points de vie a notre bateau
		*/
 	public void touche ()
 	{

   		this.pointVie = this.pointVie - 1 ;
 	}
	/** indique les points de vie de notre bateau
	* @return point de vie de notre bateau
	*/
 	public int getVie () {
   		return this.pointVie ;
 	}
 	/* renvoie une chaine de caractere indiquant les points de vie restants
 	*@return les points de vie restants
 	*/
 	public String toString () {

   			 return "les points de vie restants " + this.pointVie ;
 		}
	/** indique si 2 bateaux ont les memes point de vie
	* @param o
	* @return vrai si les 2 bateaux ont les memes points de vie , faux sinon
	*/
	 public boolean equals (Object o) {
 		if ( o instanceof Bateau) {
 			Bateau lAutre = (Bateau) o;
 			return this.getVie() == lAutre.getVie ();
		 }
 		else
 		{ 
 		return false;
		 }

 	}

}
