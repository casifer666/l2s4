%%

%unicode

NOMBRE_ENTIER=[0-9]+

DIRECTIONS="nord"|"sud"|"ouest"|"est"

ESPACES=" "?

IDENTIFICATEUR=[a-z_]+

%state ENTIER_LU

%state FOIS_LU

%state ORIGINE_LUE

%state PAS_LU

%state REPETER_LU

%state FIN_LUE

%state DEFINIR_LU

%%

<YYINITIAL> "\n" {}

<YYINITIAL> {ESPACES}"quitter"{ESPACES} {return new ULMotClef(Token.eof);}

<YYINITIAL> {ESPACES}"lever"{ESPACES} {return new ULMotClef(Token.lever);}

<YYINITIAL> {ESPACES}"baisser"{ESPACES} {return new ULMotClef(Token.baisser);}

<YYINITIAL> {ESPACES}"nord"{ESPACES} {return new ULMotClef(Token.nord);}

<YYINITIAL> {ESPACES}"sud"{ESPACES} {return new ULMotClef(Token.sud);}

<YYINITIAL> {ESPACES}"ouest"{ESPACES} {return new ULMotClef(Token.ouest);}

<YYINITIAL> {ESPACES}"est"{ESPACES} {return new ULMotClef(Token.est);}

<YYINITIAL> {ESPACES}{NOMBRE_ENTIER} {yybegin(ENTIER_LU); return new ULEntier(Integer.parseInt(yytext().trim()));}

<ENTIER_LU> {ESPACES}"fois"{ESPACES} {yybegin(FOIS_LU); return new ULMotClef(Token.fois);}

<FOIS_LU> {DIRECTIONS} {yybegin(YYINITIAL); if (yytext().equals("nord")) return new ULMotClef(Token.nord); else if (yytext().equals("sud")) return new ULMotClef(Token.sud); else if (yytext().equals("est")) return new ULMotClef(Token.est); else return new ULMotClef(Token.ouest);}

<YYINITIAL> {ESPACES}"pas"{ESPACES} {yybegin(PAS_LU); return new ULMotClef(Token.pas);}

<PAS_LU> {NOMBRE_ENTIER} {yybegin(YYINITIAL); return new ULEntier(Integer.parseInt(yytext()));}

<YYINITIAL> {ESPACES}"origine"{ESPACES} {yybegin(ORIGINE_LUE); return new ULMotClef(Token.origine);}

<ORIGINE_LUE> "("{NOMBRE_ENTIER}","{NOMBRE_ENTIER}")" {yybegin(YYINITIAL); String[] t = yytext().substring(1,yytext().length()-1).split(","); return new ULPoint(Integer.parseInt(t[0]),Integer.parseInt(t[1]));}

<ENTIER_LU> {ESPACES}"fois"{ESPACES} {yybegin(FOIS_LU); return new ULMotClef(Token.fois);}

<YYINITIAL> {ESPACES}"repeter"{ESPACES} {yybegin(REPETER_LU); return new ULMotClef(Token.repeter);}

<REPETER_LU> {NOMBRE_ENTIER} {yybegin(ENTIER_LU); return new ULEntier(Integer.parseInt(yytext()));}

<FOIS_LU> {NOMBRE_ENTIER} {yybegin(ENTIER_LU); return new ULEntier(Integer.parseInt(yytext()));}

<FOIS_LU> {ESPACES}"pas"{ESPACES} {yybegin(PAS_LU); return new ULMotClef(Token.pas);}

<YYINITIAL> {ESPACES}"fin"{ESPACES} {yybegin(FIN_LUE); return new ULMotClef(Token.fin);}

<FIN_LUE> {ESPACES}"repeter"{ESPACES} {yybegin(YYINITIAL); return new ULMotClef(Token.repeter);}

<YYINITIAL> {ESPACES}"definir"{ESPACES} {yybegin(DEFINIR_LU); return new ULMotClef(Token.definir);}

<DEFINIR_LU> {IDENTIFICATEUR} {yybegin(YYINITIAL); return new ULIdent(yytext());}

<FIN_LUE> {ESPACES}"definir"{ESPACES} {yybegin(YYINITIAL); return new ULMotClef(Token.definir);}

<FOIS_LU> {IDENTIFICATEUR} {yybegin(YYINITIAL); return new ULIdent(yytext());}

<YYINITIAL> {ESPACES}{IDENTIFICATEUR}{ESPACES} {return new ULIdent(yytext().trim());}