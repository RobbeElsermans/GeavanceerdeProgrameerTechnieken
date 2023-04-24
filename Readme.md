# Space Invaders
Gemaakt door Robbe Elsermans

## Spel uitleg
Het bekende space invaders spel, gemaakt in java. Het spel bestaat uit 1 speler die tegen meerdere vijanden moet vechten.

Zowel de speler als de vijanden kunnen schieten. Wanneer de speler bepaalde acties heeft voltooit, krijgt hij hiervoor bonussen die de speler kan oprapen. Als de speler uitmundig bezig is, komt er zelfs een grootere vijand die zeer moeilijk te raken is! Maar wanneer de speler deze raakt, is het de moeite waard!

## Vijand
Een vijand bevat 1 of meerdere levels. Het huidige leven van een vijand wordt aangegeven d.m.v. een sprite.

Een enemy zal op willekeurige basis een kogel afvuren. Hier is dus geen patroon in te vinden.

Wanneer men een vijand raakt, krijgt de speler hier 10 punten voor.

## Speciale vijand
De speciale vijand is een vijand die helemaal vanboven het spel zal rondzweven. Het is een vijand die zeer moeilijk te raken is. Deze heeft standaard een leven van 1 en is dus in 1 kogel dood.

Wanneer een speciale vijand tevoorschijn komt, zal dit altijd in de tegenovergestelde richting gebeuren. Wanneer bv. de vijand links tevoorschijn kwam, zal dit volgende keer rechts zijn.

De speciale vijand komt enkel en alleen als de speler 5 keer een vijand heeft kunnen raken.

Wanneer men nu zo'n speciale vijand kan raken, krijgt de speler hier 100 punten voor per speciale vijand er is neergeschoten.

## Obstakel
Een obstakel is een vijlige plaats voor de speler. Hier kan de speler achter schuilen wanneer de vijanden te hard aan het schieten zijn of omdat de speler even moet uitrusten.

Zo'n obstakel is natuurlijk niet gemaakt uit titanium en zal dus ook afzien wanneer er op geschoten wordt. Zowel de speler als de vijand zijn kogels, kunnen een obstakel kapot schieten.

## Bonus
In het spel zijn er bonussen die kunnen vallen. Deze worden gegenereerd wanneer de speler bepaalde zaken heeft volbracht.
We hebben een **LIFE** en een **SHOOT_SPEED** bonus. Enkel de **SHOOT_SPEED** kan een bonus zijn die de speler kan benadelen.

Een bonus zal op een random locatie naar beneden vallen en het is aan de speler om de keuzen te maken om de bonus op te nemen of om de vijand dood te schieten.

Om de bonussen te onderscheiden, hebben ze ook verschillende kleuren.

| Kleur                                             | bonus type            |
| :------------------------------------------------ | :-------------------- |
| <b style="color:rgb(255,0,127)">donker roos</b>   | LIFE                  |
| <b style="color:rgb(128,128,128)">grijs</b>      | SHOOT_SPEED negatief  |
| <b style="color:rgb(102,178,255)">baby blauw</b>  | SHOOT_SPEED positief  |

### Generatie bonussen

| Soort bonus | Generatie voorwaarde                                     | bonus waarde              |
| :---------- | :------------------------------------------------------- | :------------------------ |
| LIFE        | Telkens wanneer een speler 2 levens verliest.            | 1 leven extra             |
| LIFE        | Telkens wanneer een speler een score van 100 bereikt.    | 1 leven extra             |
| SHOOT_SPEED | Telkens wanneer een speler 10 keer een enemy neerschiet. | 0.5 meer kogel snelheid   |
| SHOOT_SPEED | Telkens wanneer een speler 20 keer er naast schiet.      |  0.5 minder kogel snelheid|

## score
De score wordt als volgt berekend:

```
Score = shotsHits()*10 - shotsMissed()*10 + (damageDone()/10)*10 + bigEnemyHit()*100
```
De speler krijgt dus 10 punten per vijanden geraakt. Als een speler een schot mist, gaan hier, per schot gemist, 10 punten af. Als laatste tellen we er 100 punten bij, per speciale vijand geraakt, op.


# graphics-systeem

Het graphics-systeem kan onafhankelijk van de spel logica opgebouwd worden. Wanneer men een nieuw graphics-systeem wilt ontwerpen, moet er overgeërft worden van AFactory.

## Java2D

Er is een implementatie voorzien om met Java2D het spel te visualiseren.
Hierbij wordt een configuratiebestand *gfx_config.txt* gebruikt die de objecten een dimensie geeft.

> :rotating_light: De dimensie moet gelijk of kleiner zijn dan de dimensie gedefiniëerd in *game_config.txt*.

Wanneer men Java2D als graphics-systeem gebruiken, gelieven dan volgende parameters in het *game_config.txt* bestand te wijzigen naar:
```
# fps -> 40
# game_width -> 60
# game_height -> 40
```
