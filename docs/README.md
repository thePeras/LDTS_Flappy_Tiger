## LPOO_<T><G> - <PROJECT NAME>

> Include here one or two paragraphs explaining the main idea of the project, followed by a sentence identifying who the authors are.

**Example**:

In this exciting platform game you can help KangarooBoy save the world, by collecting all the coins throughout ten different levels in which you will […].

This project was developed by *John Doe* (*john.doe*@fe.up.pt) and *Jane Doe* (*jane.doe*@fe.up.pt) for LPOO 2018⁄19.

### IMPLEMENTED FEATURES

> This section should contain a list of implemented features and their descriptions. In the end of the section, include two or three screenshots that illustrate the most important features.

**Examples**:

- **Jumping** - The game character will jump when the space bar key is pressed.
- **Getting hidden coins** - When the game character hits a platform from below (by jumping beneath it) it will smash that segment of the platform and will get any coins that may exist hidden there.

### PLANNED FEATURES

> This section is similar to the previous one but should list the features that are not yet implemented. Instead of screenshots you should include GUI mock-ups for the planned features.

### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:

------

#### Lanterna Library Facade

**Problem in Context**

The game shouldn't depend on the specific implementation of the GUI library (Lanterna). The appllication UI framework should be easily interchangeable without affecting the rest of the code.

**The Pattern**

The Facade pattern was ideal for this problem, as it provides a unified interface to a set of diverse interfaces in a choosed library. This way, the rest of the code doesn't need to know the specifics of the library, and can be easily changed.

**Implementation**

![img](./images/Facade%20Pattern.png)

These classes can be found in the following files:

- [GUI](../src/main/java/feup/ldts/flappy/gui/GUI.java)
- [LanternaGUI](../src/main/java/feup/ldts/flappy/gui/LanternaGUI.java)
- [Game](../src/main/java/feup/ldts/flappy/Game.java)

**Consequences**

By declaring a unified interface, the code is more readable and maintainable.
Another point is that we only need to implement the methods that we need and not the whole GUI library.
The code is also more flexible by the possibility of changing the GUI library.

------

#### Game State

**Problem in Context**

It easy to see that the whole game has several states, such as the main menu, the game itself, the game over screen, leaderboard screen, etc. So, the program should be able to handle these states in a simple and efficient way.
Also we need to easily change the game state when the user interacts with the game. For example, if the player has died, the game state should be set to the game over screen.

**The Pattern**

The State pattern allows the program to change the behavior of the application depending on the current state. For example, the main controller and viewer is defined depending on the current state and each state has its own controller and viewer.
Also the fame can easily change the state by calling the setState method.

**Implementation**

![img](./images/State%20Pattern.png)

**Consequences**

The game state is defined in the Game class. This is usefull because we can change the state of the game by calling the setState method. 
The downside is that we need to have access to the Game class context in order to use the setState method.

------

#### Singleton Sound Manager

**Problem in Context**

Music and sound effects are a shared resource amond the game states and classes. Dealing with sound effects in the independet classes is not a good idea because it would be hard to manage and change the sound effects. Also, the music should be played in the background and not be interrupted by independet game elements.
So, the music and sound effects should be managed by a single class. 
This can be done by using a singleton pattern. In this pattern we only need to create a class to be responsible for playing the music and sound effects. 

**The Pattern**

Singleton pattern ensures that only one instance of the class managing the music and sound effects is created. This object is also accessible from everywhere.
In resume, there is onyl a single point to access the music and sound effects.

**Implementation**

![img](./images/Singleton%20Pattern.png)

**Consequences**

One big good consequence of using the singleton pattern is that the code would be isolated from the music and sound effects and we can be easily access them from anywhere in the code. 
Also, because there is only a single object of the class, it is imposible to have two background musics playing at the same time, for example.
Changing the music and sound effects turns out to be a easy task now.

------


### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%