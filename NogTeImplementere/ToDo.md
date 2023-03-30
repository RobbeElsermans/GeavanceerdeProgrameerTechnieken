# ToDo

- Abstract factory
- Singleton Object
- 1 data oriented class
- Input abstraction
- 3-level of classes
- Stopwatch for gameloop
- 2D representation of an enemy
- 2D representation of the player
- 2D representation of the bullet enemy/player
- 2D representation of the obstacles
- 2D representation of the powerups/downs
- Collision with edge of screen
- Screen must be calibrated with default settings
- Config_file of the game
- Config_file of the gtx of 2D
- A score indication
- A Health indication
- Create Javadoc

 ## Game mechanics
 Het spel start met een knop (main screen) waarop de speler kan starten.

 Wanneer het spel start, start de speler in het midden van het speelveld. De enemys starten bovenaan.

 De enemys gaan gespawnd worden met een 5*11 tabel vorm (5 rijen en 11 kolommen).

 ```
 xxxxxxxxxxx
 xxxxxxxxxxx
 xxxxxxxxxxx
 xxxxxxxxxxx
 xxxxxxxxxxx
 ```

 Ze gaan van rechts naar links en wanneer er 1 enemy de zijkant raakt, gaan ze 1 stap naar beneden. Dan gaan ze van rechts naar links om dan weer hetzelfde te doen.

 Zowel enemys als de player kunnen projectielen afvuren. Een random enemy zal een projectiel afvuren richting de player.

 De player kan om de x milliseconden een pijn afvuren.

 De objecten die er staan om de enemy te beschermen, hebben een life van 10. Ze kunnen zowel door de enemy als door de player geraakt worden.

 Als er een enemy in slaagt om op dezelfde hoogte te komen als het schip, is het GAME OVER.

 De speler heeft 3 levens. Als ze alle 3 op zijn, GAME OVER.

 Wanneer de speler een enemy dood, zullen de enemys versnellen.

 Als een player al de enemys dood, komt er een 2de level waarbij de enemys in een ander patroon komen.

```
xx xx xx xx
xxxxxxxxxxx
    xxx
xxx xxx xxx
xxxxxxxxxxx
```

Er wordt een score bijgehouden. Er wordt 10 punten gegeven voor het doden van 1 enemy. Er komt ook een bonus bij van 1.25 (25%) wanneer de speler het level binnen de 5min uitspeelt. Het 2de level krijgt de speler 12 punten per enemy die hij dood.
