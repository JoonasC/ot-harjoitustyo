# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa MVC suunnitelumallia, eli se on jaettu kolmeen eri osaan: malleihin, jotka tallentavat sivun tilan, näkymiin jotka toteuttavat JavaFX:llä sivun visuaaliset elementit ja ohjaajiin, jotka sisältävät sivun logiikan sekä päivittävät mallia.

Lisäksi ohjelma sisältää myös data malleja, jotka kuvaavat asioita joita ohjelma käsittelee (tässä tapauksessa kontakteja), dialogeja jotka ovat MVC mallille ulkoisia ponnahdusikkunoita, joilla ei tarvitse olla pysyvää tilaa, reitittimen, joka sisältää logiikan jolla pystyy vaihtamaan sivua, ja pääluokan joka käynnistää ohjelman.



Ohjelman pakkausrakenne on seuraavanlainen:

![](https://raw.githubusercontent.com/JoonasC/ot-harjoitustyo/master/dokumentaatio/kuvat/Pakkausrakenne.png)



## Päätoiminnallisuudet

### Sisäänkirjautuminen

![](https://raw.githubusercontent.com/JoonasC/ot-harjoitustyo/master/dokumentaatio/kuvat/Sis%C3%A4%C3%A4nkirjautumis-sekvenssikaavio.png)