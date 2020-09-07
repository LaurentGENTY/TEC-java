PROJET TRANSPORT EN COMMUN (TEC)
======
## PREREQUIS

Pour ce projet, il faudra :
  * JDK Java SE 8u221 (ou supérieure)
  * make
  * machine Linux.

## RESUME

Ce projet va porter en Java une application écrite en C en adoptant une approche
orientée objet. Le portage va se faire de manière incrémentale au fil des TD.

Il concerne la gestion de montée et descente de passagers dans des autobus. Un autobus gère sa liste de passagers. Il va alerter chacun de ses passagers des
nouveaux arrêts et ces derniers vont lui répondre en lui demandant de sortir, ou
bien de changer de place (assise, debout).

Dans cette branche du projet, les classes Vehicule et Passager sont abstraits. Vous pouvez trouver la branche factory avec la commande **git checkout TD{numero}factory**.

Dans la version actuelle du projet, on a plusieurs types de Montee(4 types) et plusieurs types d'Arret(5 types) qui vont constituer ensemble un type de passager. Il y en a 3 types de passagers qui implémentent chacun un couple de Montee-Arret. Le lancement de TestsGlobaux va faire des tests sur l'ensemble des passagers.

## ARCHITECTURE

Ce projet se décompose de la manière suivante :
  * **Makefile**
  * **README**
  * **src/** : fichiers sources .java des classes principales
  * **tst/** : fichiers sources des tests utilisant les classes principales
  * **build/tec/** : fichiers compilés du paquetage **tec** .class
  * **report/** : contient le rapport finale sous format PDF

## COMPILATION ET EXECUTION

Pour compiler le projet :
  * **make** : compiler l'ensemble des fichiers sources qu'il va rediriger dans
  **build/** (ou **build/tec/** pour les classes appartenant au paquetage **tec**)
  * **make tests** : compiler tous les fichiers sources ainsi que les fichiers tests
  qu'il va rediriger dans **build/** (ou **build/tec/** pour les classes appartenant au paquetage **tec**) pour finalement exécuter la classe des *TestsGlobaux.java*
  * **make clean** : supprimer tous les exécutables dans **build/** récursivement
  (et éventuellement dans **src/**) et les fichiers *indésirable* (\*~...)
