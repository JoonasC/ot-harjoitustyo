# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa MVC suunnitelumallia, eli se on jaettu kolmeen eri osaan: malleihin, jotka tallentavat sivun tilan, näkymiin jotka toteuttavat JavaFX:llä sivun visuaaliset elementit ja ohjaajiin, jotka sisältävät sivun logiikan sekä päivittävät mallia.

Lisäksi ohjelma sisältää myös data malleja, jotka kuvaavat asioita joita ohjelma käsittelee (tässä tapauksessa kontakteja), dialogeja jotka ovat MVC mallille ulkoisia ponnahdusikkunoita, joilla ei tarvitse olla pysyvää tilaa, reitittimen, joka sisältää logiikan jolla pystyy vaihtamaan sivua, ja pääluokan joka käynnistää ohjelman.



Ohjelman pakkausrakenne on seuraavanlainen:

![](https://raw.githubusercontent.com/JoonasC/ot-harjoitustyo/master/dokumentaatio/kuvat/Pakkausrakenne.png)



## Käyttöliittymä

Käyttöliittymä sisältää kolme erillistä sivua:

- Sisäänkirjautumissivu
- Uuuden käytttäjän luomissivu
- Yhteystietojen managointisivu



Kuten aiemmin kuvattu, jokainen sivu muodostuu kolmesta osasta: mallista, näkymästä ja ohjaajasta:

- Malli sisältää sivun tilan, esim. sisäänkirjautumissivun suhteen malli sisältää tiedon siitä:
  - Onko virheviestiä joka pitäisi näyttää käyttäjälle.
  - Onko käyttäjä kirjautunut sisään.
  - Mikä on sisäänkirjautuneen käyttäjän nimi.
- Näkymä toteuttaa sivun visuaaliset elementit JavaFX:llä, se sisältää oman scene olionsa, tiedon siitä kuinka suuri ikkunan täytyy olla kun sivu näytetään, tiedon siitä mikä ikkunan otsikon täytyy olla kun sivu näytetään sekä renderöintilogiikan (hakee mallista tilan ja renderöi sivun sen mukaisesti) ja logiikan joka kutsuu ohjaajaa kun käyttäjä käyttää sivua (esim. painaa nappia).
- Ohjaaja sisältää sivun logiikan ja päivittää mallia käyttäjän toimien mukaisesti, esim. sisäänkirjautumissivun suhteen ohjaaja:
  - Toteuttaa sisäänkirjautumislogiikan (katsoo onko käyttäjä olemassa, ja päivittää mallia sen mukaisesti).
  - Toteuttaa uloskirjautumislogiikan (resetoi mallin takaisin alkutilaan).



Toinen käyttöliittymälle tärkeä osa on reititin, jonka tehtävänä on vaihtaa sivua.

Kun reitin vaihtaa sivua, se:

- Katsoo onko sivu suojattu (vaatii sisäänkirjautumista), ja jos on, tarkistaa onko käyttäjä sisäänkirjautunut. Jos käyttäjä ei ole sisäänkirjautunut, reititin ei tee mitään.
- Löytää sivun näkymän instanssin.
- Ottaa sivun näkymästä scene olion, tiedot ikkunan koosta sekä otsikosta ja configuroi stagen niiden mukaisesti.

Lisäksi reititin voi myös kuljettaa tietoa sivujen välillä, esim. kun käyttäjä kirjautuu sisään ja reititin vaihtaa sivua sisäänkirjautumissivusta yhteystietojen managointisivuun, se vie sisäänkirjautumissivusta tiedon siitä mikä käyttäjä on kirjautunut sisään yhteystietojen managointisivuun.



Lisäksi, käyttöliittymä sisältää myös MVC mallille ulkoisia ponnahdusikkunoita, kuten hälytysikkunoita ja yhteystiedon luomis/muokkaus ikkunan. Nämä ovat kertakäyttöisiä, eivätkä siten tarvitse pysyvää tilaa.



## Datamalli

Ohjelma esittää yhteystietoja `Contact` olioina, nämä oliot sisältävät yhteystiedon nimen, puhelinnumeron ja sähköpostiosoitteen.



## Tietojen pysyväistallennus

Tietojen tallennuksesta ja lataamisesta huolehtivat sivujen ohjaajat. Yhteystiedot tallennetaan käyttäjälle luodun kansion sisälle JSON tiedostoon.



## Päätoiminnallisuudet

### Sisäänkirjautuminen

![](https://raw.githubusercontent.com/JoonasC/ot-harjoitustyo/master/dokumentaatio/kuvat/Sis%C3%A4%C3%A4nkirjautumis-sekvenssikaavio.png)

**Huom:** Ylläolevassa sekvenssikaaviossa on pieni virhe, `Router` ei pyydä `MainModelilta` kontakteja, `MainView` pyytää.