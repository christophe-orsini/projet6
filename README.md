# LES AMIS DE L'ESCALADE

## Project N°6 Site WEB communautaire

* Développeur : Christophe ORSINI
* Version     : 1.0.2

---
### Prérequis
Vous devez avoir **java** version **1.8.0_222** ou supérieur et **maven** version **3.6.2** ou supérieur sur votre ordinateur pour pouvoir exécuter cette application  
Maven va installer les dépendances requises pour l'exécution de l'application (Spring boot, Apache-Tomcat, Bootstrap, ...) 
 
Vous devez également avoir **MySQL** version **5.7.21** ou superieur et le serveur MySQL doit être en fonction

### Chargement
Clonez le dépôt à cette adresse [https://github.com/christophe-orsini/Projet6.git](https://github.com/christophe-orsini/Projet6.git)

### Deploiement
1. Mettre le serveur MySQL en fonction
2. Créer une base de données nommée "escalade"
3. Installer l'application (voir Installation ci-dessous)
4. Exécuter l'application une première fois pour construire la structure de la base de données (voir Exécution ci-dessous)
5. Importer le script `demodatas.sql` pour charger les données de démonstration dans la base  

>  \*Vous trouverez ce fichier de script dans le dossier `escalade/src/main/ressources`

L'application est prète à fonctionner avec 3 utilisateurs :
- `admin@ae.fr` mot de passe `admin` pour le rôle d'administrateur
- `member@ae.fr` mot de passe `member` pour le rôle de membre de l'association
- `user@ae.fr` mot de passe `user` pour le rôle d'utilisateur connecté

### Installation
1. Placez vous dans le dossier où vous avez cloné le dépôt  
2. Tapez la commande `install` si vous êtes en mode console ou cliquez sur `install.bat`  

### Exécution
Tapez la commande `run` si vous êtes en mode console ou cliquez sur `run.bat`  

### Néttoyage
Si necessaire, vous pouvez supprimer les données de démonstration en exécutant le script `cleandatas.sql` et la base de données sera entièrement vidées.  
Si vous exécutez le script `productiondatas.sql`, la base de données sera entièrement vidées et seul le compte de l'administrateur sera créé avec les éléments ci-dessus

>  \*Vous trouverez ces fichiers de script dans le dossier `escalade/src/main/ressources`

---
#### Notes de versions
- Version 0.0.0  
    - Début du projet
