# Yhteystietomanageri - Vaatimusmäärittely

## Kuvaus

Yhteystietomanageri on sovellus jolla pystyy pitämään kirjaa omista yhteystiedoistaan. Sovellukseen pystyy tallentamaan henkilön nimen, sekä puhelinnumeron ja sähköpostiosoitteen. Sovellus tulee tukemaan monia käyttäjiä.



## Käyttäjät

Sovelluksessa tulee olemaan vain yksi käyttäjärooli - normaali käyttäjä.



## Käyttöliittymä luonnos

![](https://raw.githubusercontent.com/JoonasC/ot-harjoitustyo/master/dokumentaatio/kuvat/K%C3%A4ytt%C3%B6liittym%C3%A4-luonnos.jpg)

Sovellus avautuu kirjautumisnäkymään, josta voi siirtyä uuden käyttäjän luomisnäkymään tai kirjautumalla sisään päänäkymään. Päänäkymässä voi lisää kontakti / muokkaa kontaktia nappeja painamalla siirtyä kontaktin lisäys / muokkaus näkymään, mistä voi siirtyä takaisin päänäkymään, kun kontakti on lisätty tai muokattu.



## Toiminnallisuus

### Ennen kirjautumista

- Käyttäjä voi luoda tunnuksen
  - Käyttäjätunnuksen pitää olla uniikki ja vähintään 3 merkkiä, salasanan täytyy olla vähintään 6 merkkiä ja sisälttää erikoismerkkejä.
- Käyttäjä voi kirjautua sisään
  - Käyttäjätunnuksen pitää olla olemassa ja salasanan oikein



### Kirjautumisen jälkeen

- Käyttäjä näkee kontaktiensa nimet, sähköpostiosoitteet ja puhelinnumerot listassa
- Käyttäjä voi luoda kontaktin
  - Kontakti voidaan luoda painamalla "Luo kontakti" nappia, mikä avaa kontaktin luomisikkunan
- Käyttäjä voi muokata kontaktia
  - Kontaktia voidaan muokata aktivoimalla "Muokkaa kontaktia" nappi, ja painamalla haluttua kontaktia listassa, milloin kontaktin muokkaamisikkuna avautuu
- Käyttäjä voi poistaa kontaktin
  - Kontaktin poistaminen tehdään samalla tavalla, kuin muokkaaminen mutta se ei avaa uutta ikkunaa
- Käyttäjä voi kirjautua ulos

