# Jeu de morpion
Projet réalisé par **Khalil Mohammad** et **Omar Aldroubi** 
Implémentation complète d’un jeu de morpion et de jeu de Nim en Java avec une logique d’intelligence simple détectant les cas gangants pour empêcher l’adversaire de gagner.

Les classes exécutables sont :
* package games.nim :
	* games.nim.DemoNim : permet de jouer une partie de Nim à 2 joueurs 
	* games.nim.TestNim : lance les tests unitaires sur la classe Nim

* package games.tictactoe
	- games.tictactoe.DemoTicTacToe : permet de même de jouer 
	  au jeu de morpion   	   
	- games.tictactoe.TestTicTacToe : lance les tests unitaires
	  sur la classe TicTacToe 

* package games.factoredgames :
	- games.factoredgames.DemoNim : version optimisé du jeu de nim

	- games.factoredgames.DemoTicTacToe : version optimisé du jeu de morpion

	- games.factoredgames.TestAbstractGame : lance les tests sur 
	  la classe  AbstractGame
	
	- games.factoredgames.TestNimEtTicTacToe : lance les tests
	  sur les classes Nim et TicTacToe 
	- games.factoredgames.TestTicTacToeWithHints : lance les tests
	  sur la classe TicTacToeWithHints

* package games.genericgames :
	- games.genericgames.DemoNim
	- games.genericgames.DemoTicTacToe
	- games.genericgames.TestGenericGames : lance les tests sur les 
	  classes du package
