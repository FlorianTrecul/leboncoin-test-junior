<h1 align="center">Leboncoin Test Junior</h1>

<p align="center">
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>

<p align="center"> 

Réaliser une application native Android affichant la liste d'items avec pour chaque item un title et une image.
Les données contenues dans ce json doivent être téléchargées par l'app au Runtime, et non mises manuellement dans les assets de l'app.

</p>
</br>

## Stack Technique & Bibliothèques Open-source
- Sdk minimum 21+
- [Kotlin](https://kotlinlang.org/), [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) - Pour la partie Asynchrone.
- [Hilt](https://dagger.dev/hilt/) - Pour l'injection de dépendance.
- Jetpack
  - [Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle) - Pour observer les données lorsque l'état du cycle de vie change.
  - [Navigation Component](https://developer.android.com/guide/navigation) - Pour permettre la navigation de l'utilisateur dans l'application à travers les différents écrans.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Pour stocker et gérer les données liées à l'interface utilisateur en tenant compte du cycle de vie
- Architecture
  - MVVM Architecture (Model - View - ViewModel)
  - Repository pattern
  - Clean Architecture
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Permettre de créer un client HTTP de type sécurisé pour Android.
- [Moshi](https://github.com/square/moshi/) - Une bibliothèque JSON pour Kotlin.
- [Coil](https://coil-kt.github.io/coil/) - Une bibliothèque de chargement d'images pour Android.
- [Timber](https://github.com/JakeWharton/timber) - Une bibliothèque pour permettre de logger.

## Architecture
Leboncoin Test Junior est basé sur l'architecture MVVM, le Repository pattern et de la Clean Architecture.
L'utilisation de la Clean architecture permets de pouvoir faire évoluer rapidement l'application rapidement et de façon simple.

## Features
- Utiliser un [Pager](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) pour rendre plus fluide le chargement de la liste d'items. 
- Ajouter des Tests Unitaires, des Tests d'Intégrations, des Tests End-to-End, etc. Pour éviter les régressions, assurer le bon fonctionnement de l'application malgré les modifications apportées dans le temps, etc, 
  ceci est un point en cours d'apprentissage, car cela me semble important pour le bon fonctionnement d'une application à long terme.
- Ajouter l'écran de détail d'un item.

## Pourquoi vous rejoindre ?
Pouvoir participer à un projet d'ampleur avec une équipe qualifiée qui peut m'accompagner et me permettre d'apprendre et de monter en compétences.
Une des raisons pour laquelle je veux travailler avec des personnes plus expérimentées, c'est de pouvoir aborder des sujets importants en développement tel que cité précédemment la partie des tests qui me parait important et etc.

## Conclusion
Cela m'a permis de me challenger à faire une application dans un temps imparti avec des consignes claires. 
Mettre en pratique mes connaissances et mon expérience en y installant une architecture qui peut permettre de rajouter des nouvelles fonctionnalités de façon simple et rapide sans 
impacter l'existant.




