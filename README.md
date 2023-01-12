# Design Patterns, Refactoring and Testing 

>**Project**
><br />
>Course Unit: [Laboratório de Desenho e Teste de Software](https://sigarra.up.pt/feup/pt/ucurr_geral.ficha_uc_view?pv_ocorrencia_id=501676 "Software Design and Testing Laboratory"), 2nd year 
><br />
>Course: **Informatics and Computer Engineering** 
><br />
> Faculty: **FEUP** (Faculty of Engineering of the University of Porto)
><br/>
> Report: [Report.md](./docs/README.md)
><br/>
> Evaluation: **19**/20


## Project Goals

The main goal in five words:
```
Write clean and good code
```

Deploy a simply game to explore some of the existing design patterns in **Java**.
Some of the design patterns used are **Command**, **Factory** and  **Singleton**.
To check every situation where the design pattern was used, check the [Report](./docs/README.md) file.

The code were structured based on the **MVC architecture** and **SOLID** principles were followed.

To make the code even cleaner, some **refactoring techniques** were used for the refactorings made.

Another big goal of the project was to write appropriate tests for the code.
To do this, **Spock** was used.


## The game

<img align="center" src="./docs/images/mockups/Game.gif" alt="drawing" width="200" margin="center"/>

The game is inspired by the Flappy Bird.
The objective of the game is to maneuver a small tiger through a series of walls coming from the right and pass through the gap to score a point.
The player can collect collectables, that give points or start a god mode, where the gap between the walls is increased, making the game easier.

## Code UML

<img width="100%" src="./docs/images/UML/structure.drawio.png" />

### Tecnologies Used

<div>
	<img height="40" src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png" alt="Java" title="Java" />
	<img height="40" src="https://user-images.githubusercontent.com/25181517/183892787-bca94a0e-ffcb-4eeb-8137-e0fc4e446c25.png" alt="Groovy" title="Groovy" />
	<img height="35" src="https://user-images.githubusercontent.com/25181517/202540780-999f189c-341a-438e-a7e3-b0838fda6645.png" alt="Spock" title="Spock" />
	<img height="45" src="https://user-images.githubusercontent.com/25181517/183892181-ad32b69e-3603-418c-b8e7-99e976c2a784.png" alt="mocikto" title="mocikto" />
</div>
