# La  bibliotheque - brief Simplon java EE

Brief réalisée dans le cadre de ma formation en spécialisation Java EE chez Simplon.co
Le programme devait être capable de gérer les livres d'une bibliothèque, des imports et exports en .csv ainsi que la location des livres.
Le tout devait être navigable via un menu en console et l'utilisateur devait pouvoir indiquer manuellement la date de fin de sa location.


## Authors

- [@Sarah Katz](https://github.com/Sarah-Katz)

### Usage

Afin d'importer un fichier, il faut impérativement fournir un .csv se nommant "Liste_des_livres.csv" à la racine du programme.
Le formatage de ce fichier utilise des pipes ("|") comme séparateur pour les champs suivants et dans l'ordre :
"Titre|Auteur.ice|Genre|Nombre de pages|Nombre de copies".

En cas de non-respect du formatage, le programme créera la liste avec "0" comme nombre de pages, et "-1" comme nombre de copies, si ces champs contiennent des valeurs autres que des chiffres entier.

L'export de la liste via le programme créé ou écrase "Liste_des _livres.csv" à la racine.

La location des livres vient prendre en compte le nombre de copies. Si les copies indiquent -1, le programme informe l'utilisateur de l'incohérence dans les données.
