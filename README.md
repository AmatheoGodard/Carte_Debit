# Carte Débit Temporaire 🏦💳

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)

## 📖 Description

**Carte Débit Temporaire** est un projet Java NetBeans permettant de créer et gérer des cartes de débit temporaires. Il facilite la gestion des cartes à durée limitée et le suivi des transactions associées.

> ⚠️ **Remarque importante** : Pour que le projet fonctionne correctement, il est nécessaire d'avoir un fichier `Cl_Connection.java` dans le package `pj_cartedebit` avec les informations de connexion à votre **base de données personnelle**. Exemple :

```java
package pj_cartedebit;

public class Cl_Connection {
    public static String url = "votre_url_de_base_de_donnees";
    public static String login = "votre_identifiant";
    public static String password = "votre_mot_de_passe";
}
```

Remplacez `url`, `login` et `password` avec vos informations personnelles de base de données.

## ⚡ Fonctionnalités principales

* ✅ Création de cartes temporaires avec durée configurable
* ✅ Activation et désactivation des cartes
* ✅ Suivi de l’état des cartes (actives, expirées, utilisées)
* ✅ Validation des transactions liées aux cartes

## 🛠 Prérequis

* Java JDK 17 ou supérieur
* NetBeans IDE
* Une base de données accessible avec vos informations renseignées dans `Cl_Connection.java`

## 🚀 Installation et exécution avec NetBeans

1. Cloner le dépôt :

```bash
git clone https://github.com/AmatheoGodard/Carte_Debit.git
```

2. Ouvrir NetBeans et importer le projet :

   * Menu `File > Open Project`
   * Sélectionner le dossier `Carte_Debit`

3. Ajouter le fichier `Cl_Connection.java` dans le package `pj_cartedebit` avec vos informations personnelles de connexion à la base de données.

4. Compiler et exécuter le projet :

   * Clic droit sur le projet dans NetBeans > `Clean and Build`
   * Clic droit > `Run` pour lancer l’application

5. (Optionnel) Pour créer un fichier JAR exécutable :

   * Clic droit sur le projet > `Clean and Build`
   * Le JAR se trouvera dans le dossier `dist/` du projet

## 🗂 Structure du projet

```
Carte_Debit/
├── libs/                       # bibliothèques externes ajoutées
├── nbproject/                   # configuration NetBeans
├── src/ pj_cartedebit/          # code source principal
├── .gitignore
├── build.xml                    # fichier de build NetBeans
├── manifest.mf                  # manifeste JAR
└── README.md
```
